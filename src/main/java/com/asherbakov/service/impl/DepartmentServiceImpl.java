package com.asherbakov.service.impl;

import com.asherbakov.entity.Department;
import com.asherbakov.repository.DepartmentRepository;
import com.asherbakov.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(List<String> recipient) {
        return departmentRepository.save(new Department(recipient.get(1)));
    }
}
