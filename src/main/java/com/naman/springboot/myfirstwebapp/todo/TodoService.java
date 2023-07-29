package com.naman.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1,"naman","Learn Spring Boot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"naman","Learn React", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3,"naman","Learn Vue", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }
}
