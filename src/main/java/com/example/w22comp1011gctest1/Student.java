package com.example.w22comp1011gctest1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
        private String phone;
        private int studentNumber;
        private String firstName;
        private String lastName;
        private String address;
        private String province;
        private int avgGrade;
        private String major;
        private int count;

    public Student(int count) {
        this.count=count;
    }


    public Student(String phone, int studentNumber, String firstName, String lastName, String address, String province, int avgGrade, String major) {
        this.phone = phone;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.province = province;
        this.avgGrade = avgGrade;
        this.major = major;
    }

    public Student(String phone) {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        List<String> validPhoneNumber= getAllPhone();
        if(validPhoneNumber.contains(phone)){
            this.phone=phone;
        }
        else{
            throw new IllegalArgumentException("Phone number cannot be Zero");
        }
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if(studentNumber<200034000){
            throw new IllegalArgumentException("Studen id cannot be greater then 200034000");
        }
        else {
            this.studentNumber=studentNumber;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length()==0){
            throw new IllegalArgumentException("First Name should be more then just 1 character");
        }
        else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()==0){
            throw new IllegalArgumentException("Last Name should be more then just 1 character");
        }
        else {
            this.lastName = lastName;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address.length()<=6){
            throw new IllegalArgumentException("Address cannot be less then 6 characters");
        }
        else {
            this.address = address;
        }
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        List<String> validProvince= getAllProvince();
        if(validProvince.contains(province)){
            this.province=province;
        }
        else{
            throw new IllegalArgumentException("Province must be in canada");
        }

    }

    public int getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(int avgGrade) {
        if(avgGrade<=0 && avgGrade>=100){
            throw new IllegalArgumentException("Average cannot be more then 100 or less then 0");
        }
        else {
            this.avgGrade = avgGrade;
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if(major.length()>5){
            throw new IllegalArgumentException("Major should have more then 5 characters");
        }
        else {
            this.major = major;
        }
    }

    public static List<String> getAllPhone(){
        List<String> phone= Arrays.asList("905","519","647","416","705");
        Collections.sort(phone);
        return phone;
    }
    public static List<String> getAllProvince(){
        List<String> province=Arrays.asList("AB","BC","MB","NB","NL","NS","NT","NU","ON","PE","QC","SK","YT");
        Collections.sort(province);
        return province;
    }

}
