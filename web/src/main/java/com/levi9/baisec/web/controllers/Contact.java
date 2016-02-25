package com.levi9.baisec.web.controllers;

import java.time.LocalDateTime;

/**
 * File created by a.chmilevski on 2/24/2016 - 12:39 PM.
 * RadiON
 */
public class Contact {
    private String name;
    private String phone;
    private String address;
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
