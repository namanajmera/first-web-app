package com.naman.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount,"naman","Learn Spring Boot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount,"naman","Learn React", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount,"naman","Learn Vue", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUserName(String username){
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount,username,description,targetDate,done);
        todos.add(todo);
    }

    public int getTodoCount() {
        return ++todoCount;
    }

    public void deleteTodoById(int id){
        Predicate<?super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
