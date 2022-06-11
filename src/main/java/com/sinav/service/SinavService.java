package com.sinav.service;

import com.sinav.service.async.ISinav;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SinavService {

    @Autowired
    private ISinav sinav;
}
