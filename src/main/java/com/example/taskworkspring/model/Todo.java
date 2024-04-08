package com.example.taskworkspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDate createdAt;
}
