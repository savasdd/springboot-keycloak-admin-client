package com.sinav.service;

import com.sinav.service.async.IKeycloakGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class KeycloakGroupService {

    @Autowired
    private IKeycloakGroupService group;
}
