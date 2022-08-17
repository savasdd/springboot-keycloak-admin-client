package com.sinav.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class UserGorevView {

    @Id
    private String gorevId;

    private Long tc;

    private String ad;

    private String soyad;

    private String birim;

    private String seviye;

    private Boolean asil;

    private Long seviyeSize;
}
