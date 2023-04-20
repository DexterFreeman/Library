package org.example;

public class Book {
    private int Number;
    private String title;
    private String Author;
    private String Genre;
    private String SubGenre;
    private String Publisher;

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
        Number = number;
        this.title = title;
        Author = author;
        Genre = genre;
        SubGenre = subGenre;
        Publisher = publisher;
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
}
