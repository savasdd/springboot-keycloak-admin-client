package com.sinav.controller;

import com.sinav.dto.SinavSonucDto;
import com.sinav.service.SinavSonucService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class SinavSonucController {

    private final SinavSonucService service;

    @Validated
    @GetMapping("/sinavsonucs")
    public ResponseEntity<List<SinavSonucDto>> getAllSonuc() {
        return new ResponseEntity<>(service.getSonuc().getAllSonuc(), HttpStatus.OK);
    }

    @Validated
    @GetMapping("/sinavs/sinavsonucs/{id}")
    public ResponseEntity<List<SinavSonucDto>> getSonucBySinav(@PathVariable String id) {
        return new ResponseEntity<>(service.getSonuc().getSonucBySinav(id), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/sinavsonucs")
    public ResponseEntity<SinavSonucDto> postSonuc(@RequestBody SinavSonucDto dto) {
        return new ResponseEntity<>(service.getSonuc().createSonuc(dto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/sinavsonucs/{id}")
    public ResponseEntity<SinavSonucDto> putSonuc(@PathVariable String id, @RequestBody SinavSonucDto dto) {
        return new ResponseEntity<>(service.getSonuc().updateSonuc(id, dto), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/sinavsonucs/{id}")
    public ResponseEntity<?> deleteSonuc(@PathVariable String id) {
        service.getSonuc().deleteSonuc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
