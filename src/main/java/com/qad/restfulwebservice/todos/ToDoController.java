package com.qad.restfulwebservice.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo) {
        ToDo newTodo = todoDummyList.saveOrUpdate(todo);

        return new ResponseEntity<ToDo>(newTodo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createNewTodo(@PathVariable String username, @RequestBody ToDo todo) {
        ToDo todoCreated = todoDummyList.saveOrUpdate(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
