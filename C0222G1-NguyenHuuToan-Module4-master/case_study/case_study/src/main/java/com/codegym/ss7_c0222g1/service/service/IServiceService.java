package com.codegym.ss7_c0222g1.service.service;

import com.codegym.ss7_c0222g1.model.facility.Facility;

import java.util.List;

public interface IServiceService {

    List<Facility> findAll();

    Facility findById(Integer id);

    List<Facility> searchByName(String serviceName);

    void save(Facility facility);

    void delete (int id);


}
