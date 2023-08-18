package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeDao;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(long id) {
        Employee employee = employeeDao.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        // to force a save of this employee, setId to 0
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Employee employee = employeeDao.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        employeeDao.deleteById(id);
    }
}
