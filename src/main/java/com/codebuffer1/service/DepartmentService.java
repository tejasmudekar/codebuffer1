package com.codebuffer1.service;

import com.codebuffer1.entity.Department;
import com.codebuffer1.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department fetchById(Long id) throws DepartmentNotFoundException;

    void deleteDepartment(Long id);

    Department updateDepartment(Long id,Department department);


    Department fetchDepartmentByName(String departmentName);


}
