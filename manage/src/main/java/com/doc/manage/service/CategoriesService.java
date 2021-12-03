package com.doc.manage.service;

import com.doc.manage.mapper.CategoriesMapper;
import com.doc.manage.mapper.TaskMapper;
import com.doc.manage.model.dto.categories.CategoriesDto;
import com.doc.manage.model.entity.Categories;
import com.doc.manage.repository.CategoriesRepository;
import com.doc.manage.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    public CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesMapper categoriesMapper;

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public TaskMapper taskMapper;


    public CategoriesDto findById(Integer id){

        final Categories categories = categoriesRepository.findById(id).orElse(new Categories());
        final CategoriesDto categoriesDto = categoriesMapper.toDto(categories);

        return categoriesDto;
    }

    public void deleteCategory(Integer id){

        final Categories categories = categoriesRepository.findById(id).orElse(new Categories());
        categoriesRepository.delete(categories);
    }

    public List<CategoriesDto> findByCategoryName(String categoryName){

        final List<Categories> category = categoriesRepository.findByCategoryName(categoryName);
        final List<CategoriesDto> categoriesDto = new ArrayList<>();
        for(Categories categories: category){
            categoriesDto.add(categoriesMapper.toDto(categories));
        }

        return categoriesDto;
    }

}
