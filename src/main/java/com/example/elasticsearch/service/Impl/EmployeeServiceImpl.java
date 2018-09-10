package com.example.elasticsearch.service.Impl;

import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee queryEmployeeById(String id) {
        return employeeRepository.queryEmployeeById(id);
    }
}
