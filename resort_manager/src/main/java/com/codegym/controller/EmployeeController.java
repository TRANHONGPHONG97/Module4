package com.codegym.controller;

import com.codegym.model.employee.Employee;
import com.codegym.service.employee.EmployeeDivisionService;
import com.codegym.service.employee.EmployeeEducationService;
import com.codegym.service.employee.EmployeePositionService;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDivisionService employeeDivisionService;

    @Autowired
    private EmployeeEducationService employeeEducationService;

    @Autowired
    private EmployeePositionService employeePositionService;

    @GetMapping("/list")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "employeeName", defaultValue = "") String employeeName,
                           Model model) {
        Sort sort = Sort.by("employee_id");
        Page<Employee> employeeList = employeeService.searchByNameEmployee(employeeName, PageRequest.of(page, 5, sort));
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeDivisionList", employeeDivisionService.findAll());
        model.addAttribute("employeeEducationList", employeeEducationService.findAll());
        model.addAttribute("employeePositionList", employeePositionService.findAll());
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeName", employeeName);
        return "/employee/EmployeeList";
    }
}
