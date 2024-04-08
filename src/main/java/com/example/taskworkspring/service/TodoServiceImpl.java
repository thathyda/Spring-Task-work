package com.example.taskworkspring.service;

import com.example.taskworkspring.model.Todo;
import com.example.taskworkspring.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.getAllTodos();
    }

    @Override
    public Todo getTodoById(Integer id) {
        List<Todo> todoList = todoRepository.getAllTodos();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public void save(Todo todo) {
        Todo lastTodo = todoRepository.getAllTodos().get(todoRepository.getAllTodos().size() - 1);
        todo.setId(lastTodo.getId() + 1);
        todo.setCreatedAt(LocalDate.now());
        todoRepository.getAllTodos().add(todo);
    }

    @Override
    public void update(Todo todo) {
        todoRepository.getAllTodos()
                .stream()
                .filter(t -> t.getId().equals(todo.getId()))
                .forEach(t -> {
                    t.setId(todo.getId());
                    t.setTask(todo.getTask());
                    t.setDescription(todo.getDescription());
                    t.setDone(todo.isDone());
                    t.setCreatedAt(LocalDate.now());
                });

    }

    @Override
    public void delete(Integer id) {
        List<Todo> todoList = todoRepository.getAllTodos();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todoList.remove(todo);
                break;
            }
        }
    }

    @Override
    public void markAsDone(Integer id) {
        List<Todo> todoList = todoRepository.getAllTodos();
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setDone(true);
            }
        }
    }

    @Override
    public List<Todo> searchByTask(String task) {
        List<Todo> todoList = todoRepository.getAllTodos();
        return todoList.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task.toLowerCase()))
                .toList();
    }
}
