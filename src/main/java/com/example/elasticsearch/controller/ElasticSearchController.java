package com.example.elasticsearch.controller;


import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.model.Entity;
import com.example.elasticsearch.service.CityESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CityESService esService;

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

    @RequestMapping("/add2")
    public void add2() {
        Entity entity=new Entity(Long.valueOf(1),"test");
        esService.saveEntity(entity);
    }
}
