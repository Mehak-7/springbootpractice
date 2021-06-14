package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TopicController {
    /*
    because we have an annotation for rest controller,Spring MVC is going to convert the list
        to a json which will be returned in http response

        Spring MVC does this itself

        Method name in controller doesnt matter
     */

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();

    }

    /*
    the {id} means id is a variable in the path
    something that is changing
    not specific

    both variable in the mapping and method input (String id)
    need to have the same name for it to match

    Line 42, 43 {id} and String id -> both have same name

     */
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id)
    {
        return topicService.getTopic(id);
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

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        /*in this method, post body needs to be converted to topic instance
        and add that to the list of topic in service
          */

        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic)
    {

        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
       topicService.deleteTopic(id);
    }

}
