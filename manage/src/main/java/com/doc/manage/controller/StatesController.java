package com.doc.manage.controller;


import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.states.StatesDto;
import com.doc.manage.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/states")
public class StatesController {

    @Autowired
    public StatesService statesService;


    @GetMapping("/{id}")
    public ResponseEntity<StatesDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(statesService.findById(id));
    }
}
