package com.fifi.java.practise.springhibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fifi.java.practise.springhibernate.obj.Comment;
import com.fifi.java.practise.springhibernate.obj.Post;
import com.fifi.java.practise.springhibernate.repository.CommentDBfactory;
import com.fifi.java.practise.springhibernate.repository.PostDBfactory;
import com.fifi.java.practise.springhibernate.repository.PostRepository;

@ActiveProfiles("test")
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@DataJpaTest
class PostCRUDTests {
	
	@Autowired
    private PostRepository repository;

    @Test    
    public void postCRUD() {

    	//only got insert test cases as this application not involving update/delete logic
    	List list = repository.findAll();
    	List inputList = new ArrayList();
    	
        assertNotNull(list);
        assertEquals(list.size(), 0);

        
        Post johnPost = new Post(1L, "John_title", "john_msg_body");
        Post maryPost = new Post(2L, "Mary_title", "mary_msg_body");
        
        inputList.add(johnPost);
        inputList.add(maryPost);
        
        PostDBfactory.insertPostList(repository, inputList);
        list = repository.findAll();
        
        assertNotNull(list);
        assertEquals(list.size(), 2);
        

    }

}