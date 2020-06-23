package com.bridgelabz;

public class MyUser {
    private String name;
    private String email;
    private String phoneNo;
    private String country;

    public MyUser() {

    }

    public MyUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public String getCountry(){
        return country;
    }

}