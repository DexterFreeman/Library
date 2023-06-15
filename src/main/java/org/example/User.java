package org.example;

public class User {
    private String name;
    private String password;
    private int userID;

    public User(String name, String password) {
        UserSystem userSystem = UserSystem.getInstance();
        this.name = name;
        this.password = password;
        this.userID = userSystem.getUniqueID();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
