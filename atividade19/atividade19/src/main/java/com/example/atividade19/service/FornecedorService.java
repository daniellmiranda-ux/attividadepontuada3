package com.example.atividade19.service;

import com.example.atividade19.dto.FornecedorRequestDTO;
import com.example.atividade19.dto.FornecedorResponseDTO;
import com.example.atividade19.model.FornecedorModel;
import com.example.atividade19.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorResponseDTO> listarTodos() {

        return repository
                .findAll()
                .stream()
                .map(f -> new FornecedorResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone()
                ))
                .toList();
    }

    public FornecedorModel salvarFornecedor(FornecedorRequestDTO dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Fornecedor já cadastrado.");
        }

        FornecedorModel novoFornecedor = new FornecedorModel();

        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setCnpj(dto.getCnpj());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);
    }

    public FornecedorModel atualizarFornecedor(Long id, FornecedorRequestDTO dto) {

        FornecedorModel fornecedor = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Fornecedor não encontrado."));

        fornecedor.setNome(dto.getNome());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setTelefone(dto.getTelefone());

        return repository.save(fornecedor);
    }

    public void deletarFornecedor(Long id) {

        FornecedorModel fornecedor = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Fornecedor não encontrado."));

        repository.delete(fornecedor);
    }
}
