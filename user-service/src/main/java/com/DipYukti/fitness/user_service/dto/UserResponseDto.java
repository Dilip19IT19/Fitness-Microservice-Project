package com.DipYukti.fitness.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
