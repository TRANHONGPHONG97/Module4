package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.List;

public interface MedicalFormRepository {
    List<Medical> getAll();

    void save(Medical medical);

    String[] getYear();

    String[] getGender();

    String[] getCountry();

    String[] getVehicle();
}
