package com.sinav.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "SVS_SINAV")
public class Sinav {

    @Id
    @Column(name = "SINAV_ID")
    @GeneratedValue(generator = "UUID")
    @Type(type = "pg-uuid")
    private UUID sinavId;

    @Column(name = "SINAV_ADI")
    private String sinavAdi;

    @Column(name = "SINAV_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date sinavTarihi;

    @Column(name = "SINAV_YAYINDA")
    private Boolean sinavYayinda;
}
