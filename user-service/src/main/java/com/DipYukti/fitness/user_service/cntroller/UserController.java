package com.DipYukti.fitness.user_service.cntroller;

import com.DipYukti.fitness.user_service.dto.UserRegisterDto;
import com.DipYukti.fitness.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody UserRegisterDto registerDto)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(registerDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
