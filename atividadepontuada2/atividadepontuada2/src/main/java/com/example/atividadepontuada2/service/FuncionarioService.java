package com.example.atividadepontuada2.service;

import com.example.atividadepontuada2.dto.FuncionarioRequestDTO;
import com.example.atividadepontuada2.dto.FuncionarioResponseDTO;
import com.example.atividadepontuada2.model.FuncionarioModel;
import com.example.atividadepontuada2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioResponseDTO> listarTodos() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone(),
                        f.getSetor(),
                        f.getSalario()
                ))
                .toList();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado.");
        }

        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());
        novoFuncionario.setSetor(dto.getSetor());
        novoFuncionario.setSalario(dto.getSalario());
        return repository.save(novoFuncionario);
    }
}
