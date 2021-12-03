package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.EmployeeCreateDto;
import com.doc.manage.model.dto.employee.EmployeeDto;
import com.doc.manage.model.dto.employee.EmployeeUpdateDto;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.organization.OrganizationUpdateDto;
import com.doc.manage.model.dto.subdivision.ManagerDto;
import com.doc.manage.model.dto.task.AuthorEmployeeDto;
import com.doc.manage.model.dto.task.ExecutorEmployeeDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Organization;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    DirectorDto toDirectorDto(Employee entity);

    ManagerDto toManagerDto(Employee entity);

    EmployeeDto toDto(Employee entity);

    Employee toEntity(EmployeeCreateDto employeeCreateDto);

    @Mapping(target = "surname")
    @Mapping(target = "name")
    @Mapping(target = "patronymic")
    @Mapping(target = "position")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, ignoreByDefault = true)
    Employee toUpdateDto(@MappingTarget Employee entity, EmployeeUpdateDto employeeUpdateDto);

    AuthorEmployeeDto toAuthorDto(Employee entity);

}
