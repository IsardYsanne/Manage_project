package com.doc.manage.controller;

import com.doc.manage.mapper.*;
import com.doc.manage.model.dto.employee.EmployeeDto;
import com.doc.manage.model.dto.employee.OrgDto;
import com.doc.manage.model.dto.employee.SubdivDto;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.subdivision.*;
import com.doc.manage.model.dto.task.*;
import com.doc.manage.model.entity.*;
import com.doc.manage.repository.*;
import com.doc.manage.service.OrganizationService;
import com.doc.manage.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/manage/task")
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping("/create/{task_author}/{task_type}/{state_id}")
    public ResponseEntity<Void> createTask(@PathVariable(value = "task_author") Integer authorId,
                                          @PathVariable(value = "task_type") Integer typeId,
                                          @PathVariable(value = "state_id") Integer stateId,
                                          @RequestBody TaskCreateDto taskCreateDto){

        taskService.createTask(authorId, typeId, stateId, taskCreateDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable(value = "id") Integer id, @RequestBody TaskUpdateDto taskUpdateDto){

        return ResponseEntity.ok(taskService.updateTask(id, taskUpdateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") Integer id){

        taskService.deleteTask(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{executor}")
    public ResponseEntity<TaskDto> findByExecutor(@PathVariable(value = "executor") Integer executor){

        return ResponseEntity.ok(taskService.findByExecutor(executor));
    }
}
