package com.example.elasticsearch.controller;


import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        employeeRepository.save(employee);
        return "success";
    }
}
