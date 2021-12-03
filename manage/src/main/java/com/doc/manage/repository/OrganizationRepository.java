package com.doc.manage.repository;

import com.doc.manage.model.entity.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization, Integer>{

    Optional<Organization> findByName(String name);

}
