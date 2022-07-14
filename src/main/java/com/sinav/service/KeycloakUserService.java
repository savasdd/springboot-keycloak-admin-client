package com.sinav.service;

import com.sinav.service.async.IKeycloakUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class KeycloakUserService {

    @Autowired
    private IKeycloakUserService userService;
}
