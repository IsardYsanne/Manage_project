package com.doc.manage.controller;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.employee.OrgDto;
import com.doc.manage.model.dto.subdivision.*;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.model.entity.Subdivision;
import com.doc.manage.repository.EmployeeRepository;
import com.doc.manage.repository.OrganizationRepository;
import com.doc.manage.repository.SubdivisionRepository;
import com.doc.manage.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/subdivision")
public class SubdivisionController {

    @Autowired
    SubdivisionService subdivisionService;

    @GetMapping("/{id}")
    public ResponseEntity<SubdivisionDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(subdivisionService.findById(id));
    }

    @PostMapping("/create/{subdivision_manager}/{org_id}")
    public ResponseEntity<Void> createSub(@PathVariable(value = "subdivision_manager") Integer managerId,
                                          @PathVariable(value = "org_id") Integer organizationId,
                                          @RequestBody SubdivisionCreateDto subdivisionCreateDto){

        subdivisionService.createSub(managerId, organizationId, subdivisionCreateDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubdivisionDto> updateSub(@PathVariable(value = "id") Integer id, @RequestBody SubdivisionUpdateDto subdivisionUpdateDto){

        return ResponseEntity.ok(subdivisionService.updateSub(id, subdivisionUpdateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSub(@PathVariable(value = "id") Integer id){

        subdivisionService.deleteSub(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<SubdivisionDto> findByName(@PathVariable(value = "name") String name){

        return ResponseEntity.ok(subdivisionService.findByName(name));
    }

}
