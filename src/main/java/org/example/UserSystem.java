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

    public void printAllUsers(){
        for (User user: getAllUsers()
             ) {
            System.out.println(user.getUserID());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            System.out.println("================================================");
        }
    }

    public User getUserByID(int ID) {
        for (User user : allUsers
        ) {
            if (user.getUserID() == ID) {
                return user;
            }
        }
        return null;
    }

    public int getUniqueID() {
        int randomID = (int) (Math.random() * 9999);
        for (User user : allUsers
        ) {
            if (user.getUserID() == randomID) {
                getUniqueID();
            }
        }
        return randomID;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        this.allUsers.add(customer);
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
        this.allUsers.add(guest);
    }

    public boolean deleteUser(int id) {
        for (User user :
                allUsers) {
            if (user.getUserID() == id) {
                allUsers.remove(user);
                return true;
            }
        }
        return false;
    }

    public void addAdmin(Admin admin) {
        this.admins.add(admin);
        this.allUsers.add(admin);
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
        allUsers = new ArrayList<>();
        customers = new ArrayList<>();
        guests = new ArrayList<>();
        admins = new ArrayList<>();
    }

    public static synchronized UserSystem getInstance() {
        if (userSystem == null) {
            userSystem = new UserSystem();
        }
        return userSystem;
    }
}
