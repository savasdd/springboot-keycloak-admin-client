package com.sinav.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "SVS_USER_GOREV")
public class UserGorev {

    @Id
    @Column(name = "GOREV_ID")
    @GeneratedValue(generator = "UUID")
    @Type(type = "pg-uuid")
    private UUID gorevId;

    @Column(name = "TC")
    private Long tc;

    @Column(name = "AD")
    private String ad;

    @Column(name = "SOYAD")
    private String soyad;

    @Column(name = "BIRIM")
    private String birim;

    @Column(name = "SEVIYE")
    private String seviye;

    @Column(name = "ASIL")
    private Boolean asil;
}
