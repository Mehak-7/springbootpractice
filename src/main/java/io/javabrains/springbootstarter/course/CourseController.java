package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {
    /*
    because we have an annotation for rest controller,Spring MVC is going to convert the list
        to a json which will be returned in http response

        Spring MVC does this itself

        Method name in controller doesnt matter
     */

    @Autowired
    private CourseController courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id)
    {
        return courseService.getAllCourses(id);

    }

    /*
    the {id} means id is a variable in the path
    something that is changing
    not specific

    both variable in the mapping and method input (String id)
    need to have the same name for it to match

    Line 42, 43 {id} and String id -> both have same name

     */
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    /*
    post mapping
    we need to specify the method since default is get

    map this method to any request to POST to /topics

    Spring MVC gets request body and passes it
    as topic instance in the addTopic("here")

    @RequestBody takes the JSON request and converts
    it to Topic instance to be passed in addTopic
    whenever the URL /topics is mapped
     */

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course)
    {
        /*in this method, post body needs to be converted to topic instance
        and add that to the list of topic in service
          */

        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/cp")
    public void updateCourse(@PathVariable String id, @RequestBody Course course)
    {

        courseService.updateCourse(id,course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteCourse(@PathVariable String id)
    {
       courseService.deleteCourse(id);
    }

}
