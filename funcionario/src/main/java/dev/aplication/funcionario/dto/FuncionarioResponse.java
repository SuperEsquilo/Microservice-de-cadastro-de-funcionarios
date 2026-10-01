package dev.aplication.funcionario.dto;

import java.time.LocalDateTime;

public record FuncionarioResponse(
    Long id,
    String nomeFuncionario,
    String emailFuncionaril,
    String telefoneFuncionario,
    String cfFuncionario,
    String rgFuncionario,
    boolean ativo,
    LocalDateTime contratadoEm,
    LocalDateTime atualizadoEm
) {
}