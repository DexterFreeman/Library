package org.example;

import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Library {

    private List<Book> books;
    private List<Book> loanedBooks;

    public Library(){
        books = new ArrayList<>();
        loanedBooks = new ArrayList<>();

    }

    public void displayBooksByGenre(String genre){
        boolean bookfound = false;
        for (Book book: books) {
            if (book.getGenre() == genre){
                bookfound = true;
                System.out.println(book.toString());

            }
        }
        if(!bookfound){
            System.out.println("No book were found for genre: " + genre);
        }
    }

    public void displayBooks() {
        System.out.println("Library books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBookInformation(int bookNumber){
        Book book = findBook(bookNumber);
        System.out.println(book.toString());
    }

    public void displayLoanedBooks() {
        System.out.println("Loaned books:");
        for (Book book : loanedBooks) {
            System.out.println(book);
        }
    }
    public Book findBook(int bookNumber) {
        for (Book book : books) {
            if (book.getNumber() == bookNumber) {
                return book;
            }
        }
        for (Book book : loanedBooks) {
            if (book.getNumber() == bookNumber) {
                return book;
            }
        }
        return null;
    }


    public boolean loanBook(int bookNumber, String borrowerName) {
        Book book = findBook(bookNumber);
        book.toString();
        if (book != null && book.isLoaned() == false){
            book.setLoaned(true);
            book.setLoanedTo(borrowerName);
            loanedBooks.add(book);
            books.remove(book);
            return true;
        }
        return false;
    }
    public boolean returnBook(int bookNumber) {
        for (Book book : loanedBooks) {
            if (book.getNumber() == bookNumber) {
                book.setLoaned(false);
                book.setLoanedTo(null);
                books.add(book);
                loanedBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public void saveLibrary() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("books_data.csv"));

            String[] header = {"Book Number", "Title", "Author", "Genre", "Is Loaned", "Loaned To", "Loan Count"};
            writer.writeNext(header);

            for (Book book : books) {
                String[] bookData = {String.valueOf(book.getNumber()), book.getTitle(), book.getAuthor(), book.getGenre(),
                        String.valueOf(book.isLoaned()), book.getLoanedTo(), String.valueOf(book.getLoanCount())};
                writer.writeNext(bookData);

            }

            for (Book book : loanedBooks) {
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
    public void loadBooksFromCSV(){
        String line = "";
        String delimiter = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/books_data.csv"))){
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                int number = Integer.parseInt(fields[0]);
                String title = fields[1];
                String author = fields[2];
                String genre = fields[3];
                String subgenre = fields[4];
                String publisher = fields[5];
                Book book = new Book(number, title, author, genre, subgenre, publisher);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public void loadLibrary() {
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
                    loanedBooks.add(book);
                } else {
                    books.add(book);
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
