package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service		//MVC framework creates single object for Service classes with all dependencies
public class TopicService 
{

	@Autowired
	private TopicRepository topicRepository;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Discription"),
			new Topic("java", "Core Java", "Core Java Discription"),
			new Topic("javascript", "JavaScript", "JavaScript Discription"))
		);
	*/
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
		//topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic)
	{
		/*for(int i=0, size = topics.size(); i< size; i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id)
	{
		topicRepository.delete(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}

}
