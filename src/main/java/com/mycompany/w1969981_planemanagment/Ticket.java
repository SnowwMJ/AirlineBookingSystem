package com.mycompany.w1969981_planemanagment;

// TASK B
public class Ticket { // creates class for the ticket

    private int row;

    private int seatnumber;

    private int price;

    private Person person;

    private String[] plane_seats = {"A", "B", "C", "D"};

    // Setting all the variables that are needed for the ticket
    public Ticket(int rows, int seatnumbers, int prices, Person person) {

        row = rows;
        seatnumber = seatnumbers;
        price = prices;
        this.person = person; // constructor for ticket

    }

    public void set_seat(int seatnumber) { // all the setters and getters for the ticket

        
        this.seatnumber = seatnumber;
    }
    
    public void set_row(int row){
        
        this.row = row;
    }
    
    public int get_row() {
        
        return this.row;
    }

    public int[] get_seat() {

        return new int[]{this.seatnumber};
    }

    public void set_price(int price) {

        this.price = price;
    }

    public int get_price() {

        return this.price;
    }

    public Person get_person() {

        return this.person;
    }

    public void set_person(Person person) {

        this.person = person;
    }

    public void print_ticket_information() {
        
        System.out.println("****************** YOUR TICKET **********************"); // ticket menu similar to the main menu
        switch (row) {
            case 65:
                System.out.print("Row: " + "A");
                break;
            case 66:
                System.out.print("Row: " + "B");
                break;
            case 67:
                System.out.print("Row: " + "C");
                break;
            case 68:
                System.out.print("Row: " + "D");
                break;
            default:
                break; // I was having issues with ACSII values being printed out instead of the actuall letters so this was to counter-act that
         }
        System.out.println(" Ticket Seat: " + seatnumber ); // print out method for the ticket with all values which have been set and stored by the class
        System.out.println("Ticket Price: £" + this.price);
        System.out.println("Person Information:");
        this.person.print_person_information();
        System.out.println("*****************************************************");
    }

}
