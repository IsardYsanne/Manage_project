package com.doc.manage.repository;

import com.doc.manage.model.entity.Subdivision;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubdivisionRepository extends CrudRepository<Subdivision, Integer> {

    Optional<Subdivision> findByName(String name);

}
