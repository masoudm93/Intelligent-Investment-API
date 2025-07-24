package com.masoud.intelligentinvestmentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {

    private UUID id;
    private int age;
    private double capital;
    private String riskTolerance;
    private int investmentHorizon;
}
