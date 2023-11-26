package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Num {
    @Id
    private Long id;
    @Column(nullable = false)
    private int number;
    @Column(nullable = false)
    private short year;
}
