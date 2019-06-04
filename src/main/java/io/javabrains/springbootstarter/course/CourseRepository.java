package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> //here second generic type represent type of Primary key
{

	//public List<Course> findByName(String name);	//You don't have to implement the method! Just declare the method with
									//findByProperty name format, and Spring Data JPA will implement the method for you.
									//make sure you always write method name in camel-case
	
	//public List<Course> findByDescription(String desc);
	
	public List<Course> findByTopicId(String topicId); //with method name we can only use String property as method name,
						//But in Course class Topic is not a String property, so we use Id field of Topic class in method name
					//as here Topic is property of Course class and Id is String type property in Topic class
	
}
