package com.naman.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoRepository.findByUsername(getLoggedInUsername());
        modelMap.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String username = getLoggedInUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String goToTodoListPage(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "todo";
//        }
        String username = getLoggedInUsername();
//        todoService.addTodo(username, todo.getDescription(),
//                todo.getTargetDate(), false);
        todoRepository.save(new Todo(todo.getId(), username, todo.getDescription(),
                todo.getTargetDate(), todo.isDone()));
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
//        todoService.deleteTodoById(id);
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @GetMapping("update-todo")
    public String updateTodo(ModelMap modelMap, @RequestParam int id) {
//        todoService.deleteTodoById(id);
        Todo todo = todoRepository.findById(id).get();
        modelMap.put("todo",todo);
        return "todo";
    }


    @PostMapping("update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println("IS error?");
//            return "todo";
//        }
        String username = getLoggedInUsername();
        todo.setUsername(username);
//        todoService.updateTodo(todo);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
