# Microsserviço de Análise de Fraude

[![Java](https://img.shields.io/badge/Java-17+-blue?style=for-the-badge&logo=openjdk)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-green?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-orange?style=for-the-badge&logo=apachemaven)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-20.10+-blue?style=for-the-badge&logo=docker)](https://www.docker.com/)

---

## 📌 Visão Geral

O **fraude-api** é um microsserviço leve e minimalista que **simula uma API de análise de fraudes**.  
Ele foi projetado para atuar como **dependência externa** do microsserviço de apólices (`apolice-app`), fornecendo classificações de risco de clientes.

Esse projeto exemplifica **desacoplamento** e **separação de responsabilidades** dentro de uma arquitetura de microsserviços.

---

## ✅ Conformidade com os Requisitos do Desafio

1. **Integração Externa de Fraudes** → O microsserviço principal (`apolice-app`) depende da `fraude-api` para avaliar riscos.  
2. **Simulação de Análise de Risco** → Endpoint `POST /v1/analise` recebe dados de cliente e retorna `RISCO_ALTO` ou `RISCO_BAIXO`.  
3. **Contrato de API Claro** → API documentada via **Swagger/OpenAPI**, garantindo facilidade de integração.  
4. **Desacoplamento de Funções** → A lógica de fraude está isolada, permitindo evolução independente dos serviços.  

---

## 🏛️ Arquitetura

### 🔹 Estrutura de Pacotes

```
com.acme.fraude
├── api
│   ├── controller   # Controladores REST
│   ├── dto          # Objetos de transferência de dados
│   └── service      # Lógica de negócio e simulação de fraude
```

### 🔹 Características Arquiteturais

- **Responsabilidade Única (SRP)** → serviço dedicado apenas à fraude.  
- **API-First** → contrato exposto antes da implementação.  
- **Microsserviço Independente** → pode ser executado isoladamente ou integrado.  

---

## 📡 Endpoints da API

### **POST** `/v1/analise`  
- **Descrição:** Simula a análise de risco de um cliente.  
- **Request Body (exemplo):**
```json
{
  "cpf": "12345678900",
  "nome": "João Silva"
}
```
- **Response (exemplo):**
```json
{
  "risco": "RISCO_BAIXO"
}
```

A documentação completa está disponível via **Swagger**:  
👉 [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.1.5**
- **Maven**
- **Swagger/OpenAPI**
- **Docker**

---

## ▶️ Como Executar

### Usando Docker Compose (recomendado)
Este serviço já está integrado ao `docker-compose.yml` do repositório principal (`apolice-app`).  
Para rodar junto com todos os serviços:
```bash
docker-compose up --build
```

### Executar Localmente
1. Clone o repositório:
   ```bash
   git clone https://github.com/MiguelProgrammer/fraude-api.git
   cd fraude-api
   ```
2. Compile e rode com Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse o Swagger: [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

---

## 👤 Autor

- **Miguel Programmer** → [github.com/MiguelProgrammer](https://github.com/MiguelProgrammer)

---

> **Obs.:** Este serviço é apenas **simulador** de fraude, sem lógica real de análise.
