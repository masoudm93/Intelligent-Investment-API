package com.masoud.intelligentinvestmentapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allocation_plans")
public class AllocationPlan {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @ElementCollection
    @CollectionTable(name = "allocation_percentages", joinColumns = @JoinColumn(name = "plan_id"))
    @MapKeyColumn(name = "asset_class")
    @Column(name = "percentage")
    private Map<String, Double> percentageAllocation;

    @ElementCollection
    @CollectionTable(name = "allocation_dollars", joinColumns = @JoinColumn(name = "plan_id"))
    @MapKeyColumn(name = "asset_class")
    @Column(name = "amount")
    private Map<String, Double> dollarAllocation;

    private LocalDateTime createdAt;
}
