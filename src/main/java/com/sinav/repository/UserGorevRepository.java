package com.sinav.repository;

import com.sinav.model.UserGorev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserGorevRepository extends JpaRepository<UserGorev, UUID> {
}
