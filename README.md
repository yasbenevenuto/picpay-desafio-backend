# PicPay Recrutamento — API

API REST para o sistema interno de contratação de funcionários do PicPay.
Cadastra, consulta, atualiza e exclui candidatos de um processo seletivo.

Atividade avaliativa de Spring Boot — Desenvolvimento de Sistemas, 2º ano.

**Integrantes:** Yasmin Benevenuto Holando e Matheus Lima Botana Gama

O front-end que consome esta API está em
[picpay-desafio-frontend](https://github.com/yasbenevenuto/picpay-desafio-frontend).

---

## Tecnologias

- Java 17
- Spring Boot 4.1.1
- Spring MVC
- Bean Validation
- Lombok
- Maven

## Como rodar

```bash
./mvnw spring-boot:run
```

No Windows, dentro da pasta do projeto:

```powershell
.\mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`. Para conferir, abra
`http://localhost:8080/funcionarios` no navegador — deve aparecer o JSON com
os candidatos de exemplo.

## Armazenamento

Não há banco de dados. Os candidatos ficam em um `ArrayList` na memória,
conforme pedido na atividade. Os dados existem enquanto a aplicação estiver
rodando e se perdem quando ela para.

Ao subir, a classe `DadosIniciais` cadastra nove candidatos fictícios para
facilitar os testes.

## Endpoints

Base: `/funcionarios`

| Método | Rota | Descrição | Resposta |
|---|---|---|---|
| POST | `/funcionarios` | Cadastra um candidato | 201 + candidato criado |
| GET | `/funcionarios` | Lista todos | 200 + array |
| GET | `/funcionarios/{id}` | Consulta por ID | 200 + candidato / 404 |
| PUT | `/funcionarios/{id}` | Atualiza todos os campos | 200 + candidato / 404 |
| PATCH | `/funcionarios/{id}` | Atualiza apenas os campos enviados | 200 + candidato / 404 |
| DELETE | `/funcionarios/{id}` | Exclui o candidato | 204 / 404 |

### Modelo

```json
{
  "id": 1,
  "nome": "Ana Souza",
  "email": "ana.souza@email.com",
  "telefone": "(11) 98888-1010",
  "cargo": "Desenvolvedora Back-end",
  "departamento": "Tecnologia",
  "salario": 8500.00,
  "cidade": "São Paulo",
  "status": "EM_ANALISE"
}
```

O campo `status` aceita `EM_ANALISE`, `APROVADO`, `REPROVADO` e `CONTRATADO`.

O `id` é gerado pela API e não deve ser enviado no corpo do POST nem do PUT.

### PUT e PATCH

Os dois usam DTOs diferentes, e essa é a diferença central da atividade.

**PUT** recebe `FuncionarioRequestDTO`, que valida nome, e-mail e cargo como
obrigatórios. O `FuncionarioMapper.updateModel` chama todos os setters sem
verificar nada, então o PUT substitui o candidato inteiro — um campo enviado
em branco é gravado em branco.

**PATCH** recebe `FuncionarioPatchDTO`, com todos os campos opcionais e sem
validação. O `FuncionarioMapper.updatePartialModel` testa `!= null` campo a
campo, então o que não for enviado permanece como estava.

Enviar `{"status": "APROVADO"}` em um PATCH altera apenas o status. O mesmo
corpo em um PUT apagaria os outros sete campos.

### Erros

Candidato inexistente retorna 404:

```json
{ "erro": "Funcionário não encontrado com o ID: 99" }
```

Campos obrigatórios inválidos retornam 400, com uma entrada por campo:

```json
{ "email": "O e-mail deve ser válido" }
```

## CORS

A classe `CorsConfig` libera requisições vindas de `http://localhost:4200`,
o endereço do front-end em desenvolvimento. Sem isso o navegador bloqueia
todas as chamadas.

Para liberar outra origem, altere `allowedOrigins` nessa classe.

## Estrutura

```
src/main/java/com/example/picpay_desafio_backend/
├── config/
│   ├── CorsConfig.java              libera o acesso do front-end
│   └── DadosIniciais.java           candidatos de exemplo no boot
├── controller/
│   └── FuncionarioController.java   os seis endpoints
├── dto/
│   ├── FuncionarioRequestDTO.java   corpo do POST e do PUT
│   └── FuncionarioPatchDTO.java     corpo do PATCH
├── enums/
│   └── StatusFuncionario.java       os quatro status
├── exception/
│   ├── FuncionarioNotFoundException.java
│   └── GlobalExceptionHandler.java  traduz exceções em 404 e 400
├── mapper/
│   └── FuncionarioMapper.java       converte DTO em modelo
├── model/
│   └── Funcionario.java             a classe do candidato
├── repository/
│   └── FuncionarioRepository.java   o ArrayList
└── service/
    └── FuncionarioService.java      as regras de negócio
```
