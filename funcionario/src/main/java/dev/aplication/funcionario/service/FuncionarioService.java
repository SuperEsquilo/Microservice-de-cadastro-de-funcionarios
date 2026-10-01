package dev.aplication.funcionario.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.aplication.funcionario.exception.FuncionarioNaoEncontradoException;
import dev.aplication.funcionario.model.Funcionario;
import dev.aplication.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
            .orElseThrow(() -> new FuncionarioNaoEncontradoException("ID do funcionario não encontrado" + id));
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario) {
        Funcionario funcionarioSalvo = new Funcionario();

        funcionarioSalvo.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioSalvo.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioSalvo.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioSalvo.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioSalvo.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioSalvo.setRgFuncionario(funcionario.getRgFuncionario());
        funcionarioSalvo.setAtivo(true);

        return funcionarioRepository.save(funcionarioSalvo);
    }

    @Transactional
    public Funcionario atualizar(Funcionario funcionario) {
        Funcionario funcionarioAtualizado = new Funcionario();

        funcionarioAtualizado.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioAtualizado.setEmailFuncionario(funcionario.getEmailFuncionario());
        funcionarioAtualizado.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioAtualizado.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioAtualizado.setRgFuncionario(funcionario.getRgFuncionario());

        return funcionarioRepository.save(funcionarioAtualizado);
    }

    @Transactional
    public void deletar(Long id) {
        Funcionario funcionario = buscarPorId(id);
        funcionario.setAtivo(false);
        funcionarioRepository.deleteById(id);
    }
}