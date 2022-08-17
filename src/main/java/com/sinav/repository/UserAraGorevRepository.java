package com.sinav.repository;

import com.sinav.model.UserAraGorev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAraGorevRepository extends JpaRepository<UserAraGorev, UUID> {
}
