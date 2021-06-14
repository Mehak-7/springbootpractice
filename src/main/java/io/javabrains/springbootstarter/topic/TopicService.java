package io.javabrains.springbootstarter.topic;

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
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    //spring when creates an instance of topic service, it can inject an instance of topic repository

    /**
     * This is now a service
     */

public List<Topic> getAllTopics()
{
    // return topics;

    List<Topic> topics = new ArrayList<>();
    topicRepository.findAll()
            .forEach(topics::add);

    return topics;

}

public Topic getTopic(String id)
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

   return topicRepository.findById(id).orElse(null);

}

public void addTopic(Topic topic)
{

    //topics.add(topic);

    topicRepository.save(topic);
}

public void updateTopic(String id, Topic topic)
{
    topicRepository.save(topic);

}

public void deleteTopic(String id)
{
    topicRepository.deleteById(id);


}
}
