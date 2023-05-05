package org.example;

import java.util.List;

public class UserSystem {
    private List<User> allUsers;
    private List<Customer> customers;
    private List<Guest> guests;

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public UserSystem(List<User> allUsers, List<Customer> customers, List<Guest> guests) {
        this.allUsers = allUsers;
        this.customers = customers;
        this.guests = guests;
    }

    public UserSystem() {
        this.allUsers = null;
        this.customers = null;
        this.guests = null;
    }
}
