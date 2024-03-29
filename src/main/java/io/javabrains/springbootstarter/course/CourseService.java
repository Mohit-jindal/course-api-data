package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service		//MVC framework creates single object for Service classes with all dependencies
public class CourseService 
{

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> Courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(Courses::add);
		return Courses;
	}
	
	public Course getCourse(String id)
	{
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course Course)
	{
		courseRepository.save(Course);
	}
	
	public void updateCourse(Course Course)
	{
		courseRepository.save(Course);
	}
	
	public void deleteCourse(String id)
	{
		courseRepository.delete(id);
	}

}
