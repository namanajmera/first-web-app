package com.naman.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {

        List<Todo> todos = todoService.findByUserName("naman");
        modelMap.put("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String goToTodoListPage(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "todo";
//        }
        String username = (String) modelMap.get("name");
        todoService.addTodo(username, todo.getDescription(),
                todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }
    @GetMapping("update-todo")
    public String updateTodo(ModelMap modelMap, @RequestParam int id) {
//        todoService.deleteTodoById(id);
        Todo todo = todoService.findById(id);
        modelMap.put("todo",todo);
        return "todo";
    }


    @PostMapping("update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println("IS error?");
//            return "todo";
//        }
//        String username = (String) modelMap.get("name");
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
