package com.example.picpay_desafio_backend.controller;

import com.example.picpay_desafio_backend.dto.FuncionarioPatchDTO;
import com.example.picpay_desafio_backend.dto.FuncionarioRequestDTO;
import com.example.picpay_desafio_backend.model.Funcionario;
import com.example.picpay_desafio_backend.service.FuncionarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(
            FuncionarioService service
    ) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<Funcionario> criar(
            @Valid @RequestBody FuncionarioRequestDTO dto
    ) {

        Funcionario funcionario = service.criar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(funcionario);
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FuncionarioRequestDTO dto
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, dto)
        );
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarParcialmente(
            @PathVariable Long id,
            @RequestBody FuncionarioPatchDTO dto
    ) {

        return ResponseEntity.ok(
                service.atualizarParcialmente(id, dto)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id
    ) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}