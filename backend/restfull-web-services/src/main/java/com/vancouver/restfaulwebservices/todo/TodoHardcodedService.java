package com.vancouver.restfaulwebservices.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "vancouver", "Learn to Code", new Date(), false));
        todos.add(new Todo(++idCounter, "vancouver", "Learn Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "vancouver", "Learn ReactJS", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
}