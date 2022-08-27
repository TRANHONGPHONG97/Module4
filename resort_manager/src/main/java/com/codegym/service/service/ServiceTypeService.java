package com.codegym.service.service;

import com.codegym.repository.Service.ServiceTypeRepository;
import com.codegym.model.facility.FacilityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService{

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
