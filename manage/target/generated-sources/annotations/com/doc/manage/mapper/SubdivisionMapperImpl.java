package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.SubdivDto;
import com.doc.manage.model.dto.subdivision.ManagerDto;
import com.doc.manage.model.dto.subdivision.SubdivisionCreateDto;
import com.doc.manage.model.dto.subdivision.SubdivisionDto;
import com.doc.manage.model.dto.subdivision.SubdivisionUpdateDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Subdivision;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T18:25:57+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class SubdivisionMapperImpl implements SubdivisionMapper {

    @Override
    public SubdivisionDto toDto(Subdivision ent) {
        if ( ent == null ) {
            return null;
        }

        SubdivisionDto subdivisionDto = new SubdivisionDto();

        subdivisionDto.setName( ent.getName() );
        subdivisionDto.setContacts( ent.getContacts() );
        subdivisionDto.setId( ent.getId() );
        subdivisionDto.setManager( employeeToManagerDto( ent.getManager() ) );

        return subdivisionDto;
    }

    @Override
    public SubdivDto toSubdivDto(Subdivision entity) {
        if ( entity == null ) {
            return null;
        }

        SubdivDto subdivDto = new SubdivDto();

        subdivDto.setName( entity.getName() );

        return subdivDto;
    }

    @Override
    public Subdivision toEntity(SubdivisionCreateDto subdivisionCreateDto) {
        if ( subdivisionCreateDto == null ) {
            return null;
        }

        Subdivision subdivision = new Subdivision();

        subdivision.setName( subdivisionCreateDto.getName() );
        subdivision.setContacts( subdivisionCreateDto.getContacts() );

        return subdivision;
    }

    @Override
    public Subdivision toUpdateDtoSubDiv(Subdivision subEntity, SubdivisionUpdateDto subdivisionUpdateDto) {
        if ( subdivisionUpdateDto == null ) {
            return null;
        }

        if ( subdivisionUpdateDto.getName() != null ) {
            subEntity.setName( subdivisionUpdateDto.getName() );
        }
        if ( subdivisionUpdateDto.getContacts() != null ) {
            subEntity.setContacts( subdivisionUpdateDto.getContacts() );
        }

        return subEntity;
    }

    protected ManagerDto employeeToManagerDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        ManagerDto managerDto = new ManagerDto();

        managerDto.setName( employee.getName() );
        managerDto.setSurname( employee.getSurname() );

        return managerDto;
    }
}
