package com.codebuffer1.controller;

import com.codebuffer1.entity.Department;
import com.codebuffer1.error.DepartmentNotFoundException;
import com.codebuffer1.service.DepartmentService;
import com.codebuffer1.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
   // private final Logger LOGGER = (Logger) LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentServiceImpl resp;


    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
    //LOGGER.info("Inside fetchDep");
    return departmentService.saveDepartment(department);
    }



    @GetMapping("/department")
    public List<Department> fetchDepartment()
    {
       return departmentService.fetchDepartment();
    }
    @GetMapping("/department/{id}")
    public Department fetchById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") Long id)
    {
    departmentService.deleteDepartment(id);
    return "Delete sucess";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department)
    {
        return departmentService.updateDepartment(id,department);

    }
}
