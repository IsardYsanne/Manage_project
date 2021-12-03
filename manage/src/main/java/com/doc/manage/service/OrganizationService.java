package com.doc.manage.service;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.organization.OrganizationCreateDto;
import com.doc.manage.model.dto.organization.OrganizationDto;
import com.doc.manage.model.dto.organization.OrganizationUpdateDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.repository.EmployeeRepository;
import com.doc.manage.repository.OrganizationRepository;
import com.doc.manage.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrganizationService {

    @Autowired
    public OrganizationRepository organizationRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public OrganizationMapper organizationMapper;

    @Autowired
    public EmployeeMapper employeeMapper;

    @Autowired
    public SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionMapper subdivisionMapper;


    public OrganizationDto findById(Integer id){

        final Organization organization = organizationRepository.findById(id).orElse(null);
        final Employee director = organization.getDirector();
        final DirectorDto directorDto = employeeMapper.toDirectorDto(director);
        final OrganizationDto organizationDto = organizationMapper.toDto(organization);
        organizationDto.setDirector(directorDto);

        return organizationDto;
    }


    public void createOrg(OrganizationCreateDto organizationCreateDto){

        final Organization organization = organizationMapper.toEntity(organizationCreateDto);
        organizationRepository.save(organization);
    }


    public OrganizationDto updateOrg(Integer id, OrganizationUpdateDto organizationUpdateDto){

        final Organization organization = organizationRepository.findById(id).orElse(new Organization());
        final Employee director = organization.getDirector();
        final DirectorDto directorDto = employeeMapper.toDirectorDto(director);
        final Organization orgUpdated = organizationMapper.toUpdateDto(organization, organizationUpdateDto);
        final Organization updatedOrganization = organizationRepository.save(orgUpdated);
        final OrganizationDto orgDto = organizationMapper.toDto(updatedOrganization);
        orgDto.setDirector(directorDto);

        return orgDto;
    }


    public void deleteOrg(Integer id){

        final Organization organization = organizationRepository.findById(id).orElse(new Organization());
        organizationRepository.delete(organization);
    }


    public OrganizationDto findByName(String name){

        final Organization organization = organizationRepository.findByName(name).orElse(null);
        final Employee director = organization.getDirector();
        final DirectorDto directorDto = employeeMapper.toDirectorDto(director);
        final OrganizationDto orgDto = organizationMapper.toDto(organization);
        orgDto.setDirector(directorDto);

        return orgDto;
    }
}
