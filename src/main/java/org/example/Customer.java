package org.example;

import java.util.List;

public class Customer extends User {

    private List<Book> loanedBooks;
    public Customer(String name, String password){
        super(name, password);
        this.loanedBooks = null;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
}
