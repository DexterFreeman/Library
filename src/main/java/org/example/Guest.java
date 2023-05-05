package org.example;

import java.util.List;

public class Guest extends User{
    private List<Book> loanedBooks;


    public Guest(String name, String password) {
        super(name, password);
        this.loanedBooks = null;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void loanBook(Book book){
        if(loanedBooks.size() >= 3){
            System.out.println("You cannot loan more than 3 books.");
        }
        else{
            loanedBooks.add(book);
        }

    }
    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
}
