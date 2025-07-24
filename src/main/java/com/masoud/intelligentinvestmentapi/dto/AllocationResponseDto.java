package com.masoud.intelligentinvestmentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllocationResponseDto {
    private UUID userId;
    private Map<String, Double> percentageAllocation;
    private Map<String, Double> dollarAllocation;
}
