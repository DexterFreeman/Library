package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UserSystem userSystem = UserSystem.getInstance();

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library system!");
        System.out.println("Are you a guest or a customer?");
        System.out.println("1 - Customer");
        System.out.println("2 - Guest");
        System.out.println("3 - Admin");
        String username;
        String password;
        String userchoice = InputValidation.menuValidation(scanner.next(), 1);
        if (userchoice != "") {
            switch (Integer.parseInt(userchoice)){
                case 1:
                    System.out.println("Username:");
                    username = scanner.next();
                    System.out.println("Password:");
                    password = scanner.next();
                    for (Customer customer : userSystem.getCustomers()
                    ) {
                        if (customer.getName().equals(username) && customer.getPassword().equals(password)) {
                            return customer;
                        }
                    }
                    System.out.println("Username or password incorrect.");
                    login();
                    break;

                case 2:
                    System.out.println("Username:");
                    username = scanner.next();
                    System.out.println("Password:");
                    password = scanner.next();
                    for (Guest guest : userSystem.getGuests()
                    ) {
                        if (guest.getName().equals(username) && guest.getPassword().equals(password)) {
                            return guest;
                        }
                    }
                    System.out.println("Username or password incorrect.");
                    login();
                    break;

                case 3:
                    System.out.println("Username:");
                    username = scanner.next();
                    System.out.println("Password:");
                    password = scanner.next();
                    for (Admin admin : userSystem.getAdmins()
                    ) {
                        if (admin.getName().equals(username) && admin.getPassword().equals(password)) {
                            return admin;
                        }
                    }
                    System.out.println("Username or password incorrect.");
                    login();
                    break;

                default:
                    //Just it case it somehow gets past the Input validation set in other class.
                    System.out.println("Error, invalid input please input a valid choice");
                    login();
                    break;
            }
        }
        else {
            System.out.println("Error, invalid input please type in a number.");
            login();
        }
        //never reaches here this is dead code, just putting it here so the compiler doesn't cry.
        return null;
    }

    public static void mainMenu() {
        User user = login();
        if (user instanceof Admin) {
            AdminSystem adminSystem = new AdminSystem((Admin) user);
            adminSystem.startAdminSystem();
        } else {
            LibraryUtils.startLibrary(user);
        }


    }

    public static void main(String[] args) {
        Guest tempGuest = new Guest("Dexter", "test");
        Admin admin = new Admin("admin", "test");
        userSystem.addGuest(tempGuest);
        userSystem.addAdmin(admin);
        User user = login();
        Library library = Library.getInstance();
        LibraryUtils.loadLibrary(library);
        if (user instanceof Admin) {
            AdminSystem adminSystem = new AdminSystem((Admin) user);
            adminSystem.startAdminSystem();
        } else {
            LibraryUtils.startLibrary(user);
        }
    }
}