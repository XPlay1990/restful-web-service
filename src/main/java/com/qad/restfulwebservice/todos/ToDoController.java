package com.qad.restfulwebservice.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoController {

    @Autowired
    private TodoDummyList todoDummyList;

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllTodos(@PathVariable String username) {
        return todoDummyList.returnAllDummys();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoDummyList.getTodoById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable long id) {
        ToDo toDo = todoDummyList.deleteById(id);
        if (toDo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public void updateTodo(){

    }

    @PostMapping("/users/{username}/todos/{id}")
    public void createNewTodo(){

    }
}
