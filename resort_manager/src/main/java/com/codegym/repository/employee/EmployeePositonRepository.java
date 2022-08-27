package com.codegym.repository.employee;

import com.codegym.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmployeePositonRepository extends JpaRepository<Position, Integer> {
}
