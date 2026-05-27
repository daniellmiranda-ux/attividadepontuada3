package com.example.atividade19.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 200, message = "O nome deve ter menos de 200 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigátorio")
    @Size(min = 14, message = "O CPF deve conter 14 caracteres")
    private String cpf;

    @NotBlank(message = "O E-mail é obrigátorio")
    @Email(message = "Deve ser um e-mail válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigátorio")
    @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 dígitos.")
    private String telefone;

    @NotBlank(message = "O setor é obrigátorio")
    @Size(min = 3, max = 15, message = "O setor deve ter entre 3 e 15 caracteres")
    private String setor;

    @NotNull(message = "O salário é obrigátorio")
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
