package com.example.atividade19.service;

import com.example.atividade19.dto.ClienteRequestDTO;
import com.example.atividade19.dto.ClienteResponseDTO;
import com.example.atividade19.model.ClienteModel;
import com.example.atividade19.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<ClienteResponseDTO> listarTodos() {

        return repository
                .findAll()
                .stream()
                .map(c -> new ClienteResponseDTO(
                        c.getNome(),
                        c.getEmail(),
                        c.getDataNascimento()
                ))
                .toList();
    }

    public ClienteModel salvarCliente(ClienteRequestDTO dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado.");
        }

        ClienteModel novoCliente = new ClienteModel();

        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());
        novoCliente.setDataNascimento(dto.getDataNascimento());
        novoCliente.setEmail(dto.getEmail());

        novoCliente.setSenha(
                passwordEncoder.encode(dto.getSenha())
        );

        return repository.save(novoCliente);
    }

    public ClienteModel atualizarCliente(Long id, ClienteRequestDTO dto) {

        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado."));

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setEmail(dto.getEmail());

        cliente.setSenha(
                passwordEncoder.encode(dto.getSenha())
        );

        return repository.save(cliente);
    }

    public void deletarCliente(Long id) {

        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado."));

        repository.delete(cliente);
    }
}
