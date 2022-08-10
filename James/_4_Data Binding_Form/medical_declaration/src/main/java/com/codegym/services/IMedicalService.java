package com.codegym.services;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<Medical> getAll();
    void save(Medical medical);
    String[] getYear();
    String[] getGender();
    String[] getCountry();

    String[] getVehicle();
}
