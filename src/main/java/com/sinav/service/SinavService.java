package com.sinav.service;

import com.sinav.service.async.ISinav;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SinavService {

    private final ISinav sinav;
}
