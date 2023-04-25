package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello world!");
        Library library = new Library();
        library.loadLibrary();
        System.out.println(library.toString());
        boolean exit = false;
        System.out.println("Welcome to the library system!");
        while (exit == false){
            int userChoice = 0;
            System.out.println("===================");
            System.out.println("1 - View all books");
            System.out.println("2 - View unloaned books");
            System.out.println("3 - View loaned books");
            System.out.println("4 - Loan a book");
            System.out.println("5 - Return a book");
            System.out.println("6 - Save & Exit");
            System.out.println("7 - Get book information");
            userChoice = scanner.nextInt();
            if (userChoice < 7 || userChoice > 1){
                switch (userChoice){
                    case 1:
                        library.displayBooks();
                        library.displayLoanedBooks();
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        library.displayLoanedBooks();
                        break;

                    case 4:
                        System.out.println("Input name of person loaning book to:");
                        String name = scanner.next();
                        System.out.println("Input book number");
                        int bookNumber = scanner.nextInt();
                        library.loanBook(bookNumber, name);
                        break;

                    case 5:
                        System.out.println("Input book number");
                        int booknumber = scanner.nextInt();
                        library.returnBook(booknumber);
                        break;

                    case 6:
                        library.saveLibrary();
                        exit = true;
                        break;

                    case 7:
                        System.out.println("Input book number");
                        booknumber = scanner.nextInt();
                        library.displayBookInformation(booknumber);
                        break;
                }
            }
            else {
                System.out.println("Error, input was not a valid option. Try again.");
            }

        }

    }
}