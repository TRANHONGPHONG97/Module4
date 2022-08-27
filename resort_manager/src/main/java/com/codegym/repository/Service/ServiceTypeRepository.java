package com.codegym.repository.Service;

import com.codegym.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ServiceTypeRepository extends JpaRepository<FacilityType, Integer> {
}
