package com.example.to_do.list;

import com.example.to_do.list.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private Map<Long, Todo> todoMap = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Todo> getAllTodos() {
        return todoMap.values();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(idCounter++);
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoMap.get(id);
    }
}
