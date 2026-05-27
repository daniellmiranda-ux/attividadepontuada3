package com.example.atividade19.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WelcomController {
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> welcome(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensagem", "Bem-vindo à API REST de Daniel Lima Miranda!"
                ));
    }
}
