package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "work_day")
@Getter
@Setter
public class WorkDay {
    @Id
    private int id;
    @Column(nullable = false)
    private LocalDate date;
}
