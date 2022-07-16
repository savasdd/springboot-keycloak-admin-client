package com.sinav.service;

import com.sinav.service.async.IKeycloakUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class KeycloakUserService {

    private final IKeycloakUserService userService;
}
