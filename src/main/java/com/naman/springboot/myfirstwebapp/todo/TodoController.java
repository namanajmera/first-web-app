package com.naman.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    public String listAllTodos(ModelMap modelMap){

        List<Todo> todos = todoService.findByUserName("naman");
        modelMap.put("todos",todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(){
        return "todo";
    }

    @PostMapping("/add-todo")
    public String goToTodoListPage(@RequestParam String description, ModelMap modelMap){
        System.out.println(description);
        String username = (String)modelMap.get("name");
        todoService.addTodo(username, description,
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
