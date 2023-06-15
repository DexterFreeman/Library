package org.example;

public class Book {
    private int Number;
    private String Title;
    private String Author;
    private String Genre;
    private String SubGenre;
    private String Publisher;
    private boolean isLoaned;
    private String loanedTo;
    private int loanCount;

    public Book(int bookNumber, String title, String author, String genre) {
        this.Number = bookNumber;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
    }

    public int getUniqueId() {
        Library library = Library.getInstance();
        int randomInt = (int) (Math.random() * 9999);
        if (library.getBookByNumber(randomInt) != null) {
            getUniqueId();
        }
        return randomInt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Number=" + Number +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Genre='" + Genre + '\'' +
                ", SubGenre='" + SubGenre + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", isLoaned=" + isLoaned +
                ", loanedTo='" + loanedTo + '\'' +
                ", loanCount=" + loanCount +
                '}';
    }

    public Book(int number, String title, String author, String genre, String subGenre, String publisher) {
        this.Number = number;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
        this.SubGenre = subGenre;
        this.Publisher = publisher;
        this.isLoaned = false;
        this.loanedTo = "";
        this.loanCount = 0;
    }

    public Book(int number, String title, String author, String genre, String subGenre, String publisher, boolean isLoaned, String loanedTo, int loanCount) {
        Number = number;
        this.Title = title;
        Author = author;
        Genre = genre;
        SubGenre = subGenre;
        Publisher = publisher;
        this.isLoaned = isLoaned;
        this.loanedTo = loanedTo;
        this.loanCount = loanCount;
    }

    public Book() {
        this.Number = getUniqueId();
        this.Author = null;
        this.Genre = null;
        this.SubGenre = null;
        this.Publisher = null;
        this.isLoaned = false;
        this.loanedTo = null;
        this.loanCount = 0;
    }


    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    public void incrementLoanCount() {
        this.loanCount++;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
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
