package com.doc.manage.controller;

import com.doc.manage.mapper.CategoriesMapper;
import com.doc.manage.mapper.TaskMapper;
import com.doc.manage.model.dto.categories.CategoriesDto;
import com.doc.manage.model.entity.*;
import com.doc.manage.repository.CategoriesRepository;
import com.doc.manage.repository.TaskRepository;
import com.doc.manage.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manage/categories")
public class CategoriesController {

    @Autowired
    public CategoriesService categoriesService;


    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDto> findById(@PathVariable Integer id){

        return ResponseEntity.ok(categoriesService.findById(id));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") Integer id){

        categoriesService.deleteCategory(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{categoryName}")
    public ResponseEntity <List<CategoriesDto>> findByCategoryName(@PathVariable(value = "categoryName") String categoryName){

        return ResponseEntity.ok(categoriesService.findByCategoryName(categoryName));
        //return ResponseEntity.ok(categoriesDto);
    }
}
