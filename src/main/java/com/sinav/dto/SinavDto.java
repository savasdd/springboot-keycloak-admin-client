package com.sinav.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
public class SinavDto {

    private UUID sinavId;

    private String sinavAdi;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date sinavTarihi;

    private Boolean sinavYayinda;
}
