package com.sinav.service;

import com.sinav.service.async.ISinavSonuc;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SinavSonucService {

    @Autowired
    private ISinavSonuc sonuc;
}
