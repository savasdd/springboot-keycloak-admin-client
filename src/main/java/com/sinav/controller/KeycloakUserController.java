package com.sinav.controller;

import com.sinav.dto.UserDto;
import com.sinav.service.async.IKeycloakUserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class KeycloakUserController {

    @Autowired
    private IKeycloakUserService service;

    @GetMapping("/keycloaks/users")
    public ResponseEntity<List<UserRepresentation>> findAllUser() {
        return new ResponseEntity<>(service.findAllUser(), HttpStatus.OK);
    }


    @GetMapping("/keycloaks/users/{userId}")
    public ResponseEntity<UserRepresentation> findByUserId(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(service.findByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/keycloaks/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto dto) {
        service.createUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/keycloaks/users/{userId}")
    public ResponseEntity<Response> deleteUser(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(service.deleteUser(userId), HttpStatus.OK);
    }

    @PostMapping("/keycloaks/users/group")
    public ResponseEntity<?> userAddGroup(@RequestParam("userId") String userId, @RequestParam("groupId") String groupId) {
        service.userAddGroup(userId, groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/keycloaks/users/group")
    public ResponseEntity<?> userLeavGroup(@RequestParam("userId") String userId, @RequestParam("groupId") String groupId) {
        service.userLeavGroup(userId, groupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/keycloaks/users/rol")
    public ResponseEntity<?> userAddRol(@RequestParam("userId") String userId, @RequestParam("rolAdi") String rolAdi) {
        service.userAddRol(userId, rolAdi);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/keycloaks/users/rol")
    public ResponseEntity<?> userDeleteRol(@RequestParam("userId") String userId, @RequestParam("rolAdi") String rolAdi) {
        service.userDeleteRol(userId, rolAdi);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
