package com.sinav.dto;

import com.sinav.model.Sinav;
import lombok.Data;

import java.util.UUID;

@Data
public class SinavSonucDto {

    private UUID sonucId;

    private Long tcKimlikNo;

    private String ad;

    private String soyad;

    private Double puan;

    private SinavDto sinav;
}
