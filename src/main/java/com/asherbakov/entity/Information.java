package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private String text;
}
