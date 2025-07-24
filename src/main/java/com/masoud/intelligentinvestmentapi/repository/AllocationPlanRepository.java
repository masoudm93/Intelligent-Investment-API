package com.masoud.intelligentinvestmentapi.repository;

import com.masoud.intelligentinvestmentapi.entity.AllocationPlan;
import com.masoud.intelligentinvestmentapi.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AllocationPlanRepository extends JpaRepository<AllocationPlan, UUID> {
    List<AllocationPlan> findByUser(UserProfile user);
    List<AllocationPlan> findByUserAndCreatedAtBetween(UserProfile user, LocalDateTime start, LocalDateTime end);
}
