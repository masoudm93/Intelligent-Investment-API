package com.masoud.intelligentinvestmentapi.service.impl;

import com.masoud.intelligentinvestmentapi.dto.UserProfileRequestDto;
import com.masoud.intelligentinvestmentapi.dto.UserProfileResponseDto;
import com.masoud.intelligentinvestmentapi.entity.UserProfile;
import com.masoud.intelligentinvestmentapi.repository.UserProfileRepository;
import com.masoud.intelligentinvestmentapi.service.UserProfileService;
import com.masoud.intelligentinvestmentapi.util.RiskTolerance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    @Override
    public UserProfileResponseDto create(UserProfileRequestDto dto) {
        UserProfile profile = UserProfile.builder()
                .age(dto.getAge())
                .capital(dto.getCapital())
                .riskTolerance(RiskTolerance.valueOf(dto.getRiskTolerance().toUpperCase()))
                .investmentHorizon(dto.getInvestmentHorizon())
                .build();

        UserProfile saved = repository.save(profile);
        return mapToDto(saved);
    }

    @Override
    public List<UserProfileResponseDto> getAll() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserProfileResponseDto getById(UUID id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    private UserProfileResponseDto mapToDto(UserProfile profile) {
        return UserProfileResponseDto.builder()
                .id(profile.getId())
                .age(profile.getAge())
                .capital(profile.getCapital())
                .riskTolerance(profile.getRiskTolerance().name())
                .investmentHorizon(profile.getInvestmentHorizon())
                .build();
    }
}
