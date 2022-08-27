package com.codegym.service.employee;

import com.codegym.repository.employee.EmployeeEducationRepository;
import com.codegym.model.employee.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEducationService implements IEmployeeEducationService {

    @Autowired
    private EmployeeEducationRepository employeeEducationRepository;

    @Override
    public List<Education> findAll() {
        return employeeEducationRepository.findAll();
    }
}
