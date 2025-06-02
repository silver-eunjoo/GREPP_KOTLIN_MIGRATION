package com.grepp.curdsample.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
//    @Column(name = "tasks_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true)
    private String code;

    private String title;
    private String description;

    private Integer priority;

    private boolean completeStatus = false;

    private LocalDate startTime;
    private LocalDate endTime;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
