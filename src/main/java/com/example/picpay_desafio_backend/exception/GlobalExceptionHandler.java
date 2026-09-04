package com.example.picpay_desafio_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Funcionario nao encontrado pelo ID -> 404.
     */
    @ExceptionHandler(FuncionarioNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleFuncionarioNotFound(
            FuncionarioNotFoundException exception
    ) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        Map.of(
                                "erro",
                                exception.getMessage()
                        )
                );
    }

    /**
     * Campos obrigatorios invalidos no POST ou no PUT -> 400.
     *
     * Sem este metodo o Spring devolve um corpo generico e o front-end nao
     * consegue mostrar qual campo esta errado.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleCamposInvalidos(
            MethodArgumentNotValidException exception
    ) {

        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(erro ->
                        erros.put(
                                erro.getField(),
                                erro.getDefaultMessage()
                        )
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erros);
    }
}
