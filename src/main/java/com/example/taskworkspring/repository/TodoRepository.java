package com.example.taskworkspring.repository;

import com.example.taskworkspring.data.TodoListDataSource;
import com.example.taskworkspring.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    public List<Todo> getAllTodos(){
        return TodoListDataSource.todoList;
    }
}
