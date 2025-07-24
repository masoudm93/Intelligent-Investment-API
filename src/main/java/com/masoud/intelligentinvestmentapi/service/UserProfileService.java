package com.masoud.intelligentinvestmentapi.service;

import com.masoud.intelligentinvestmentapi.dto.UserProfileRequestDto;
import com.masoud.intelligentinvestmentapi.dto.UserProfileResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserProfileService {
    UserProfileResponseDto create(UserProfileRequestDto dto);
    List<UserProfileResponseDto> getAll();
    UserProfileResponseDto getById(UUID id);
}
