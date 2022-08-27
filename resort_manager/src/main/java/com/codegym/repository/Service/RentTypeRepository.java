package com.codegym.repository.Service;

import com.codegym.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
