package com.example.picpay_desafio_backend.dto;

import com.example.picpay_desafio_backend.enums.StatusFuncionario;
import java.math.BigDecimal;

public record FuncionarioPatchDTO(

        String nome,
        String email,
        String telefone,
        String cargo,
        String departamento,
        BigDecimal salario,
        String cidade,
        StatusFuncionario status
) {
}