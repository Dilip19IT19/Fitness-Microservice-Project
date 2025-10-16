package com.DipYukti.fitness.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDto
{
    @NotBlank(message = "valid email must be provided")
    private String email;
    @NotBlank(message = "password must be given")
    private String password;
    @NotBlank(message = "kindly enter first name")
    private String firstName;
    @NotBlank(message = "kindly enter last name")
    private String lastName;

}
