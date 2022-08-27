package com.codegym.repository.employee;

import com.codegym.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeDivisionRepository extends JpaRepository<Division,Integer> {
}
