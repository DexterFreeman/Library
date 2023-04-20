package org.example;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Library {

    private List<Book> books;
    private List<Book> loanedBooks;

    public Library(){
        books = new ArrayList<>();
        loanedBooks = new ArrayList<>()

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


    public boolean loanBook(int bookNumber){
        Iterator<Book> iter = books.iterator();
        while (iter.hasNext()){
            Book book = iter.next();
            if (book.getNumber() == (bookNumber)){
                iter.remove();
                loanedBooks.add(book);
                System.out.println("Book " + bookNumber + " has been loaned.");
                return true;
            }
        }
        System.out.println("Book " + bookNumber + " not found.");
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
}
