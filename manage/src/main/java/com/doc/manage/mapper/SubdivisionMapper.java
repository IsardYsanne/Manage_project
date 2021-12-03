package com.doc.manage.mapper;

import com.doc.manage.model.dto.employee.SubdivDto;
import com.doc.manage.model.dto.subdivision.SubdivisionCreateDto;
import com.doc.manage.model.dto.subdivision.SubdivisionDto;
import com.doc.manage.model.dto.subdivision.SubdivisionUpdateDto;
import com.doc.manage.model.entity.Employee;
import com.doc.manage.model.entity.Subdivision;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SubdivisionMapper {


    @Mapping(target = "name")
    @Mapping(target = "contacts")
    SubdivisionDto toDto(Subdivision ent);

    SubdivDto toSubdivDto(Subdivision entity);

    Subdivision toEntity(SubdivisionCreateDto subdivisionCreateDto);

    @Mapping(target = "name")
    @Mapping(target = "contacts")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, ignoreByDefault = true)
    Subdivision toUpdateDtoSubDiv(@MappingTarget Subdivision subEntity, SubdivisionUpdateDto subdivisionUpdateDto);


}
