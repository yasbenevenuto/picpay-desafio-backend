package com.example.picpay_desafio_backend.exception;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(Long id) {

        super(
                "Funcionário com ID " + id +
                " não foi encontrado."
        );
    }
}