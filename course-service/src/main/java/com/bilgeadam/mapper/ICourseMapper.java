package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.NewCourseCreateRequestDto;
import com.bilgeadam.repository.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICourseMapper {


    ICourseMapper INSTANCE= Mappers.getMapper(ICourseMapper.class);


    Course toCourse(final NewCourseCreateRequestDto dto);

}
