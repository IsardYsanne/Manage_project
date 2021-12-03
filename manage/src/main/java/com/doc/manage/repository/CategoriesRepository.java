package com.doc.manage.repository;

import com.doc.manage.model.entity.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {

    List<Categories> findByCategoryName(String categoryName);

}
