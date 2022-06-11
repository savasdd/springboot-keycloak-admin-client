package com.sinav.service.impl;

import com.sinav.dto.SinavSonucDto;
import com.sinav.repository.SinavSonucRepository;
import com.sinav.service.async.ISinavSonuc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SinavSonucServiceImpl implements ISinavSonuc {

    private final SinavSonucRepository repository;

    @Override
    public List<SinavSonucDto> getAllSonuc() {
        return null;
    }

    @Override
    public SinavSonucDto createSonuc(SinavSonucDto dto) {
        return null;
    }

    @Override
    public SinavSonucDto updateSonuc(String sonucId, SinavSonucDto dto) {
        return null;
    }

    @Override
    public void deleteSonuc(String sonucId) {

    }

    @Override
    public List<SinavSonucDto> getSonucBySinav(String id) {
        return null;
    }
}
