package com.sinav.controller;

import com.sinav.dto.UserDto;
import com.sinav.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/auth")
    public ResponseEntity<Map<String, String>> authToken(@RequestBody UserDto dto) {
        return new ResponseEntity<>(service.getAuthService().authToken(dto), HttpStatus.OK);
    }

}
