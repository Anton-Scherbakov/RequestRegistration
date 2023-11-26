package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country {
    @Id
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
}
