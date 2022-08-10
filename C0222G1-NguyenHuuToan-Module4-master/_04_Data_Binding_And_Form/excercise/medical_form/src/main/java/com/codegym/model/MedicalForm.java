package com.codegym.model;

public class MedicalForm {
    private String name;
    private String birthYear;
    private String gender;
    private String country;
    private String idCardNumber;
    private String verhice;
    private String verhiceNumber;
    private String verhiceNumberSlot;
    private String dayStart;
    private String dayEnd;
    private String city;

    public MedicalForm() {
    }

    public MedicalForm(String name, String birthYear, String gender, String country, String idCardNumber, String verhice, String verhiceNumber, String verhiceNumberSlot, String dayStart, String dayEnd, String city) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.country = country;
        this.idCardNumber = idCardNumber;
        this.verhice = verhice;
        this.verhiceNumber = verhiceNumber;
        this.verhiceNumberSlot = verhiceNumberSlot;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getVerhice() {
        return verhice;
    }

    public void setVerhice(String verhice) {
        this.verhice = verhice;
    }

    public String getVerhiceNumber() {
        return verhiceNumber;
    }

    public void setVerhiceNumber(String verhiceNumber) {
        this.verhiceNumber = verhiceNumber;
    }

    public String getVerhiceNumberSlot() {
        return verhiceNumberSlot;
    }

    public void setVerhiceNumberSlot(String verhiceNumberSlot) {
        this.verhiceNumberSlot = verhiceNumberSlot;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
