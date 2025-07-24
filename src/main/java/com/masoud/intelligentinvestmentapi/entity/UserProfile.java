package com.masoud.intelligentinvestmentapi.entity;

import com.masoud.intelligentinvestmentapi.util.RiskTolerance;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue
    private UUID id;

    private int age;
    private double capital;

    @Enumerated(EnumType.STRING)
    private RiskTolerance riskTolerance;

    private int investmentHorizon;
}

