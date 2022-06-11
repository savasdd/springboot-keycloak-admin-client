package com.sinav.repository;

import com.sinav.model.SinavSonuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SinavSonucRepository extends JpaRepository<SinavSonuc, UUID> {
}
