package com.sinav.service.impl;

import com.sinav.dto.SinavDto;
import com.sinav.dto.SinavSonucDto;
import com.sinav.model.Sinav;
import com.sinav.model.SinavSonuc;
import com.sinav.repository.SinavRepository;
import com.sinav.repository.SinavSonucRepository;
import com.sinav.service.async.ISinavSonuc;
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
public class SinavSonucServiceImpl implements ISinavSonuc {

    private final SinavSonucRepository repository;
    private final SinavRepository sinavRepository;
    private final MapperUtils mapper;

    @Override
    public List<SinavSonucDto> getAllSonuc() {
        log.info("SinavSonuc GetAll!");
        return mapper.mapAll(repository.findAll(), SinavSonucDto.class);
    }

    @Override
    public List<SinavSonucDto> getSonucBySinav(String id) {
        log.info("SinavSonuc findBySınav: " + id);
        return mapper.mapAll(repository.findBySinav_SinavId(UUID.fromString(id)), SinavSonucDto.class);
    }

    @Override
    public SinavSonucDto createSonuc(SinavSonucDto dto) {
        Optional<Sinav> sinav = sinavRepository.findById(dto.getSinav().getSinavId());
        dto.setSinav(mapper.map(sinav.get(), SinavDto.class));

        SinavSonuc sonuc = repository.save(mapper.map(dto, SinavSonuc.class));
        if (sonuc.getSonucId() != null) {
            log.info("SinavSonuc Created: " + sonuc.getSonucId());
            return mapper.map(sonuc, SinavSonucDto.class);
        }
        return null;
    }

    @Override
    public SinavSonucDto updateSonuc(String sonucId, SinavSonucDto dto) {
        Optional<SinavSonuc> sonucs = repository.findById(UUID.fromString(sonucId));

        SinavSonuc sonucToUpdate = sonucs.map(val -> {
            val.setAd(dto.getAd() != null ? dto.getAd() : val.getAd());
            val.setSoyad(dto.getSoyad() != null ? dto.getSoyad() : val.getSoyad());
            val.setTcKimlikNo(dto.getTcKimlikNo() != null ? dto.getTcKimlikNo() : val.getTcKimlikNo());
            val.setPuan(dto.getPuan() != null ? dto.getPuan() : val.getPuan());
            return val;
        }).orElseThrow(IllegalArgumentException::new);

        SinavSonuc sonuc = repository.save(sonucToUpdate);
        log.info("SinavSonuc Updated:" + sonucId);

        return mapper.map(sonuc, SinavSonucDto.class);
    }

    @Override
    public void deleteSonuc(String sonucId) {
        repository.deleteById(UUID.fromString(sonucId));
        log.info("SinavSonuc Deleted: " + sonucId);
    }


}
