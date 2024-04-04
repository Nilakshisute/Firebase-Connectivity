package com.example.newone;

public class Users {
    String firstname,lastname,location,age;

    public Users() {
    }

    public Users(String firstname, String lastname, String location, String age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.location = location;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
