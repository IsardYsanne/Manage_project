package com.doc.manage.controller;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.employee.EmployeeDto;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.organization.OrganizationCreateDto;
import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.organization.OrganizationUpdateDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.repository.EmployeeRepository;
import com.doc.manage.repository.OrganizationRepository;
import com.doc.manage.repository.SubdivisionRepository;
import com.doc.manage.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/manage/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;
    /* Test
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
        //return null;
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(organizationService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createOrg(@RequestBody OrganizationCreateDto organizationCreateDto){

        organizationService.createOrg(organizationCreateDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrganizationDto> updateOrg(@PathVariable(value = "id") Integer id,  @RequestBody OrganizationUpdateDto organizationUpdateDto){

        return ResponseEntity.ok(organizationService.updateOrg(id, organizationUpdateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrg(@PathVariable(value = "id") Integer id){

        organizationService.deleteOrg(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{org_name}")
    public ResponseEntity<OrganizationDto> findByName(@PathVariable(value = "org_name") String name){

        return ResponseEntity.ok(organizationService.findByName(name));
    }


}
