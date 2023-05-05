package org.example;
import java.util.Scanner;
public class Main {

    public static User login(){
        UserSystem userSystem = new UserSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library system!");
        System.out.println("Are you a guest or a customer?");
        System.out.println("1 - Customer");
        System.out.println("2 - Guest");
        int userInput = scanner.nextInt();
        if (userInput == 1){
            System.out.println("Username:");
            String username = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();
            Guest temp = (Guest) userSystem.getGuests().stream().filter(guest -> guest.getName() == username && guest.getPassword() == password );
            if (temp != null){
                return temp;
            }

        }
        else if (userInput == 2){
            System.out.println("Username:");
            String username = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();
        }
        else {
            System.out.println("Error, invalid input");
            login();
        }
        return null;
    }
    public static void main(String[] args) {
        User user = login();
        Library library = new Library();
        LibraryUtils.loadLibrary(library);
        Guest tempGuest = new Guest("Dexter", "test");
        LibraryUtils.startLibrary(tempGuest, library);

    }
}