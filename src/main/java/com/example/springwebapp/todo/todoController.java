package com.example.springwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class todoController {

    private todoService todoServ;

    public  todoController(todoService todoServ){
        this.todoServ = todoServ;
    }

    @RequestMapping("todo-list")
    public String getAllTodo(ModelMap map){
       List<Todo> todoList =  todoServ.findAll();
        map.put("todoList",todoList);
        return "todolist";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String getNewTodoPage(){
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@RequestParam String description, ModelMap map){
        String userName = (String)map.get("UserId");
        map.put("description",description);
        todoServ.addNew(userName,description, LocalDate.now().plusMonths(1),false);
        return "redirect:todo-list";
    }

    //deletetodo
    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoServ.deleteTodo(id);
        return "redirect:todo-list";
    }

    //updatetodo
    @RequestMapping(value = "update-todo", method =RequestMethod.GET)
    public String showupdateTodoPage(@RequestParam int id, ModelMap map){
        Todo todo = todoServ.findbyIdTodo(id);
        map.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, @RequestParam String description, ModelMap map){
        String userName = (String)map.get("UserId");
        map.put("description",description);
        todoServ.updateTodo(id, userName, description, LocalDate.now(),false);
        return "redirect:todo-list";
    }
}
