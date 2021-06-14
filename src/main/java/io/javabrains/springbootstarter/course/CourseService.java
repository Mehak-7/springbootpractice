package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
This is a business service in Spring

 Spring MVC will detect it using the annotation during class path scan and it
 will find out here that the it's a business service
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    //spring when creates an instance of topic service, it can inject an instance of topic repository

    /**
     * This is now a service
     */

public List<Course> getAllCourses()
{
    // return topics;

    List<Course> courses = new ArrayList<>();
    courseRepository.findAll()
            .forEach(courses::add);

    return courses;

}

public Course getCourse(String id)
{
    /*
    this is a way of finding the exact topic
    for the given id and returning the topic from
    the list topics
    .filter() is checking to match the input id to
    the id in list
    .find first() means the first instance when the id
    matches
    .get() just gets the topic
    (way of writing this is streams and lambda expressions)
     */
   // return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();

   return courseRepository.findById(id).orElse(null);

}

public void addCourse(Course course)
{

    //topics.add(topic);

    courseRepository.save(course);
}

public void updateCourse(String id, Course course)
{
    courseRepository.save(course);

}

public void deleteCourse(String id)
{
    courseRepository.deleteById(id);


}
}
