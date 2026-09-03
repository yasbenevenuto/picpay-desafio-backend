package com.example.picpay_desafio_backend.service;

import com.example.picpay_desafio_backend.dto.FuncionarioPatchDTO;
import com.example.picpay_desafio_backend.dto.FuncionarioRequestDTO;
import com.example.picpay_desafio_backend.exception.FuncionarioNotFoundException;
import com.example.picpay_desafio_backend.mapper.FuncionarioMapper;
import com.example.picpay_desafio_backend.model.Funcionario;
import com.example.picpay_desafio_backend.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    private final FuncionarioMapper mapper;

    public FuncionarioService(
            FuncionarioRepository repository,
            FuncionarioMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // POST
    public Funcionario criar(FuncionarioRequestDTO dto) {

        Funcionario funcionario = mapper.toModel(dto);

        return repository.save(funcionario);
    }

    // GET
    public List<Funcionario> listarTodos() {

        return repository.findAll();
    }

    // GET por ID
    public Funcionario buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new FuncionarioNotFoundException(id)
                );
    }

    // PUT
    public Funcionario atualizar(
            Long id,
            FuncionarioRequestDTO dto
    ) {

        Funcionario funcionario = buscarPorId(id);

        mapper.updateModel(funcionario, dto);

        return funcionario;
    }

    // PATCH
    public Funcionario atualizarParcialmente(
            Long id,
            FuncionarioPatchDTO dto
    ) {

        Funcionario funcionario = buscarPorId(id);

        mapper.updatePartialModel(funcionario, dto);

        return funcionario;
    }

    // DELETE
    public void excluir(Long id) {

        Funcionario funcionario = buscarPorId(id);

        repository.delete(funcionario);
    }
}