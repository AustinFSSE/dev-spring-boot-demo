package dev.alm.thymeleafmvcdemo.model;

public class Student {

    private String firstName;
    private String lastName;
    private String country;

    private String language;

    public Student() {}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String prog_language) {
        this.language = prog_language;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", programming language='" + language + '\'' +
                '}';
    }
}
