package com.example.atividadepontuada2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "O salário é obrigátorio")
    private double salario;


    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
    }

    public @NotBlank(message = "O nome é obrigatório") @Size(max = 200, message = "O nome deve ter menos de 200 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") @Size(max = 200, message = "O nome deve ter menos de 200 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CPF é obrigátorio") @Size(min = 14, message = "O CPF deve conter 14 caracteres") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O CPF é obrigátorio") @Size(min = 14, message = "O CPF deve conter 14 caracteres") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O E-mail é obrigátorio") @Email(message = "Deve ser um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O E-mail é obrigátorio") @Email(message = "Deve ser um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone é obrigátorio") @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 dígitos.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigátorio") @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 dígitos.") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "O setor é obrigátorio") @Size(min = 3, max = 15, message = "O setor deve ter entre 3 e 15 caracteres") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "O setor é obrigátorio") @Size(min = 3, max = 15, message = "O setor deve ter entre 3 e 15 caracteres") String setor) {
        this.setor = setor;
    }

    @NotBlank(message = "O salário é obrigátorio")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotBlank(message = "O salário é obrigátorio") double salario) {
        this.salario = salario;
    }
}
