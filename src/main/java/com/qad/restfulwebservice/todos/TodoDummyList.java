package com.qad.restfulwebservice.todos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoDummyList {
    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;


    static {
        todos.add(new Todo(++idCounter, "Jan", "Learn Spring-Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "Jan", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "Jan", "Start Business", new Date(), false));
        todos.add(new Todo(++idCounter, "Jan", "Get Rich", new Date(), false));
    }

    public List<Todo> returnAllDummys() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = getTodoById(id);

        if (todo == null) {
            return null;
        }

        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo getTodoById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo saveOrUpdate(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
