package com.example.lab7lms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "id must be not Empty")
    private String id;
    @NotEmpty(message = "name must be not Empty")
    @Pattern(regexp = "[a-zA-Z]+",message = "name must only contain char")
    private String name;
    @jakarta.validation.constraints.Email(message = "must be valid Email")
    private String Email;
    @Pattern(regexp = "^05.[0-9]+",message = "phone number must starts with 05")
    @Size(max = 10,min = 10,message = "phone number must be 10 digits")
    @NotEmpty(message = "phone number should not be null")
    private String PhoneNumber;
    @NotNull(message = "age must not be null")
    @Min(value = 25,message = "the age must be more than 25")
    @Positive(message = "age must be positive")
    private int age;
    @NotEmpty(message = "the specialization should not be null")
    private String specialization;
    private Subject subject;
}
