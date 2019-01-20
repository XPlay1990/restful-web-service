package com.qad.restfulwebservice.todos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ToDo {
    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;
}