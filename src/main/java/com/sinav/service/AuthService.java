package com.sinav.service;

import com.sinav.service.async.IAuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class AuthService {

    private final IAuthService authService;

}
