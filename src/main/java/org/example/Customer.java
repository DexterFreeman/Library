package org.example;

import java.util.List;

public class Customer extends User {

    private List<Book> loanedBooks;

    public Customer(String name, String password) {
        super(name, password);
        this.loanedBooks = null;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void loanBook(Book book) {
        if (loanedBooks.size() >= 5) {
            System.out.println("You cannot loan more than 5 books.");
        } else {
            loanedBooks.add(book);
        }

    }

    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
}
