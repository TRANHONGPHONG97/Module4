package com.codegym.service.service;


import com.codegym.repository.Service.ServiceRepository;
import com.codegym.model.facility.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Facility> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Facility findById(Integer id) {
        return serviceRepository.findById2(id);
    }

    @Override
    public List<Facility> searchByName(String serviceName ) {
        return serviceRepository.searchByName(serviceName);
    }

    @Override
    public void save(Facility facility) {
        serviceRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        serviceRepository.delete(id);
    }

}
