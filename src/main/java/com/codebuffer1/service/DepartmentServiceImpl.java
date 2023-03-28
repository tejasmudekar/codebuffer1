package com.codebuffer1.service;

import com.codebuffer1.entity.Department;
import com.codebuffer1.error.DepartmentNotFoundException;
import com.codebuffer1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService
{


    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department;
        department = departmentRepository.findById(id);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();


    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depDb=departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDb.setDepartmentAddress(department.getDepartmentAddress());

        }
        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
       return departmentRepository.findByDepartmentName(departmentName);

    }



}
