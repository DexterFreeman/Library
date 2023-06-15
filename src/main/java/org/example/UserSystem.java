package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserSystem {

    private static UserSystem userSystem = null;
    private List<User> allUsers;
    private List<Customer> customers;
    private List<Guest> guests;
    private List<Admin> admins;

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
    public void addGuest(Guest guest){
        this.guests.add(guest);
    }

    public void addAdmin(Admin admin) {
        this.admins.add(admin);
    }
    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

//For debugging
//    public void printNames(){
//        for (Guest guest: guests
//             ) {
//            System.out.println(guest.getName());
//        }
//    }
//    public void printPasswords(){
//        for (Guest guest: guests
//        ) {
//            System.out.println(guest.getPassword());
//        }
//    }


    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Guest> getGuests() {
        return this.guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    private UserSystem() {
        allUsers = new ArrayList<User>();
        customers = new ArrayList<Customer>();
        guests = new ArrayList<Guest>();
        admins = new ArrayList<Admin>();
    }
    public static synchronized UserSystem getInstance(){
        if (userSystem == null){
            userSystem = new UserSystem();
        }
        return userSystem;
    }
}
