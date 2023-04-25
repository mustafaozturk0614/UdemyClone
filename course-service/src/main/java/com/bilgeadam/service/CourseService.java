package com.bilgeadam.service;

import com.bilgeadam.dto.request.NewCourseCreateRequestDto;
import com.bilgeadam.manager.IUserManager;
import com.bilgeadam.mapper.ICourseMapper;
import com.bilgeadam.repository.ICourseRepository;
import com.bilgeadam.repository.entity.Course;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends ServiceManager<Course,String> {


    private final ICourseRepository courseRepository;
    private final IUserManager userManager;

    public CourseService(ICourseRepository courseRepository, IUserManager userManager) {
        super(courseRepository);
        this.courseRepository = courseRepository;
        this.userManager = userManager;
    }

    public Course create(NewCourseCreateRequestDto dto) {
        Course course= ICourseMapper.INSTANCE.toCourse(dto);

        boolean kontrol= userManager.isTeacher(dto.getInstructorId()).getBody();

        if (kontrol){
            return save(course);
        }else{
            throw  new RuntimeException("Yetkisiz kullanıcı");

        }


    }
}
