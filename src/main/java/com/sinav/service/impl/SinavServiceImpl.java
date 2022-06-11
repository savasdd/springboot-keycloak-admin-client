package com.sinav.service.impl;

import com.sinav.dto.SinavDto;
import com.sinav.model.Sinav;
import com.sinav.repository.SinavRepository;
import com.sinav.service.async.ISinav;
import com.sinav.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SinavServiceImpl implements ISinav {

    private final SinavRepository repository;
    private final MapperUtils mapper;

    @Override
    public List<SinavDto> getAllSinav() {
        log.info("getAll Sinav!");
        return mapper.mapAll(repository.findAll(), SinavDto.class);
    }

    @Override
    public SinavDto createSinav(SinavDto dto) {
        Sinav sinav = repository.save(mapper.map(dto, Sinav.class));
        if (sinav.getSinavId() != null) {
            log.info("Created Sinav: " + sinav.getSinavId());
            return mapper.map(sinav, SinavDto.class);
        }
        return null;
    }

    @Override
    public SinavDto updateSinav(String sinavId, SinavDto dto) {
        Optional<Sinav> sinavs = repository.findById(UUID.fromString(sinavId));

        Sinav sinavToUpdate = sinavs.map(val -> {
            val.setSinavAdi(dto.getSinavAdi() != null ? dto.getSinavAdi() : val.getSinavAdi());
            val.setSinavTarihi(dto.getSinavTarihi() != null ? dto.getSinavTarihi() : val.getSinavTarihi());
            val.setSinavYayinda(dto.getSinavYayinda() != null ? dto.getSinavYayinda() : val.getSinavYayinda());
            return val;
        }).orElseThrow(IllegalArgumentException::new);

        Sinav sinav = repository.save(sinavToUpdate);
        log.info("Sinav Updated: " + sinavId);
        return mapper.map(sinav, SinavDto.class);
    }

    @Override
    public void deleteSinav(String sinavId) {
        repository.deleteById(UUID.fromString(sinavId));
        log.info("Sinav Deleted: " + sinavId);
    }
}
