package com.example.picpay_desafio_backend.mapper;

import com.example.picpay_desafio_backend.dto.FuncionarioPatchDTO;
import com.example.picpay_desafio_backend.dto.FuncionarioRequestDTO;
import com.example.picpay_desafio_backend.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario toModel(FuncionarioRequestDTO dto) {

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.nome());
        funcionario.setEmail(dto.email());
        funcionario.setTelefone(dto.telefone());
        funcionario.setCargo(dto.cargo());
        funcionario.setDepartamento(dto.departamento());
        funcionario.setSalario(dto.salario());
        funcionario.setCidade(dto.cidade());
        funcionario.setStatus(dto.status());

        return funcionario;
    }

    public void updateModel(
            Funcionario funcionario,
            FuncionarioRequestDTO dto
    ) {

        funcionario.setNome(dto.nome());
        funcionario.setEmail(dto.email());
        funcionario.setTelefone(dto.telefone());
        funcionario.setCargo(dto.cargo());
        funcionario.setDepartamento(dto.departamento());
        funcionario.setSalario(dto.salario());
        funcionario.setCidade(dto.cidade());
        funcionario.setStatus(dto.status());
    }

    public void updatePartialModel(
            Funcionario funcionario,
            FuncionarioPatchDTO dto
    ) {

        if (dto.nome() != null) {
            funcionario.setNome(dto.nome());
        }

        if (dto.email() != null) {
            funcionario.setEmail(dto.email());
        }

        if (dto.telefone() != null) {
            funcionario.setTelefone(dto.telefone());
        }

        if (dto.cargo() != null) {
            funcionario.setCargo(dto.cargo());
        }

        if (dto.departamento() != null) {
            funcionario.setDepartamento(dto.departamento());
        }

        if (dto.salario() != null) {
            funcionario.setSalario(dto.salario());
        }

        if (dto.cidade() != null) {
            funcionario.setCidade(dto.cidade());
        }

        if (dto.status() != null) {
            funcionario.setStatus(dto.status());
        }
    }
}