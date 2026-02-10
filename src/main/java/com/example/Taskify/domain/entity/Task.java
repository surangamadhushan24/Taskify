package com.example.Taskify.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false ,nullable = false)
    private UUID id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "title",length = 1088)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Column(name = "due_date")
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority",nullable = false)
    private TaskPriority priority;

    @Column(name = "created",nullable = false,updatable = false)
    private Instant created;
    @Column(name = "updated",nullable = false)
    private Instant updated;
}
