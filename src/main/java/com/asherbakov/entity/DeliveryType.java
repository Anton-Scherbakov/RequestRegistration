package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "delivery_type")
@Getter
@Setter
public class DeliveryType {
    @Id
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
    @OneToMany(mappedBy = "deliveryTypeId")
    private Set<Request> requestSet = new HashSet<>();
}
