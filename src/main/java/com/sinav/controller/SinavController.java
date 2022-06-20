package com.sinav.controller;

import com.sinav.dto.SinavDto;
import com.sinav.service.SinavService;
import com.sinav.utils.SinavUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequiredArgsConstructor
public class SinavController {

    private final SinavService service;

    @Validated
    @GetMapping("/sinavs")
    @RolesAllowed({SinavUtil.KEYLOACK_ROL})
    public ResponseEntity<List<SinavDto>> getAllSinav() {
        return new ResponseEntity<>(service.getSinav().getAllSinav(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/sinavs")
    @RolesAllowed({SinavUtil.KEYLOACK_ROL})
    public ResponseEntity<SinavDto> postSinav(@RequestBody SinavDto dto) {
        return new ResponseEntity<>(service.getSinav().createSinav(dto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/sinavs/{id}")
    @RolesAllowed({SinavUtil.KEYLOACK_ROL})
    public ResponseEntity<SinavDto> putSinav(@PathVariable String id, @RequestBody SinavDto dto) {
        return new ResponseEntity<>(service.getSinav().updateSinav(id, dto), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/sinavs/{id}")
    @RolesAllowed({SinavUtil.KEYLOACK_ROL})
    public ResponseEntity<?> deleteSinav(@PathVariable String id) {
        service.getSinav().deleteSinav(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
