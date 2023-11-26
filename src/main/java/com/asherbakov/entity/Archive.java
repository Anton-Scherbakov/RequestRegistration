package com.asherbakov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Archive {
    @Id
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 100)
    private String address;
}
