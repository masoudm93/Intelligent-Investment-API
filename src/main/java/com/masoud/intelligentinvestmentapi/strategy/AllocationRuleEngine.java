package com.masoud.intelligentinvestmentapi.strategy;

import com.masoud.intelligentinvestmentapi.util.RiskTolerance;

import java.util.Map;

public class AllocationRuleEngine {

    public static Map<String, Double> getAllocationPercentages(RiskTolerance risk) {
        return switch (risk) {
            case LOW -> Map.of(
                    "STOCKS", 30.0,
                    "BONDS", 50.0,
                    "CRYPTO", 5.0,
                    "CASH", 15.0
            );
            case MEDIUM -> Map.of(
                    "STOCKS", 50.0,
                    "BONDS", 30.0,
                    "CRYPTO", 10.0,
                    "CASH", 10.0
            );
            case HIGH -> Map.of(
                    "STOCKS", 70.0,
                    "BONDS", 10.0,
                    "CRYPTO", 15.0,
                    "CASH", 5.0
            );
        };
    }
}
