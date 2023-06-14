package org.example;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static User login(){
        UserSystem userSystem = UserSystem.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library system!");
        System.out.println("Are you a guest or a customer?");
        System.out.println("1 - Customer");
        System.out.println("2 - Guest");
        System.out.println("3 - Admin");
        int userInput = scanner.nextInt();
        if (userInput == 1){
            System.out.println("Username:");
            String username = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();
            for (Customer customer: userSystem.getCustomers()
            ) {
                if (customer.getName().equals(username) && customer.getPassword().equals(password)){
                    return customer;
                }
            }
            System.out.println("Username or password incorrect.");
            login();
        }
        else if (userInput == 2){
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();
            for (Guest guest: userSystem.getGuests()
                 ) {
                if (guest.getName().equals(username) && guest.getPassword().equals(password)){
                    return guest;
                }
            }
            System.out.println("Username or password incorrect.");
            login();
        }
        else if (userInput == 3){
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();
            for (Admin admin: userSystem.getAdmins()
            ) {
                if (admin.getName().equals(username) && admin.getPassword().equals(password)){
                    return admin;
                }
            }
            System.out.println("Username or password incorrect.");
            login();
        }
        else {
            System.out.println("Error, invalid input");
            login();
        }
        login();
        return null;
    }
    public static void main(String[] args) {
        Guest tempGuest = new Guest("Dexter", "test");
        UserSystem userSystem = UserSystem.getInstance();
        System.out.println(userSystem.getAllUsers());
        Admin admin = new Admin("admin", "test");
        userSystem.addGuest(tempGuest);
        userSystem.addAdmin(admin);
        User user = login();

        Library library = new Library();
        LibraryUtils.loadLibrary(library);
        if (user instanceof Admin){
            AdminSystem adminSystem = new AdminSystem((Admin) user);
            adminSystem.startAdminSystem(library);
        }
        else{
            LibraryUtils.startLibrary(user, library);
        }


    }
}