package com.sinav.controller;

import com.sinav.dto.RolDto;
import com.sinav.service.async.IKeycloakRolService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class KeycloakRolController {

    @Autowired
    private IKeycloakRolService service;

    @PostMapping("/keycloaks/roles")
    public ResponseEntity<?> createRol(@RequestBody RolDto dto) throws Exception {
        service.createRol(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/keycloaks/roles")
    public ResponseEntity<List<RoleRepresentation>> findAllRol() {
        return new ResponseEntity<>(service.findAllRole(), HttpStatus.OK);
    }

    @GetMapping("/keycloaks/roles/{rolAdi}")
    public ResponseEntity<RoleRepresentation> findRolByName(@PathVariable String rolAdi) {
        return new ResponseEntity<>(service.findRolByName(rolAdi), HttpStatus.OK);
    }

    @DeleteMapping("/keycloaks/roles/{rolAdi}")
    public ResponseEntity<?> deleteRol(@PathVariable String rolAdi) {
        service.deleteRol(rolAdi);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/keycloaks/roles/{rolAdi}/users")
    public ResponseEntity<List<UserRepresentation>> usersOfRole(@PathVariable String rolAdi) {
        return new ResponseEntity<>(service.usersOfRole(rolAdi), HttpStatus.OK);
    }

}
