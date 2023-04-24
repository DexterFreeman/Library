package org.example;

public class Book {
    private int Number;
    private String title;
    private String Author;
    private String Genre;
    private String SubGenre;
    private String Publisher;
    private boolean isLoaned;
    private String loanedTo;

    @Override
    public String toString() {
        return "Book{" +
                "Number=" + Number +
                ", title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", Genre='" + Genre + '\'' +
                ", SubGenre='" + SubGenre + '\'' +
                ", Publisher='" + Publisher + '\'' +
                '}';
    }

    public Book(int number, String title, String author, String genre, String subGenre, String publisher) {
        this.Number = number;
        this.title = title;
        this.Author = author;
        this.Genre = genre;
        this.SubGenre = subGenre;
        this.Publisher = publisher;
        this.isLoaned = false;
        this.loanedTo = "";
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getSubGenre() {
        return SubGenre;
    }

    public void setSubGenre(String subGenre) {
        SubGenre = subGenre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public String getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }
}
