package com.example.atividade19.controller;

import com.example.atividade19.dto.FornecedorRequestDTO;
import com.example.atividade19.dto.FornecedorResponseDTO;
import com.example.atividade19.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listar() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(
            @Valid @RequestBody FornecedorRequestDTO dto) {

        service.salvarFornecedor(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "mensagem", "Fornecedor cadastrado com sucesso."
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FornecedorRequestDTO dto) {

        service.atualizarFornecedor(id, dto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensagem", "Fornecedor atualizado com sucesso."
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(
            @PathVariable Long id) {

        service.deletarFornecedor(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "mensagem", "Fornecedor deletado com sucesso."
                ));
    }
}
