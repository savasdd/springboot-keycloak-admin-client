package com.sinav.service.async;

import com.sinav.dto.SinavDto;

import java.util.List;

public interface ISinav {

    public List<SinavDto> getAllSinav();

    public SinavDto createSinav(SinavDto dto);

    public SinavDto updateSinav(String sinavId, SinavDto dto) throws Exception;

    public void deleteSinav(String sinavId);
}
