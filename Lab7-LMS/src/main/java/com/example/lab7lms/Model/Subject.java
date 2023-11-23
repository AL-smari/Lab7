package com.example.lab7lms.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    @NotEmpty(message = "ID should not be Empty")
    private String id;
    @NotEmpty(message = "name of subject should not be Empty")
    private String name;
    @NotEmpty(message = "book should not be Empty")
    private String book;
    @Min(value = 20,message = "the number student must be more than 20")
    @Positive(message = "number of student must be Positive")
    @NotNull(message = "number of student should not be null")
    private int numberOfStudents;
}
