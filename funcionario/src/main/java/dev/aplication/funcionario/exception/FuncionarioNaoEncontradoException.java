package dev.aplication.funcionario.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(String message) {
        super(message);
    }

    public FuncionarioNaoEncontradoException(Long id) {
        super("Funcionario não encontrado com o ID: " + id);
    }
}
