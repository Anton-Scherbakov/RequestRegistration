package com.asherbakov.service;

import com.asherbakov.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(List<String> recipient);
}
