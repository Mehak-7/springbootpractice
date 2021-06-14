package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    //fields
    @Id
    private String id;
    private String name;
    private String description;


    //constructor with no arguments-> easy to initialize object
    public Topic()
    {

    }

    //constructor
    public Topic(String id, String name, String description) {
        /*
        The super keyword refers to superclass (parent) objects.
        It is used to call superclass methods, and to access the superclass constructor.
        The most common use of the super keyword is to eliminate the confusion between superclasses
        and subclasses that have methods with the same name.
         */
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
