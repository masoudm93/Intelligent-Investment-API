package com.masoud.intelligentinvestmentapi.repository;

import com.masoud.intelligentinvestmentapi.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}
