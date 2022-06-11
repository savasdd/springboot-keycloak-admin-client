package com.sinav.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class SinavDto {

    private UUID sinavId;

    private String sinavAdi;

    private Date sinavTarihi;

    private Boolean sinavYayinda;
}
