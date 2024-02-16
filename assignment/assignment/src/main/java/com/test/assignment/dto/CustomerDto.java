package com.test.assignment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CustomerDto {

    @NotEmpty
    private String firstName;

    private String lastName;

    private int age;

    @Email(message = "Please provide a valid email address")
    private String email;
}
