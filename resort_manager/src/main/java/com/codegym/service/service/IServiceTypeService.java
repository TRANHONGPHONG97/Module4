package com.codegym.service.service;

import com.codegym.model.facility.FacilityType;

import java.util.List;

public interface IServiceTypeService {

    List<FacilityType> findAll();
}
