package com.masoud.intelligentinvestmentapi.service;

import com.masoud.intelligentinvestmentapi.dto.AllocationRequestDto;
import com.masoud.intelligentinvestmentapi.dto.AllocationResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AllocationService {
    AllocationResponseDto generateAllocation(AllocationRequestDto request);
    List<AllocationResponseDto> getUserAllocations(UUID userId);
    List<AllocationResponseDto> getAllocationsByUserAndDate(UUID userId, LocalDateTime from, LocalDateTime to);

}
