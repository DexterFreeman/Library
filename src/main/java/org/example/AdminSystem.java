package org.example;

import java.util.Scanner;

public class AdminSystem {

    private Admin loggedInAdmin;
    private static final Scanner scanner = new Scanner(System.in);

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
            switch (userInput){
                case 1:
                    System.out.println("Input book number of the book you wish to edit.");

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Error, not a valid option. please try again");

            }
        }
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
