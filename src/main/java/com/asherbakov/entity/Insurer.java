package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Insurer {
    @Id
    private Long id;
    @Column(length = 20, nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
}
