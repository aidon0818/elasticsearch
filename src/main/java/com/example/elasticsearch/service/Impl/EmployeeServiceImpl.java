package com.example.elasticsearch.service.Impl;

import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.example.elasticsearch.service.EmployeeService;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee queryEmployeeById(String id) {
        return employeeRepository.queryEmployeeById(id);
    }

    @Override
    public <S extends Employee> S index(S s) {
        return null;
    }

    @Override
    public Iterable<Employee> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    public Page<Employee> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Employee> search(SearchQuery searchQuery) {
        return null;
    }

    @Override
    public Page<Employee> searchSimilar(Employee employee, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public Class<Employee> getEntityClass() {
        return null;
    }

    @Override
    public Iterable<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Employee> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
