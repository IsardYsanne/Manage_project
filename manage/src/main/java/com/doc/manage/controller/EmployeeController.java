package com.doc.manage.controller;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.employee.*;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.model.entity.Subdivision;
import com.doc.manage.repository.EmployeeRepository;
import com.doc.manage.repository.OrganizationRepository;
import com.doc.manage.repository.SubdivisionRepository;
import com.doc.manage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(employeeService.findById(id));
    }


    @PostMapping("/create/{subdivision_id}/{organization_id}")
    public ResponseEntity<Void> createEmpl(@PathVariable(value = "subdivision_id") Integer subdivisionId,
                                           @PathVariable(value = "organization_id") Integer organizationId,
                                           @RequestBody EmployeeCreateDto employeeCreateDto){

        employeeService.createEmpl(subdivisionId, organizationId, employeeCreateDto);

        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmpl(@PathVariable(value = "id") Integer id, @RequestBody EmployeeUpdateDto employeeUpdateDto){

        return ResponseEntity.ok(employeeService.updateEmpl(id, employeeUpdateDto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpl(@PathVariable(value = "id") Integer id){

        employeeService.deleteEmpl(id);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/find/{surname}")
    public ResponseEntity<EmployeeDto> findBySurname(@PathVariable(value = "surname") String surname){

        return ResponseEntity.ok(employeeService.findBySurname(surname));
    }
}
