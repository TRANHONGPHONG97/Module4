package com.codegym.service.service;

import com.codegym.model.facility.Facility;

import java.util.List;

public interface IServiceService {

    List<Facility> findAll();

    Facility findById(Integer id);

    List<Facility> searchByName(String serviceName);

    void save(Facility facility);

    void delete (int id);


}
