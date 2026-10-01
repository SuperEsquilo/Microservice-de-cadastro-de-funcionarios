package dev.aplication.funcionario.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioRequest(
    @NotBlank(message = "O nome do funcionario é obrigatório")
    @Size(min = 3, max = 120, message = "Nome do funcionario deve conter até 120 caracteres")
    String nomeFuncionario,

    @NotBlank(message = "Email do funcionario é obrigatório")
    @Size(max = 120)
    @Email(message = "Formato de e-mail inválid")
    String emailFuncionario,

    @NotBlank(message = "Telefone do funcionario nao pode ser vazio")
    @Size(max = 20)
    String telefoneFuncionario,

    @NotBlank(message = "Nome do cargo do funcionario nao pode ser vazio")
    @Size(max = 120)
    String cargoFuncionario,

    @NotBlank(message = "CPF do funcionario nao pode ser vazio")
    @CPF(message = "Formato de CPF inválido")
    @Size(max = 11)
    String cpfFuncionario,

    boolean ativo
) {
}