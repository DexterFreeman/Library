package org.example;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library library = null;
    private List<Book> books;
    private List<Book> loanedBooks;

    public Library() {
        books = new ArrayList<>();
        loanedBooks = new ArrayList<>();

    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean deleteBook(int bookNumber) {
        Book book = findBook(bookNumber);
        if (book == null) {
            return false;
        }
        books.remove(book);
        loanedBooks.remove(book);
        return true;

    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void addBookToBooks(Book book) {
        this.books.add(book);
    }

    public void addBookToLoanedBooks(Book book) {
        this.loanedBooks.add(book);
    }

    public void setLoanedBooks(List<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public int getPopularity(int loanCount) {
        switch (loanCount / 5) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                return 5;
        }
    }

    public Book getBookByNumber(int number) {
        for (Book book : books
        ) {
            if (book.getNumber() == number) {
                return book;
            }
        }
        System.out.println("No book found.");
        return null;
    }

    public void displayBooksByGenre(String genre) {
        boolean bookfound = false;
        for (Book book : books) {
            if (book.getGenre() == genre) {
                bookfound = true;
                System.out.println(book.toString());

            }
        }
        if (!bookfound) {
            System.out.println("No book were found for genre: " + genre);
        }
    }

    public void displayBooks() {
        System.out.println("Library books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBookInformation(int bookNumber) {
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
        if (book != null && book.isLoaned() == false) {
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

    public static synchronized Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }


}
