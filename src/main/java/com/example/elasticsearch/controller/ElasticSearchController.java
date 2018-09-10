package com.example.elasticsearch.controller;


import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.model.Entity;
import com.example.elasticsearch.service.CityESService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository er;


    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String add(@RequestBody Map<String,String> req) {
        Employee employee = new Employee();
        employee.setId(req.get("id"));
        employee.setFirstName(req.get("name"));
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        er.save(employee);
        return "success";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")String id) {
        Employee employee = new Employee();
        employee.setId(id);
        er.delete(employee);
        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update() {

        Employee employee = er.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query")
    public Employee query() {

        Employee accountInfo = er.queryEmployeeById("1");
        System.err.println(new Gson().toJson(accountInfo));

        return accountInfo;
    }

}
