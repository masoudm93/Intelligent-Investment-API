package com.masoud.intelligentinvestmentapi.controller;

import com.masoud.intelligentinvestmentapi.dto.AllocationRequestDto;
import com.masoud.intelligentinvestmentapi.dto.AllocationResponseDto;
import com.masoud.intelligentinvestmentapi.service.AllocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/allocations")
@RequiredArgsConstructor
@Tag(name = "Investment Allocation", description = "Endpoints for generating and retrieving allocation plans")
public class AllocationController {

    private final AllocationService allocationService;

    @Operation(summary = "Generate investment allocation",
            description = "Allocates user capital across asset classes using a rules-based strategy based on their risk profile.")
    @PostMapping
    public AllocationResponseDto generate(@RequestBody @Valid AllocationRequestDto request) {
        return allocationService.generateAllocation(request);
    }

    @Operation(summary = "Get all plans for user", description = "Returns all allocation plans generated for a given user ID.")
    @GetMapping("/history/{userId}")
    public List<AllocationResponseDto> getAllPlansForUser(@PathVariable UUID userId) {
        return allocationService.getUserAllocations(userId);
    }

    @Operation(summary = "Get user plans by date range",
            description = "Fetches allocation plans for a user within a specific time period (ISO 8601 format).")
    @GetMapping("/history/{userId}/filter")
    public List<AllocationResponseDto> getAllocationsByDate(
            @PathVariable UUID userId,
            @RequestParam("from") @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to") @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
    ) {
        return allocationService.getAllocationsByUserAndDate(userId, from, to);
    }
}
