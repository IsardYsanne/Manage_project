package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.EmployeeCreateDto;
import com.doc.manage.model.dto.employee.EmployeeDto;
import com.doc.manage.model.dto.employee.EmployeeUpdateDto;
import com.doc.manage.model.dto.organization.DirectorDto;
import com.doc.manage.model.dto.subdivision.ManagerDto;
import com.doc.manage.model.dto.task.AuthorEmployeeDto;
import com.doc.manage.model.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public DirectorDto toDirectorDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        DirectorDto directorDto = new DirectorDto();

        directorDto.setName( entity.getName() );
        directorDto.setSurname( entity.getSurname() );

        return directorDto;
    }

    @Override
    public ManagerDto toManagerDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        ManagerDto managerDto = new ManagerDto();

        managerDto.setName( entity.getName() );
        managerDto.setSurname( entity.getSurname() );

        return managerDto;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( entity.getId() );
        employeeDto.setSurname( entity.getSurname() );
        employeeDto.setName( entity.getName() );
        employeeDto.setPatronymic( entity.getPatronymic() );
        employeeDto.setPosition( entity.getPosition() );

        return employeeDto;
    }

    @Override
    public Employee toEntity(EmployeeCreateDto employeeCreateDto) {
        if ( employeeCreateDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setSurname( employeeCreateDto.getSurname() );
        employee.setName( employeeCreateDto.getName() );
        employee.setPatronymic( employeeCreateDto.getPatronymic() );
        employee.setPosition( employeeCreateDto.getPosition() );

        return employee;
    }

    @Override
    public Employee toUpdateDto(Employee entity, EmployeeUpdateDto employeeUpdateDto) {
        if ( employeeUpdateDto == null ) {
            return null;
        }

        if ( employeeUpdateDto.getSurname() != null ) {
            entity.setSurname( employeeUpdateDto.getSurname() );
        }
        if ( employeeUpdateDto.getName() != null ) {
            entity.setName( employeeUpdateDto.getName() );
        }
        if ( employeeUpdateDto.getPatronymic() != null ) {
            entity.setPatronymic( employeeUpdateDto.getPatronymic() );
        }
        if ( employeeUpdateDto.getPosition() != null ) {
            entity.setPosition( employeeUpdateDto.getPosition() );
        }

        return entity;
    }

    @Override
    public AuthorEmployeeDto toAuthorDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorEmployeeDto authorEmployeeDto = new AuthorEmployeeDto();

        authorEmployeeDto.setSurname( entity.getSurname() );
        authorEmployeeDto.setName( entity.getName() );
        authorEmployeeDto.setPatronymic( entity.getPatronymic() );
        authorEmployeeDto.setPosition( entity.getPosition() );

        return authorEmployeeDto;
    }
}
