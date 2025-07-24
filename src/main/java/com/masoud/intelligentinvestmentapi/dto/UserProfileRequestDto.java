package com.masoud.intelligentinvestmentapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequestDto {

    @Min(18)
    private int age;

    @Min(100)
    private double capital;

    @NotNull
    private String riskTolerance; // Enum: LOW, MEDIUM, HIGH

    @Min(1)
    private int investmentHorizon;
}
