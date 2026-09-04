package com.example.picpay_desafio_backend.config;

import com.example.picpay_desafio_backend.dto.FuncionarioRequestDTO;
import com.example.picpay_desafio_backend.enums.StatusFuncionario;
import com.example.picpay_desafio_backend.service.FuncionarioService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * Cadastra candidatos ficticios quando a aplicacao sobe.
 *
 * Como os dados ficam em um ArrayList na memoria, tudo se perde quando a
 * aplicacao para. Isso deixa a lista pronta para testar o front-end.
 */
@Configuration
public class DadosIniciais {

    @Bean
    public CommandLineRunner carregarCandidatos(FuncionarioService service) {

        return args -> {

            service.criar(new FuncionarioRequestDTO(
                    "Ana Souza",
                    "ana.souza@email.com",
                    "(11) 98888-1010",
                    "Desenvolvedora Back-end",
                    "Tecnologia",
                    new BigDecimal("8500.00"),
                    "Sao Paulo",
                    StatusFuncionario.EM_ANALISE
            ));

            service.criar(new FuncionarioRequestDTO(
                    "Bruno Lima",
                    "bruno.lima@email.com",
                    "(21) 97777-2020",
                    "Designer de Produto",
                    "Design",
                    new BigDecimal("7200.00"),
                    "Rio de Janeiro",
                    StatusFuncionario.APROVADO
            ));

            service.criar(new FuncionarioRequestDTO(
                    "Carla Nunes",
                    "carla.nunes@email.com",
                    "(31) 96666-3030",
                    "Analista de Dados",
                    "Dados",
                    new BigDecimal("6900.00"),
                    "Belo Horizonte",
                    StatusFuncionario.CONTRATADO
            ));

            service.criar(new FuncionarioRequestDTO(
                    "Diego Martins",
                    "diego.martins@email.com",
                    "(41) 95555-4040",
                    "Desenvolvedor Front-end",
                    "Tecnologia",
                    new BigDecimal("7800.00"),
                    "Curitiba",
                    StatusFuncionario.EM_ANALISE
            ));

            service.criar(new FuncionarioRequestDTO(
                    "Elisa Rocha",
                    "elisa.rocha@email.com",
                    "(51) 94444-5050",
                    "Analista de Recursos Humanos",
                    "Recursos Humanos",
                    new BigDecimal("5600.00"),
                    "Porto Alegre",
                    StatusFuncionario.REPROVADO
            ));
        };
    }
}
