package com.codegym.service.employee;

import com.codegym.repository.employee.EmployeeDivisionRepository;
import com.codegym.model.employee.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDivisionService implements IEmployeeDivisionService {

    @Autowired
    private EmployeeDivisionRepository employeeDivisionRepository;

    @Override
    public List<Division> findAll() {
        return employeeDivisionRepository.findAll();
    }
}
