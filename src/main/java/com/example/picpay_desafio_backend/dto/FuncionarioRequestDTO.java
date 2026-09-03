package com.example.picpay_desafio_backend.dto;

import com.example.picpay_desafio_backend.enums.StatusFuncionario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record FuncionarioRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail deve ser válido")
        String email,

        String telefone,

        @NotBlank(message = "O cargo é obrigatório")
        String cargo,

        String departamento,

        BigDecimal salario,

        String cidade,

        StatusFuncionario status

) {
}