package com.codegym.repository.employee;

import com.codegym.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeEducationRepository extends JpaRepository<Education, Integer> {
}
