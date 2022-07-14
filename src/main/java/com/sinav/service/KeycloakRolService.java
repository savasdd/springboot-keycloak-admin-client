package com.sinav.service;

import com.sinav.service.async.IKeycloakRolService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class KeycloakRolService {

    @Autowired
    private IKeycloakRolService rol;
}
