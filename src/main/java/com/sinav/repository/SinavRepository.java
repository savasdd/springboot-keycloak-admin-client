package com.sinav.repository;

import com.sinav.model.Sinav;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SinavRepository extends JpaRepository<Sinav, UUID> {
}
