package org.example;

import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
import java.util.List;
public class Library {

    private List<Book> books;
    private List<Book> loanedBooks;

    public Library(){
        books = new ArrayList<>();
        loanedBooks = new ArrayList<>();

    }

    public void displayBooks() {
        System.out.println("Library books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayLoanedBooks() {
        System.out.println("Loaned books:");
        for (Book book : loanedBooks) {
            System.out.println(book);
        }
    }


    public boolean loanBook(int bookNumber, String borrowerName) {
        for (Book book : books) {
            if (book.getNumber() == bookNumber) {
                if (!book.isLoaned()) {
                    book.setLoaned(true);
                    book.setLoanedTo(borrowerName);
                    loanedBooks.add(book);
                    books.remove(book);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public boolean returnBook(int bookNumber) {
        // Search the loanedBooks list for the book with the specified number
        for (Book book : loanedBooks) {
            if (book.getNumber() == bookNumber) {
                // Set the book's isLoaned attribute to false and loanedTo attribute to null
                book.setLoaned(false);
                book.setLoanedTo(null);
                // Move the book back to the books list
                books.add(book);
                loanedBooks.remove(book);
                return true;
            }
        }
        // If the book wasn't found in the loanedBooks list, it hasn't been loaned out
        return false;
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

    public void saveLibrary() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("books_data.csv"))) {
            // Write header row
            writer.writeNext(new String[] { "Book Number", "Title", "Author", "Is Loaned", "Loaned To" });

            // Write each book from both lists to the file
            for (Book book : books) {
                writer.writeNext(new String[] { String.valueOf(book.getNumber()) , book.getTitle(), book.getAuthor()
                        , Boolean.toString(book.isLoaned()), book.getLoanedTo() });
            }
            for (Book book : loanedBooks) {
                writer.writeNext(new String[] { String.valueOf(book.getNumber()), book.getTitle(), book.getAuthor()
                        , Boolean.toString(book.isLoaned()), book.getLoanedTo() });
            }

            System.out.println("Library saved to books_data.csv.");
        } catch (IOException e) {
            System.err.println("Error saving library: " + e.getMessage());
        }
    }
}
