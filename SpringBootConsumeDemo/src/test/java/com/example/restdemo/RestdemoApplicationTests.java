package com.example.restdemo;

import com.example.restdemo.Entity.Todo;
import com.example.restdemo.Entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestdemoApplicationTests {

    @Test
    public void contextLoads() {

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("==========");
        System.out.println("==========");
        //get Todo
//      ResponseEntity<Todo[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos",
//                Todo[].class);

//        ResponseEntity<User> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/1",
//                User.class);
//        System.out.println("*** "+response.getBody());

        ResponseEntity<Todo> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/1",
                Todo.class);
        System.out.println("*** "+response.getBody());


//        ResponseEntity<Object[]> retorno = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/1",
//                Object[].class);
//
//        System.out.println(retorno);

        //user.setName(retorno.get);

        //post
//        Todo todo = new Todo();
//        todo.setUserId(2);
//        todo.setTitle("titulo");
//        todo.setCompleted(true);
//        ResponseEntity<Todo> postTest = restTemplate.postForEntity("https://jsonplaceholder.typicode.com/todos",
//                todo, Todo.class);
//        System.out.println("postTest "+postTest);
    }


}
