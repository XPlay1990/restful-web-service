package com.qad.restfulwebservice.todos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoDummyList {
    private static List<ToDo> todos = new ArrayList();
    private static int idCounter = 0;


    static {
        todos.add(new ToDo(++idCounter, "Jan", "Learn Spring-Boot", new Date(), false));
        todos.add(new ToDo(++idCounter, "Jan", "Learn Angular", new Date(), false));
        todos.add(new ToDo(++idCounter, "Jan", "Start Business", new Date(), false));
        todos.add(new ToDo(++idCounter, "Jan", "Get Rich", new Date(), false));
    }

    public List<ToDo> returnAllDummys() {
        return todos;
    }

    public ToDo deleteById(long id) {
        ToDo todo = getTodoById(id);

        if (todo == null) {
            return null;
        }

        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    private ToDo getTodoById(long id) {
        for (ToDo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
