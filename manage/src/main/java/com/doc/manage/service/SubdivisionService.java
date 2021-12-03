package com.doc.manage.service;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.subdivision.*;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import com.doc.manage.model.entity.Subdivision;
import com.doc.manage.repository.EmployeeRepository;
import com.doc.manage.repository.OrganizationRepository;
import com.doc.manage.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SubdivisionService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public OrganizationRepository organizationRepository;

    @Autowired
    public SubdivisionRepository subdivisionRepository;

    @Autowired
    public OrganizationMapper organizationMapper;

    @Autowired
    public EmployeeMapper employeeMapper;

    @Autowired
    public SubdivisionMapper subdivisionMapper;


    public SubdivisionDto findById(Integer id){

        final Subdivision subdivision = subdivisionRepository.findById(id).orElse(new Subdivision());
        final Employee manager = subdivision.getManager();
        final Organization org = subdivision.getOrg();
        final ManagerDto managerDto = employeeMapper.toManagerDto(manager);
        final OrganizationSubdivisionDto organization = organizationMapper.toOrgSubDto(org);
        final SubdivisionDto subdivisionDto = subdivisionMapper.toDto(subdivision);
        subdivisionDto.setManager(managerDto);
        subdivisionDto.setOrganizationSubdivisionDto(organization);

        return subdivisionDto;
    }

    public void createSub(Integer managerId, Integer organizationId,SubdivisionCreateDto subdivisionCreateDto){

        final Organization organization = organizationRepository.findById(organizationId).orElse(null);
        final Employee employee = employeeRepository.findById(managerId).orElse(null);
        final Subdivision subdivision = subdivisionMapper.toEntity(subdivisionCreateDto);
        subdivision.setManager(employee);
        subdivision.setOrg(organization);
        subdivisionRepository.save(subdivision);
    }

    public SubdivisionDto updateSub(Integer id, SubdivisionUpdateDto subdivisionUpdateDto){

        final Subdivision subdivision = subdivisionRepository.findById(id).orElse(null);
        final Employee manager = subdivision.getManager();
        final ManagerDto managerDto = employeeMapper.toManagerDto(manager);

        final Organization organization = subdivision.getOrg();
        final Integer organizationId = organization.getId();
        final Organization org = organizationRepository.findById(organizationId).orElse(null);
        final OrganizationSubdivisionDto organizationSubdivisionDto = organizationMapper.toOrgSubDto(organization);

        final Subdivision subdivsionUpdated = subdivisionMapper.toUpdateDtoSubDiv(subdivision, subdivisionUpdateDto);
        if(org != null) subdivsionUpdated.setOrg(org);

        final Subdivision subUpdated = subdivisionRepository.save(subdivsionUpdated);
        final SubdivisionDto subDto = subdivisionMapper.toDto(subUpdated);
        subDto.setManager(managerDto);
        subDto.setOrganizationSubdivisionDto(organizationSubdivisionDto);

        return subDto;
    }

    public void deleteSub(Integer id){

        final Subdivision subdivision = subdivisionRepository.findById(id).orElse(new Subdivision());
        subdivisionRepository.delete(subdivision);
    }

    public SubdivisionDto findByName(String name){

        final Subdivision subdivision = subdivisionRepository.findByName(name).orElse(null);
        final Employee manager = subdivision.getManager();
        final ManagerDto managerDto = employeeMapper.toManagerDto(manager);

        final Organization organization = subdivision.getOrg();
        final OrganizationSubdivisionDto organizationSubdivisionDto = organizationMapper.toOrgSubDto(organization);

        final SubdivisionDto subdivisionDto = subdivisionMapper.toDto(subdivision);
        subdivisionDto.setManager(managerDto);
        subdivisionDto.setOrganizationSubdivisionDto(organizationSubdivisionDto);

        return subdivisionDto;
    }

}
