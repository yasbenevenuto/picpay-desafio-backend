package com.example.picpay_desafio_backend.model;

import com.example.picpay_desafio_backend.enums.StatusFuncionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String departamento;
    private BigDecimal salario;
    private String cidade;
    private StatusFuncionario status;
}