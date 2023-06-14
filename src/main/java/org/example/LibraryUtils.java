package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class LibraryUtils {

    public static Scanner scanner = new Scanner(System.in);


    public static void startLibrary(User loggedInUser, Library library){
        boolean exit = false;

        while (exit == false){
            int userChoice = 0;
            System.out.println("===================");
            System.out.println("1 - View all books");
            System.out.println("2 - View unloaned books");
            System.out.println("3 - View loaned books");
            System.out.println("4 - Loan a book");
            System.out.println("5 - Return a book");
            System.out.println("6 - Save & Exit");
            System.out.println("7 - Get book information by number");
            System.out.println("8 - View books by genre");
            userChoice = scanner.nextInt();
            if (userChoice < 8 || userChoice > 1){
                switch (userChoice){
                    case 1:
                        library.displayBooks();
                        library.displayLoanedBooks();
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        library.displayLoanedBooks();
                        break;

                    case 4:
                        System.out.println("Input name of person loaning book to:");
                        String name = scanner.next();
                        System.out.println("Input book number");
                        int bookNumber = scanner.nextInt();
                        library.loanBook(bookNumber, name);
                        break;

                    case 5:
                        System.out.println("Input book number");
                        int booknumber = scanner.nextInt();
                        library.returnBook(booknumber);
                        break;

                    case 6:
                        saveLibrary(library);
                        exit = true;
                        break;

                    case 7:
                        System.out.println("Input book number");
                        booknumber = scanner.nextInt();
                        Book book = library.getBookByNumber(booknumber);
                        System.out.println(book.toString());
                        System.out.println("The books popularity is: " + library.getPopularity(booknumber));
                        break;
                    case 8:
                        System.out.println("Input genre to search by:");
                        String genre = scanner.nextLine();
                        library.displayBooksByGenre(genre);
                }
            }
            else {
                System.out.println("Error, input was not a valid option. Try again.");
            }

        }
    }
    public static void saveLibrary(Library library) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter("books_data.csv"));

            String[] header = {"Book Number", "Title", "Author", "Genre", "Is Loaned", "Loaned To", "Loan Count"};
            writer.writeNext(header);

            for (Book book : library.getBooks()) {
                String[] bookData = {String.valueOf(book.getNumber()), book.getTitle(), book.getAuthor(), book.getGenre(),
                        String.valueOf(book.isLoaned()), book.getLoanedTo(), String.valueOf(book.getLoanCount())};
                writer.writeNext(bookData);

            }

            for (Book book : library.getLoanedBooks()) {
                String[] bookData = {String.valueOf(book.getNumber()), book.getTitle(), book.getAuthor(), book.getGenre(),
                        String.valueOf(book.isLoaned()), book.getLoanedTo(), String.valueOf(book.getLoanCount())};
                writer.writeNext(bookData);
                System.out.println(bookData);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving library to file: " + e.getMessage());
        }
    }


    public static void loadLibrary(Library library) {
        try {
            CSVReader reader = new CSVReader(new FileReader("books_data.csv"));
            String[] header = reader.readNext(); // skip header row
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int bookNumber = Integer.parseInt(nextLine[0]);
                String title = nextLine[1];
                String author = nextLine[2];
                String genre = nextLine[3];
                boolean isLoaned = Boolean.parseBoolean(nextLine[4]);
                String loanedTo = nextLine[5];
                int loanCount = Integer.parseInt(nextLine[6]);
                Book book = new Book(bookNumber, title, author, genre);
                book.setLoaned(isLoaned);
                book.setLoanedTo(loanedTo);
                book.setLoanCount(loanCount);

                if (isLoaned) {
                    library.addBookToLoanedBooks(book);
                } else {
                    library.addBookToBooks(book);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading library from file: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
