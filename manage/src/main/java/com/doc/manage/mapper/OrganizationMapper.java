package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.OrgDto;
import com.doc.manage.model.dto.organization.OrganizationCreateDto;
import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.organization.OrganizationUpdateDto;
import com.doc.manage.model.dto.subdivision.OrganizationSubdivisionDto;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.model.entity.Subdivision;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDto toDto(Organization entity);

    Organization toEntity(OrganizationCreateDto createDto);

    @Mapping(target = "name")
    @Mapping(target = "physAddress")
    @Mapping(target = "legAddress")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, ignoreByDefault = true)
    Organization toUpdateDto(@MappingTarget Organization entity, OrganizationUpdateDto updateOrg);

    OrganizationSubdivisionDto toOrgSubDto(Organization entity);

    OrgDto toOrgDto(Organization entity);

}
