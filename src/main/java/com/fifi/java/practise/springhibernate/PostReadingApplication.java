package com.fifi.java.practise.springhibernate;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fifi.java.practise.springhibernate.obj.Post;
import com.fifi.java.practise.springhibernate.repository.PostRepository;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PostReadingApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PostRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PostReadingApplication.class, args);
	}

	
	@GetMapping(path = "/echo", produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public ResponseEntity<Object> echo() {					
        return new ResponseEntity<Object>("Hello World", HttpStatus.OK);
	}
	
    //get parameter
    //The @ResponseBody annotation is used to serialize the JSON document
	@GetMapping(path = "/comments", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getComments(@RequestParam(value = "postId") String postId) {
						
		System.out.println(postId);
		List comments = repository.findCommentByPostId(Long.parseLong(postId));

        return new ResponseEntity<Object>(comments, HttpStatus.OK);
	}	
	
	//path parameter
	@GetMapping(path = "/posts", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> page(@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
		
		List posts = repository.findPostByDate(java.sql.Timestamp.valueOf(startDate + " 00:00:00"), java.sql.Timestamp.valueOf(endDate + " 23:59:59"));

        return new ResponseEntity<Object>(posts, HttpStatus.OK);
	}	
	
	@Override		
	public void run(String... args) throws Exception {

//		logger.info("Student id 10001 -> {}", repository.findById(1L));
//		
		logger.info("All posts -> {}", repository.findAll());
		
		//Insert
//		logger.info("Inserting -> {}", repository.save(new Post("John", 1L)));
//		logger.info("Inserting -> {}", repository.save(new Post("John2", 1L)));
		//Update
		//logger.info("Update 10001 -> {}", repository.save(new Post(10001L, "Name-Updated", null)));

		//repository.deleteById(10002L);
		
//		logger.info("All users 2 -> {}", repository.findAll());
		
		
		
		//List students = repository.findByDate(java.sql.Timestamp.valueOf("2008-01-01 00:00:00"), java.sql.Timestamp.valueOf("2013-09-04 13:30:00"));
//		List students = repository.findPostByDate(java.sql.Timestamp.valueOf("2008-01-01 00:00:00"), java.sql.Timestamp.valueOf("2013-09-04 00:00:00"));
		//List students = repository.findByParentId(1L);
		
//		System.out.println(students);
	}


}



