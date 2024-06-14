package model;

public class Admin {
    private String id = "admin";
    private String password = "1234";

    public boolean login(String id, String password) {
        return this.id.equals(id) && this.password.equals(password);
    }
}