package com.masoud.intelligentinvestmentapi.controller;

import com.masoud.intelligentinvestmentapi.dto.UserProfileRequestDto;
import com.masoud.intelligentinvestmentapi.dto.UserProfileResponseDto;
import com.masoud.intelligentinvestmentapi.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User Profile", description = "Endpoints for managing investor profile input")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Operation(summary = "Create user investment profile", description = "Stores user's age, capital, risk tolerance, and investment horizon.")
    @PostMapping
    public UserProfileResponseDto createUser(@RequestBody @Valid UserProfileRequestDto dto) {
        return userProfileService.create(dto);
    }

    @Operation(summary = "Get all user profiles", description = "Retrieves all investor profiles stored in the system.")
    @GetMapping
    public List<UserProfileResponseDto> getAllUsers() {
        return userProfileService.getAll();
    }

    @Operation(summary = "Get user by ID", description = "Fetches a specific user investment profile by UUID.")
    @GetMapping("/{id}")
    public UserProfileResponseDto getUserById(@PathVariable UUID id) {
        return userProfileService.getById(id);
    }
}
