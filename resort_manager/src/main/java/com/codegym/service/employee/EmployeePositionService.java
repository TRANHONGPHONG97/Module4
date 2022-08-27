package com.codegym.service.employee;

import com.codegym.repository.employee.EmployeePositonRepository;
import com.codegym.model.employee.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionService implements IEmployeePositionService {

    @Autowired
    private EmployeePositonRepository employeePositonRepository;

    @Override
    public List<Position> findAll() {
        return employeePositonRepository.findAll();
    }
}
