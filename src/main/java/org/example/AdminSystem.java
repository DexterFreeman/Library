package org.example;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class AdminSystem {

    private Admin loggedInAdmin;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = Library.getInstance();

    public void startAdminSystem(){
        boolean exit = false;
        while (!exit){
            System.out.println("1 - Edit a book");
            System.out.println("2 - Delete a book");
            System.out.println("3 - Add a book");
            System.out.println("4 - Register a new customer/guest");
            System.out.println("5 - Edit a customer/guest");
            System.out.println("6 - Delete a user/guest");
            System.out.println("7 - Quit");
            int userInput = scanner.nextInt();
            switch (userInput){
                case 1:
                    System.out.println("Input book number of the book you wish to edit.");
                    userInput = scanner.nextInt();
                    editBook(library.findBook(userInput));
                    break;
                case 2:
                    System.out.println("Input book number of the book you wish to delete.");
                    userInput = scanner.nextInt();
                    library.deleteBook(userInput);
                    break;
                case 3:
                    library.addBookToBooks(createBook());
                    break;

                case 4:
                   createUser();
                   break;

                case 5:
                    System.out.println("Input ID of the user you wish to edit");
                    userInput = scanner.nextInt();
                    editUser(userInput);
                    break;

                case 6:
                    System.out.println("Input ID of the user you wish to delete");
                    UserSystem userSystem = UserSystem.getInstance();
                    if (!userSystem.deleteUser(scanner.nextInt())){
                        System.out.println("Error: incorrect id. ");
                    }
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Error, not a valid option. please try again");
                    break;

            }
            System.out.println("End of switch");
        }
    }

    public User editUser(int id){
        UserSystem userSystem = UserSystem.getInstance();
        User user = userSystem.getUserByID(id);
        if (user == null){
            return null;
        }
        System.out.println("Input new username:");
        user.setName(scanner.next());
        System.out.println("Input new password:");
        user.setPassword(scanner.next());
        return user;

    }

    public User createUser(){
        System.out.println("Will this user be a customer or guest?");
        System.out.println("Alternatively, input 'back' to go back");
        UserSystem userSystem = UserSystem.getInstance();
        String username;
        switch (scanner.next().toLowerCase(Locale.ROOT)){
            case "customer":
                System.out.println("Username:");
                username = scanner.next();
                System.out.println("Password:");
                Customer customer = new Customer(username, scanner.next());
                userSystem.addCustomer(customer);
                return customer;

            case "guest":
                System.out.println("Username:");
                username = scanner.next();
                System.out.println("Password:");
                Guest guest = new Guest(username, scanner.next());
                userSystem.addGuest(guest);
                return guest;
            case "back":
                break;
            default:
                System.out.println("Error, invalid input please try again");
                break;
        }
        return null;
    }

    public Book createBook(){
        Book newBook = new Book();
        System.out.println("What is the books name?");
        newBook.setTitle(scanner.next());
        System.out.println("Who is the author?");
        newBook.setAuthor(scanner.next());
        System.out.println("What is its genre?");
        newBook.setGenre(scanner.next());
        System.out.println("What are its subgenre(s)");
        newBook.setSubGenre(scanner.next());
        System.out.println("Who is the publisher?");
        newBook.setPublisher(scanner.next());
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
