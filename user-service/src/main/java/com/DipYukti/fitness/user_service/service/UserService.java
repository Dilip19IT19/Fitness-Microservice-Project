package com.DipYukti.fitness.user_service.service;

import com.DipYukti.fitness.user_service.dto.UserRegisterDto;
import com.DipYukti.fitness.user_service.dto.UserResponseDto;
import com.DipYukti.fitness.user_service.model.User;
import com.DipYukti.fitness.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto registerNewUser(UserRegisterDto registerDto)
    {
        User user=User
                .builder()
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .build();
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw  new EntityNotFoundException("Email is already in use.");
        }
        User savedUser=userRepository.save(user);
        return UserResponseDto
                .builder()
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .id(savedUser.getId())
                .build();
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserById( Long id)
    {
        User user=userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("user not found with id: "+id));
        return UserResponseDto
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
