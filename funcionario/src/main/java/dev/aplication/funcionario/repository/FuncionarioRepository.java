package dev.aplication.funcionario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aplication.funcionario.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    Optional<Funcionario> findByEmailFuncionario(String emailFuncionario);

    Optional<Funcionario> findByCpfFuncionario(String cpfFuncionario);

    boolean existsByEmailFuncionario(String emailFuncionario);

    boolean existsByCpfFuncionario(String cpfFuncionario);
}