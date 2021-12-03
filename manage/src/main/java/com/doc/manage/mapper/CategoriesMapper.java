package com.doc.manage.mapper;

import com.doc.manage.model.dto.categories.CategoriesDto;
import com.doc.manage.model.dto.task.TaskCategoriesDto;
import com.doc.manage.model.entity.Categories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

    TaskCategoriesDto toCategory(Categories entity);

    CategoriesDto toDto(Categories entity);
}
