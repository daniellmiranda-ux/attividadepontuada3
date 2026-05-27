package com.example.atividade19.service;

import com.example.atividade19.dto.FuncionarioRequestDTO;
import com.example.atividade19.dto.FuncionarioResponseDTO;
import com.example.atividade19.model.FuncionarioModel;
import com.example.atividade19.repository.FuncionarioRepository;
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
        novoFuncionario.setCpf(dto.getCpf());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());
        novoFuncionario.setSetor(dto.getSetor());
        novoFuncionario.setSalario(dto.getSalario());
        return repository.save(novoFuncionario);
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioRequestDTO dto) {

        FuncionarioModel funcionario = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Funcionário não encontrado."));

        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmail(dto.getEmail());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setSetor(dto.getSetor());
        funcionario.setSalario(dto.getSalario());

        return repository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {

        FuncionarioModel funcionario = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Funcionário não encontrado."));

        repository.delete(funcionario);
    }
}
