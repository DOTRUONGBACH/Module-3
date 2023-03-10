package com.example.demo.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate dateOfbirth;
    private String address;
    private String phone;
    private String email;
    private String classRoom;

    public Student() {
    }

    public Student(int id, String name, LocalDate dateOfbirth, String address, String phone, String email, String classRoom) {
        this.id = id;
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(String name, LocalDate dateOfbirth, String address, String phone, String email, String classRoom) {
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
