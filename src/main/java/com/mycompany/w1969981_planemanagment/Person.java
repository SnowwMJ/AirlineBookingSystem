package com.mycompany.w1969981_planemanagment;

// TASK B

public class Person { // Creates the class for a person

    private String name;

    private String surname;

    private String email; // The data gathered in the main program is stored here 

    public Person(String names, String surnames, String emails) {

        name = names;
        surname = surnames;
        email = emails; // Constructor for Person

    }
    
    public void set_name(String name){
        this.name = name;
    }
    public void set_surname(String surname){
        this.surname = surname;
    }
    public String get_name(){
        return this.name;
    }
    public String get_surname(){
        return this.surname;
    }
    public void set_email(String email){
        this.email = email;
    }
    
    public String get_email(){
        return this.email;
        
    }

    // Method to print out the Persons information
    
    public void print_person_information() {
        System.out.println("Name: " + this.name + " " + this.surname);
       
        System.out.println("Email: " + this.email); 
    }

}
