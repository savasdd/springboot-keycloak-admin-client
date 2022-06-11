package com.sinav.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "SVS_SINAV_SONUC")
public class SinavSonuc {

    @Id
    @Column(name = "SONUC_ID")
    @GeneratedValue(generator = "UUID")
    @Type(type = "pg-uuid")
    private UUID sonucId;

    @Column(name = "TC_KIMLIK_NO")
    private Long tcKimlikNo;

    @Column(name = "AD")
    private String ad;

    @Column(name = "SOYAD")
    private String soyad;

    @Column(name = "PUAN")
    private Double puan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SINAV_ID")
    private Sinav sinav;
}
