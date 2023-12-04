package com.asherbakov.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class CreateOrUpdateRequestDTO {
    private Long id;
    private String registrationNumber;
    private String registrationDate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirthday;
    private String socialNumber;
    private int typeOfRequest;
    private int documentPurpose;
    private int sendMethod;
    private List<String> recipient;
}
