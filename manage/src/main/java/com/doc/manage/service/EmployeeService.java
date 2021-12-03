package com.doc.manage.service;

import com.doc.manage.mapper.EmployeeMapper;
import com.doc.manage.mapper.OrganizationMapper;
import com.doc.manage.mapper.SubdivisionMapper;
import com.doc.manage.model.dto.employee.*;
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
public class EmployeeService {

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



    public EmployeeDto findById(Integer id){

        final Employee employee = employeeRepository.findById(id).orElse(null);
        final Subdivision subdivEmpl = employee.getSubdivision();
        final SubdivDto sub = subdivisionMapper.toSubdivDto(subdivEmpl);

        final Organization organization = employee.getOrganization();
        final OrgDto orgDto = organizationMapper.toOrgDto(organization);

        final EmployeeDto employeeDto = employeeMapper.toDto(employee);
        employeeDto.setSubdivDto(sub);
        employeeDto.setOrgDto(orgDto);

        return employeeDto;
    }

    public void createEmpl(Integer subdivisionId, Integer organizationId, EmployeeCreateDto employeeCreateDto){

        final Organization organization = organizationRepository.findById(organizationId).orElse(null);
        final Subdivision subdivision = subdivisionRepository.findById(subdivisionId).orElse(null);
        Employee employee = employeeMapper.toEntity(employeeCreateDto);
        employee.setOrganization(organization);
        employee.setSubdivision(subdivision);
        employeeRepository.save(employee);

    }

    public EmployeeDto updateEmpl(Integer id, EmployeeUpdateDto employeeUpdateDto){

        final Employee employee = employeeRepository.findById(id).orElse(null);
        final Subdivision subdivision = employee.getSubdivision();
        final Integer subdivisionId = subdivision.getId();
        final Subdivision subdivId = subdivisionRepository.findById(subdivisionId).orElse(null);
        final SubdivDto subdivDto = subdivisionMapper.toSubdivDto(subdivision);

        final Organization organization = employee.getOrganization();
        final Integer organizationId = organization.getId();
        final Organization org = organizationRepository.findById(organizationId).orElse(null);
        final OrgDto orgDto = organizationMapper.toOrgDto(organization);

        final Employee employeeUpdated = employeeMapper.toUpdateDto(employee, employeeUpdateDto);
        if(subdivId != null) employeeUpdated.setSubdivision(subdivId);
        if(org != null) employeeUpdated.setOrganization(org);

        final Employee emplUpdated = employeeRepository.save(employeeUpdated);
        final EmployeeDto emplDto = employeeMapper.toDto(emplUpdated);
        emplDto.setSubdivDto(subdivDto);
        emplDto.setOrgDto(orgDto);

        return emplDto;
    }

    public void deleteEmpl(Integer id){

        final Employee employee = employeeRepository.findById(id).orElse(new Employee());
        employeeRepository.delete(employee);
    }

    public EmployeeDto findBySurname(String surname){

        final Employee employee = employeeRepository.findBySurname(surname).orElse(null);
        final Subdivision subdiv = employee.getSubdivision();
        final SubdivDto subdivDto = subdivisionMapper.toSubdivDto(subdiv);

        final Organization organization = employee.getOrganization();
        final OrgDto orgDto = organizationMapper.toOrgDto(organization);

        final EmployeeDto employeeDto = employeeMapper.toDto(employee);
        employeeDto.setSubdivDto(subdivDto);
        employeeDto.setOrgDto(orgDto);

        return employeeDto;
    }
}
