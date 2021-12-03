package com.doc.manage.mapper;

import com.doc.manage.model.dto.categories.CategoriesDto;
import com.doc.manage.model.dto.task.TaskCategoriesDto;
import com.doc.manage.model.entity.Categories;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CategoriesMapperImpl implements CategoriesMapper {

    @Override
    public TaskCategoriesDto toCategory(Categories entity) {
        if ( entity == null ) {
            return null;
        }

        TaskCategoriesDto taskCategoriesDto = new TaskCategoriesDto();

        taskCategoriesDto.setCategoryName( entity.getCategoryName() );

        return taskCategoriesDto;
    }

    @Override
    public CategoriesDto toDto(Categories entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriesDto categoriesDto = new CategoriesDto();

        categoriesDto.setId( entity.getId() );
        categoriesDto.setCategoryName( entity.getCategoryName() );

        return categoriesDto;
    }
}
