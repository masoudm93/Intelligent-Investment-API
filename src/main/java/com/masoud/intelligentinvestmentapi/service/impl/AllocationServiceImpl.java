package com.masoud.intelligentinvestmentapi.service.impl;

import com.masoud.intelligentinvestmentapi.dto.AllocationRequestDto;
import com.masoud.intelligentinvestmentapi.dto.AllocationResponseDto;
import com.masoud.intelligentinvestmentapi.entity.AllocationPlan;
import com.masoud.intelligentinvestmentapi.entity.UserProfile;
import com.masoud.intelligentinvestmentapi.repository.AllocationPlanRepository;
import com.masoud.intelligentinvestmentapi.repository.UserProfileRepository;
import com.masoud.intelligentinvestmentapi.service.AllocationService;
import com.masoud.intelligentinvestmentapi.strategy.AllocationRuleEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AllocationServiceImpl implements AllocationService {

    private final UserProfileRepository userRepo;
    private final AllocationPlanRepository planRepo;

    @Override
    public AllocationResponseDto generateAllocation(AllocationRequestDto request) {
        UUID userId = request.getUserId();
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double capital = user.getCapital();

        Map<String, Double> percentages = AllocationRuleEngine.getAllocationPercentages(user.getRiskTolerance());
        Map<String, Double> dollarAmounts = new HashMap<>();

        for (Map.Entry<String, Double> entry : percentages.entrySet()) {
            dollarAmounts.put(entry.getKey(), Math.round((entry.getValue() / 100.0 * capital) * 100.0) / 100.0);
        }

        AllocationPlan plan = AllocationPlan.builder()
                .user(user)
                .percentageAllocation(percentages)
                .dollarAllocation(dollarAmounts)
                .createdAt(LocalDateTime.now())
                .build();

        AllocationPlan saved = planRepo.save(plan);
        return mapToDto(saved);
    }

    @Override
    public List<AllocationResponseDto> getUserAllocations(UUID userId) {
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return planRepo.findByUser(user).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<AllocationResponseDto> getAllocationsByUserAndDate(UUID userId, LocalDateTime from, LocalDateTime to) {
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return planRepo.findByUserAndCreatedAtBetween(user, from, to).stream()
                .map(this::mapToDto)
                .toList();
    }

    private AllocationResponseDto mapToDto(AllocationPlan plan) {
        return AllocationResponseDto.builder()
                .userId(plan.getUser().getId())
                .percentageAllocation(plan.getPercentageAllocation())
                .dollarAllocation(plan.getDollarAllocation())
                .build();
    }
}
