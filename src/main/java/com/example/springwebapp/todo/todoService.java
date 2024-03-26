package com.example.springwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class todoService {
     private  static List<Todo> todos = new ArrayList<>();
    private static int todoCount =0;
     static {
         todos.add(new Todo(++todoCount,"robin",
                 "lesrning java",
                 LocalDate.now().plusMonths(1), false));
         todos.add(new Todo(++todoCount,"robin",
                 "lesrning java",
                 LocalDate.now().plusMonths(1), false));

     }

     public List<Todo> findAll(){
         return todos;
     }
     public  void addNew(String userName, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCount,userName,description,targetDate,done);
        todos.add(todo);
     }
     public void deleteTodo(int id){
         todos.remove(id);
     }

     public Todo findbyIdTodo(int id){
         Predicate<?super Todo> predicate = todo -> todo.getId() == id;
       Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
     }

    public  void updateTodo(int id, String userName, String description, LocalDate targetDate, boolean done){
        deleteTodo(id);
         Todo todo = new Todo(id,userName,description,targetDate,done);
        todos.add(todo);
    }
}
