package io.javabrains.courseapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring", "Spring Framework","Spring Framework Description"),
            new Course("java", "Core Java","Core Java Description"),
            new Course("javascript", "JavaScript","JavaScript Description")
    ));

    public List<Course> getAllCourses(){
        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
      //  return courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(id));
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Course course){
        /*
        for(int i =0;i<courses.size();i++){
            Course t = courses.get(i);
            if(t.getId().equals(id)){
                courses.set(i, course);
                return;
            }
        }
        */
        courseRepository.save(course);
    }
    public void deleteCourse(String id){
        /*for(int i = 0;i<courses.size();i++){
            Course t = courses.get(i);
            if(t.getId().equals(id)){
                courses.remove(t);
            }
        }
        */
        Course course = new Course();
        course = courseRepository.findById(id).orElse(null);
        courseRepository.delete(course);

    }


}
