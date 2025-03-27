package dev.alm.aopdemo;

public class Account {

    private int id;
    private String name;

    public Account() {}
    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // getters
    public int getId() { return id; }
    public String getName() { return name; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
