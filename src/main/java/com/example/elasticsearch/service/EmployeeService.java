package com.example.elasticsearch.service;

import com.example.elasticsearch.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeService  extends ElasticsearchRepository<Employee, String> {
    Employee queryEmployeeById(String id);
}
