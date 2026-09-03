package com.example.picpay_desafio_backend.repository;

import com.example.picpay_desafio_backend.model.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    private Long proximoId = 1L;

    public Funcionario save(Funcionario funcionario) {

        funcionario.setId(proximoId++);

        funcionarios.add(funcionario);

        return funcionario;
    }

    public List<Funcionario> findAll() {

        return funcionarios;
    }

    public Optional<Funcionario> findById(Long id) {

        return funcionarios.stream()
                .filter(funcionario ->
                        funcionario.getId().equals(id)
                )
                .findFirst();
    }

    public void delete(Funcionario funcionario) {

        funcionarios.remove(funcionario);
    }
}