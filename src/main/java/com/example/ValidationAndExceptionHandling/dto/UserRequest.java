package com.example.ValidationAndExceptionHandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username shouldn't be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
    private String mobile;
    private String gender;
    @NotBlank
    private String nationality;
    @Min(18)
    @Max(60)
    private int age;
}

//@AllArgsConstructor(staticName = "build")
//In Lombok's @AllArgsConstructor annotation, the staticName attribute allows you to specify an alternative name for the static factory method generated by Lombok for creating instances of the class with all constructor parameters. By default, Lombok generates a static factory method with the name of (e.g., Order.of(...)).
//
//When you specify staticName = "build", Lombok generates a static factory method named build instead of the default of. For example, with @AllArgsConstructor(staticName = "build"), you can create instances of the class using Order.build(...).
//
//This feature can be useful if you prefer a different name for the static factory method or if the default method name conflicts with existing methods in your class or in other parts of your codebase. It allows you to customize the generated code to fit your preferences or requirements.