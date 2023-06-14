package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AdminSystem {

    private Admin loggedInAdmin;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = Library.getInstance();

    public void startAdminSystem(Library library){
        boolean exit = false;
        while (!exit){
            System.out.println("1 - Edit a book");
            System.out.println("2 - Delete a book");
            System.out.println("3 - Add a book");
            System.out.println("4 - Register a new user/guest");
            System.out.println("5 - Edit a user/guest");
            System.out.println("6 - Delete a user/guest");
            System.out.println("7 - Quit");
            int userInput = scanner.nextInt();
            String userInputStr = scanner.next();
            switch (userInput){
                case 1:
                    System.out.println("Input book number of the book you wish to edit.");
                    userInput = scanner.nextInt();
                    editBook(library.findBook(userInput));
                    break;
                case 2:
                    System.out.println("Input the number of the book you wish to delete.");
                    userInput = scanner.nextInt();
                    library.deleteBook(userInput);
                    break;
                case 3:
                    library.addBookToBooks(createBook());
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Error, not a valid option. please try again");

            }
        }
    }

    public Book createBook(){
        String userInputStr;
        Book newBook = new Book();
        System.out.println("What is the books name?");
        userInputStr = scanner.next();
        newBook.setTitle(userInputStr);
        System.out.println("Who is the author?");
        userInputStr = scanner.next();
        newBook.setAuthor(userInputStr);
        System.out.println("What is its genre?");
        userInputStr = scanner.next();
        newBook.setGenre(userInputStr);
        System.out.println("What are its subgenre(s)");
        userInputStr = scanner.next();
        newBook.setSubGenre(userInputStr);
        System.out.println("Who is the publisher?");
        userInputStr = scanner.next();
        newBook.setPublisher(userInputStr);
        return newBook;
    }

    public Book editBook(Book bookToEdit){
        System.out.println("What would you like to edit?");
        System.out.println("1 - Title");
        System.out.println("2 - Author");
        System.out.println("3 - Genre");
        System.out.println("4 - Subgenre");
        System.out.println("5 - Publisher");
        System.out.println("6 - Quit");
        int userInput = scanner.nextInt();
        String userInputStr;
        switch (userInput){
            //Will eventually add user input validation, just getting it to work
            case 1:
                System.out.println("Input new title:");
                userInputStr = scanner.next();
                bookToEdit.setTitle(userInputStr);
                break;
            case 2:
                System.out.println("Input new author:");
                userInputStr = scanner.next();
                bookToEdit.setAuthor(userInputStr);
                break;
            case 3:
                System.out.println("Input new Genre");
                userInputStr = scanner.next();
                bookToEdit.setGenre(userInputStr);
            case 4:
                System.out.println("Input new subgenre");
                userInputStr = scanner.next();
                bookToEdit.setSubGenre(userInputStr);
            case 5:
                System.out.println("Input new publisher");
                userInputStr = scanner.next();
                bookToEdit.setPublisher(userInputStr);
            case 6:
                System.out.println("Quitting");
                break;

            default:
                System.out.println("Error, invalid input");
                editBook(bookToEdit);


        }
        return bookToEdit;
    }

    public Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }

    public void setLoggedInAdmin(Admin loggedInAdmin) {
        this.loggedInAdmin = loggedInAdmin;
    }

    public AdminSystem(Admin loggedInAdmin) {
        this.loggedInAdmin = loggedInAdmin;
    }
}
