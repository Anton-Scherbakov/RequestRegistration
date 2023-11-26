package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Information {
    @Id
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private String text;
}
