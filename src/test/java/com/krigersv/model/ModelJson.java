package com.krigersv.model;

import java.util.List;

public class ModelJson {
    private String firstName, lastName, phoneNumber, dateOfBirth, currentAddress, email ;
    private List<String> hobbies;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public String getEmail() {return email; }
    public void setEmail(String email) {this.email = email;}
    public String getCurrentAddress() {return currentAddress;}
    public void getCurrentAddress(String getCurrentAddress) {this.currentAddress = getCurrentAddress;}
    public List<String> getHobbies() {return hobbies;}
    public void setHobbies(List<String> hobbies) {this.hobbies = hobbies;}
}








