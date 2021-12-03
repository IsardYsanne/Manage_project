package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.OrgDto;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.organization.OrganizationCreateDto;
import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.organization.OrganizationUpdateDto;
import com.doc.manage.model.dto.subdivision.OrganizationSubdivisionDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDto toDto(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( entity.getId() );
        organizationDto.setName( entity.getName() );
        organizationDto.setPhysAddress( entity.getPhysAddress() );
        organizationDto.setLegAddress( entity.getLegAddress() );
        organizationDto.setDirector( employeeToDirectorDto( entity.getDirector() ) );

        return organizationDto;
    }

    @Override
    public Organization toEntity(OrganizationCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( createDto.getName() );
        organization.setPhysAddress( createDto.getPhysAddress() );
        organization.setLegAddress( createDto.getLegAddress() );

        return organization;
    }

    @Override
    public Organization toUpdateDto(Organization entity, OrganizationUpdateDto updateOrg) {
        if ( updateOrg == null ) {
            return null;
        }

        if ( updateOrg.getName() != null ) {
            entity.setName( updateOrg.getName() );
        }
        if ( updateOrg.getPhysAddress() != null ) {
            entity.setPhysAddress( updateOrg.getPhysAddress() );
        }
        if ( updateOrg.getLegAddress() != null ) {
            entity.setLegAddress( updateOrg.getLegAddress() );
        }

        return entity;
    }

    @Override
    public OrganizationSubdivisionDto toOrgSubDto(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationSubdivisionDto organizationSubdivisionDto = new OrganizationSubdivisionDto();

        organizationSubdivisionDto.setName( entity.getName() );

        return organizationSubdivisionDto;
    }

    @Override
    public OrgDto toOrgDto(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrgDto orgDto = new OrgDto();

        orgDto.setName( entity.getName() );

        return orgDto;
    }

    protected DirectorDto employeeToDirectorDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        DirectorDto directorDto = new DirectorDto();

        directorDto.setName( employee.getName() );
        directorDto.setSurname( employee.getSurname() );

        return directorDto;
    }
}
