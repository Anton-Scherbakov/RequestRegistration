package com.asherbakov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    @Column(name = "registration_number", length = 20, nullable = false)
    private String registrationNumber;
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;
    @Column(name = "middle_name", length = 30)
    private String middleName;
    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;
    @Column(name = "social_number", length = 15)
    private String socialNumber;
    @Column(nullable = false)
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(name = "structural_division_id", nullable = false)
    private StructuralDivision structuralDivision;
    @ManyToOne
    @JoinColumn(name = "purpose_of_request_id", nullable = false)
    private PurposeOfRequest purposeOfRequest;
    @ManyToOne
    @JoinColumn(name = "type_of_request_id", nullable = false)
    private TypeOfRequest typeOfRequest;
    @Column(name = "recipient_id", nullable = false)
    private Long recipient;
    @ManyToOne
    @JoinColumn(name = "delivery_type_id", nullable = false)
    private DeliveryType deliveryType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "date_with", nullable = false)
    private LocalDate dateWith;
    @Column(name = "date_answer")
    private LocalDate dateAnswer;
}
