package com.sinav.service.impl;

import com.sinav.dto.SinavDto;
import com.sinav.repository.SinavRepository;
import com.sinav.service.async.ISinav;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SinavServiceImpl implements ISinav {

    private final SinavRepository repository;

    @Override
    public List<SinavDto> getAllSinav() {
        return null;
    }

    @Override
    public SinavDto createSinav(SinavDto dto) {
        return null;
    }

    @Override
    public SinavDto updateSinav(String sinavId, SinavDto dto) {
        return null;
    }

    @Override
    public void deleteSinav(String sinavId) {

    }
}
