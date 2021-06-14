package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {

    //All common methods are in crudRepository

    //requires generic type data


}
