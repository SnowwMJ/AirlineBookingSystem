package com.mycompany.w1969981_planemanagment;

import java.util.*;

public class W1969981_PlaneManagment {

    static Scanner input = new Scanner(System.in); // this capture all inputs from the user

    static String[] plane_rows = {"A", "B", "C", "D"}; // array for rows

    static int[][] plane_seats = {
        new int[14], new int[12], new int[12], new int[14]// Addressing amount of seats for each row using a multidimensional array
    };

    static Ticket[][] tickets = {
        new Ticket[14], new Ticket[12], new Ticket[12], new Ticket[14] // Tickets multidimensional array
    };

    static int ticketsVals = 0;  // a seperate variable for tickets thats not an array

    // START OF TASK A
    // sets up an array for the planes rows and seats with corect values
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application by M.I. Mujtaba");
        System.out.println(""); // prints empty line for aesthetic purposes

        Scanner input = new Scanner(System.in); // this capture all inputs from the user

        int choice = 8;
        while (choice != 0) { // a while loops that repeats the menu printing whenever a user is completed with the method options

            System.out.println("************************************");
            System.out.println("*          MENU OPTIONS            *");
            System.out.println("************************************");

            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first avaiable seat");
            System.out.println("4) Show Seating Plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Exit Menu");
            System.out.println("************************************");
            System.out.println("Please select an option:"); // My menu of options for the user to use each going to tak the user to a case
            choice = input.nextInt();

            // A while loop with switch case to give functionality to the menu & lets the user actually go to those options
            switch (choice) {

                case 0:
                    System.out.println("Thanks for using our online Airline Booking System");
                    break;
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    first_seat_avaiable();
                    break;
                case 4:
                    seating_plan();
                    break;
                case 5:
                    print_ticket_information_and_sales();
                    break;
                case 6:
                    search_tickets();
                    break;
                default:
                    System.out.println("Please pick 1 - 6 or 0 to quit the program, any other numbers are invalid");
                    break; // ensures user picks between 0-6
            }
        }
    }

    public static void buy_seat() { //method  for buying a seat

        System.out.println("Please enter your first name:");
        String name = input.next();
        System.out.println("Please enter your surname name:");
        String surname = input.next();
        System.out.println("Please enter your email adress:");
        String email = input.next();
        input.nextLine(); // Gathering all the users data for the ticket class and peson class
        char row;
        do {
            System.out.println("Please pick a row letter(A  /  B  /   C  /  D):");
            row = input.next().charAt(0);
            if (row != 'A' && row != 'B' && row != 'C' && row != 'D') {
                System.out.println("Please select the correct row."); // Validation check to ensure corect row & hence forth array is picked 

            }
        } while (row != 'A' && row != 'B' && row != 'C' && row != 'D'); // simply whenever the right row is selected itll ask the row too

        System.out.println("Please chose a seat number:");
        int seatnumber = input.nextInt();
        int row_index = -1;
        switch (row) {
            case 'A':
                row_index = 0;
                break;
            case 'B':
                row_index = 1;
                break;
            case 'C':
                row_index = 2;
                break;
            case 'D':
                row_index = 3;
                break;
            default:
                System.out.println("Invalid row"); // This stores the selected row into the correct array in the multidimensional array
                break;
        }

        //plane_seats[row_index][seatnumber-1] = 1;
        if (plane_seats[row_index][seatnumber - 1] == 1) { // Makes sure the seat isnt already ooked as a validation check
            System.out.println("This seat " + seatnumber + " in row " + row + " is already taken");

        } else {
            plane_seats[row_index][seatnumber - 1] = 1;
            System.out.println("");
            System.out.println("Your seat " + row + seatnumber + " has been booked"); // Books the seat remembering its contents through the array

        }

        int price;

        if (seatnumber <= 5) {
            price = 200;
        } else if (seatnumber <= 9) {
            price = 150;
        } else {
            price = 180; // if statment for determining price of tickets based on seating positiion
        }

        // HERE i will create a person since that isnt to do with its own method but a class instead
        // PART OF TASK B
        
        Person new_person = new Person(name, surname, email);

        new_person.print_person_information();

        // Creating a ticket which is made when all the valuable data in inputed
        // i.e name surname seat row and number as well as email and price for their seat
       
        Ticket ticket = new Ticket(row, seatnumber, price, new_person); // getters and setters are working as you can see the values

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                ticketsVals = i; // adds a ticket to the ticket variable
                break;
            }
        }

        if (ticketsVals >= 0 && ticketsVals < tickets.length) {

            tickets[ticketsVals][0] = ticket; // Assigning ticket to the fist element in the array
            System.out.println("Your ticket has been processed and booked");
        } else {
            System.out.println("There's been an error and your ticket hasn't been booked");
        }

    } // Ending method for buying seat

    public static void cancel_seat() { //method  for cancelling a seat

        System.out.println("Please enter your entire name:");
        String name = input.next();
        System.out.println("Please enter your surname name:");
        String surname = input.next();
        System.out.println("Please enter your email adress:");
        String email = input.next();
        input.nextLine();
        char row;
        do {
            System.out.println("Please pick a row to cancel(A  /  B  /   C  /  D):");
            row = input.next().charAt(0);
            if (row != 'A' && row != 'B' && row != 'C' && row != 'D') {
                System.out.println("Please select the correct row.");

            }
        } while (row != 'A' && row != 'B' && row != 'C' && row != 'D');

        System.out.println("Please chose a seat number:");
        int seatnumber = input.nextInt();
        int row_index = -1;
        switch (row) {
            case 'A':
                row_index = 0;
                break;
            case 'B':
                row_index = 1;
                break;
            case 'C':
                row_index = 2;
                break;
            case 'D':
                row_index = 3;
                break;
            default:
                System.out.println("Invalid row");
                break; //break ends the current process and moves to the next if this isnt applied itll skip through to the last case with a break
        }

        if (plane_seats[row_index][seatnumber - 1] == 0) {
            System.out.println("This seat " + seatnumber + " in row " + row + " hasnt been booked yet");

        } else {
            plane_seats[row_index][seatnumber - 1] = 0;
            System.out.println("Your seat " + row + seatnumber + " has been cancelled");

            // Copied the code from buying seat since its relativly the same just minor changes of the if statments 
        }

    } // Ending method for cancelling seat

    public static void first_seat_avaiable() { //method  for seeing the first available seat in the plane

        for (int row = 0; row < plane_seats.length; row++) {

            for (int seat = 0; seat < plane_seats[row].length; seat++) {

                if (plane_seats[row][seat] == 0) {
                    System.out.println("The first available plane seat is " + plane_rows[row] + String.valueOf(seat + 1));
                    // this reads through the multidimensional array and displays the first avaiable seat by seeing the first row and seat thats not 1

                    return;
                }
                if (plane_seats[row][seat] == 1) {
                    System.out.println("There is no available seat"); // If all seats values are 1 it will display this

                }
            }
        }

    } // Ending method for viewing first available seat 

    public static void seating_plan() { //method  for seating plan viewing 

        for (int row = 0; row < plane_seats.length; row++) {

            System.out.print(plane_rows[row] + " "); // Creatin each plane seats cell which will e filed with O or X

            for (int seat = 0; seat < plane_seats[row].length; seat++) {
                if (plane_seats[row][seat] == 0) {
                    System.out.print(" O ");
                
                } else {
                   
                    System.out.print(" X "); // Reading what seat is filled in / selected or not
                }
            }
            System.out.println(); // This moves the reading to the next array in the multidimensional array

        }

    } // Ending method for the seating plan

    // END OF TASK A
    // TASK B CLASSES
    
    public static void print_ticket_information_and_sales() {

        int sum_of_ticket_values = 0; // creating an empty variable so that the tickets contents can be added here

        for (Ticket[] ticketRow : tickets) { //this took hours of trial and error but it now reads tickets correctly in the for loop

            for (Ticket ticket : ticketRow) {

                if (ticket != null) {  // sees if its filled or not

                    ticket.print_ticket_information();  // calling the class for tickets
                    sum_of_ticket_values += ticket.get_price(); // this adds up the tickets contents from that variable created above and displays it with the ticket
                }
            }
        }
        System.out.println("Total sales: $" + sum_of_ticket_values);
    }

    public static void search_tickets() {

       /*1
        1System.out.println("Select a row to search a ticket in: ");
        char row = (input.next().charAt(0));

        if (row < 'A' && row > 'D') {

            System.out.println("Please select rows from: A  /  B  /  C  /  D"); // validation check to make sure only those 4 letters are selected
            return;
        }
        System.out.println("Select your seat: ");
        
        int seats = input.nextInt();
        if (seats < 1 && seats > 14) {
            System.out.println("Please select seat numbers that range from 1 to 14");
            return; // same validation here but for seat numbers 

        }
        
        boolean found = false;
        
        for (Ticket[] ticket : tickets) {
            
            if (ticket != null && ticket. == row && Ticket.get_seat() == seats){
                
                ticket.print_ticket_information();
                found = true;
                break;
            }
        }
         
         if (!found) {
             
             System.out.println("This current seat is not aviable at this time");
         } 
        */
        // I attempted search ticket but ran into various probles with the ticket values giving errors and not linking back to the multi dimentsional array
        // therefore i left it out as commented
    }

} // main clause
