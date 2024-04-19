package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    static Book[] books = {
            new Book(1, "978-0307409323", "The Lord of the Rings"),
            new Book(2, "978-0747532743", "Pride and Prejudice"),
            new Book(3, "978-0062474566", "To Kill a Mockingbird"),
            new Book(4, "978-0449911491", "Harry Potter and the Sorcerer's Stone"),
            new Book(5, "978-0385419912", "The Hitchhiker's Guide to the Galaxy"),
            new Book(6, "978-0151004594", "The Great Gatsby"),
            new Book(7, "978-0316069475", "1984"),
            new Book(8, "978-0007313511", "Jane Eyre"),
            new Book(9, "978-0345339917", "The Catcher in the Rye"),
            new Book(10, "978-0679746082", "Invisible Man"),
            new Book(11, "978-0140299997", "One Hundred Years of Solitude"),
            new Book(12, "978-0375760068", "Beloved"),
            new Book(13, "978-0679742552", "The Remains of the Day"),
            new Book(14, "978-0312427003", "The Wind in the Willows"),
            new Book(15, "978-0060958632", "Tess of the d'Urbervilles"),
            new Book(16, "978-0140279780", "A Passage to India"),
            new Book(17, "978-0375405714", "Moby Dick"),
            new Book(18, "978-0141180552", "A Farewell to Arms"),
            new Book(19, "978-0679742545", "The Remains of the Day"),
            new Book(20, "978-0007313504", "Jane Eyre (alternate edition)")
    };

    public static void main(String[] args) {
        getHomeScreenSelection();
    }

    private static void getHomeScreenSelection() {
        int choice = 0;
        while(choice != 3) {
            System.out.println("----------------------------------------");
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("----------------------------------------");
            System.out.println("Please select an option: (1-3)");
            System.out.println("\t[1] Show Available Books");
            System.out.println("\t[2] Show Checked Out Books");
            System.out.println("\t[3] Close Application");
            System.out.println("----------------------------------------");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(userInput.nextLine().strip());
            switch (choice){
                case 1:
                    // Show Available Book screen
                    showAllAvailable();
                    break;
                case 2:
                    // Show Checked Out Book Screen
                    showCheckedOut();
                    break;
                case 3:
                    // Exit application
                    System.out.println("----------------------------------------");
                    System.out.println("Thank you. Goodbye!");
                    System.out.println("----------------------------------------");
                    return;
                default:
                    // invalid input
                    System.out.println("Invalid Selection. Please enter proper choice: ");
                    break;
            }
        }
    }

    private static void showAllAvailable() {
        int choice = 0;
        int id;
        User user;
        String firstName, lastName;

        System.out.println("----------------------------------------");
        System.out.println("All Available Books: ");
        System.out.println("----------------------------------------");
        for(Book book : books) {
            if(!book.isCheckedOut()) {
                System.out.println("-" + book.display());
            }
        }

        while(choice != 2){
            System.out.println("----------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("\t[1] Check Out a Book");
            System.out.println("\t[2] Return to Main Menu");
            System.out.println("----------------------------------------");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(userInput.nextLine().strip());
            if(choice == 1) {
                System.out.println("----------------------------------------");
                System.out.print("Please Enter First Name: ");
                firstName = userInput.nextLine().strip();
                System.out.print("Please Enter Last Name: ");
                lastName = userInput.nextLine().strip();
                user = new User (firstName, lastName);
                System.out.println("----------------------------------------");
                System.out.println("Which book would you like to check out? (choose by ID) ");
                id = Integer.parseInt(userInput.nextLine().strip());
                for(Book book : books) {
                    if(book.getId() == id) {
                        book.checkOut(user.getFullName());
                        System.out.println("Done!");
                        break;
                    }
                }
            } else if (choice == 2) {
                continue;
            }
            else {
                System.out.println("Invalid Selection. Please enter proper choice: ");
                continue;
            }
        }
    }

    private static void showCheckedOut() {
        char choice = '0';
        int id;

        System.out.println("----------------------------------------");
        System.out.println("All Checked Out Books: ");
        System.out.println("----------------------------------------");
        for(Book book : books) {
            if(book.isCheckedOut()) {
                System.out.println("-" + book.display());
                System.out.printf("\tChecked Out To: %s\n", book.getCheckedOutTo());
            }
        }
        while(choice != 'X'){
            System.out.println("----------------------------------------");
            System.out.println("Please select an option: ");
            System.out.println("\t[C] Check In a Book");
            System.out.println("\t[X] Return to Main Menu");
            System.out.println("----------------------------------------");
            System.out.print("Your choice: ");
            choice = userInput.nextLine().toUpperCase().charAt(0);
            if(choice == 'C') {
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println("Which book would you like to check in? (choose by ID) ");
                id = Integer.parseInt(userInput.nextLine().strip());
                for(Book book : books) {
                    if(book.getId() == id) {
                        book.checkIn();
                        System.out.println("Done!");
                        break;
                    }
                }
            } else if (choice == 'X') {
                break;
            }
            else {
                System.out.println("Invalid Selection. Please enter proper choice: ");
                break;
            }
        }
    }



}