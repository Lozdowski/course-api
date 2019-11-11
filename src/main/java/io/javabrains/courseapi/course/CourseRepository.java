package io.javabrains.courseapi.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Course t)
    //deleteTopic(String)
    // dont need it since it is already in library





}
