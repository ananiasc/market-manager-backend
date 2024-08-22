![Java](https://img.shields.io/badge/Java-1.8-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green)

# Português

# Market Manager Backend (E-Commerce)

Este repositório contém o código backend para uma aplicação de e-commerce. O backend é responsável por lidar com a lógica de negócios, interações com o banco de dados e APIs para a plataforma de e-commerce.

À medida que atualizo esta aplicação, adicionarei seus recursos e quaisquer outras alterações relacionadas à configuração da aplicação neste README.

## Índice

- [Recursos](#recursos)
- [Tecnologias](#tecnologias)
- [Arquitetura](#arquitetura)
- [Primeiros Passos](#primeiros-passos)
- [Configuração](#configuração)
- [Documentação da API](#documentacao-da-api)
- [Licença](#licenca)

## Recursos

- Autenticação e autorização de usuários
- Gerenciamento de catálogo de produtos
- Funcionalidade de carrinho de compras
- Processamento de pedidos
- Integração com gateway de pagamento
- Painel de administração para gerenciamento da loja
- Relatórios e análises

## Tecnologias

- **Java 8**: A linguagem de programação principal utilizada.
- **Spring Framework**: Para construir a aplicação.
- **Spring Data JPA**: Para interações com o banco de dados.
- **Hibernate**: Framework ORM.
- **PostgreSQL**: Banco de dados relacional.
- **Maven**: Para gerenciamento de dependências e construção do projeto.

## Arquitetura

A aplicação segue uma arquitetura em camadas:
1. **Camada de Controle**: Lida com as requisições e respostas HTTP.
2. **Camada de Serviço**: Contém a lógica de negócios.
3. **Camada de Repositório**: Interage com o banco de dados.

## Primeiros Passos

### Pré-requisitos

- Java 8
- Maven

### Instalação

1. Clone o repositório:
    ```bash
    git clone https://github.com/ananiasc/MarketBackend.git
    cd ecommerce-backend
    ```

2. Instale as dependências:
    ```bash
    mvn clean install
    ```

3. Configure o banco de dados:
    - Certifique-se de que o PostgreSQL esteja em execução.
    - Crie um banco de dados chamado `marketdb`.
    - Atualize o arquivo `application.properties` com suas credenciais de banco de dados.

## Configuração

A configuração da aplicação é gerenciada através do arquivo `application.properties` localizado no diretório `src/main/resources`.

```properties
# Database configuration
spring.application.name=market-manager-backend
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

api.security.token.secret=${JWT_SECRET}
```

## Documentação da API

A documentação da API está disponível em `/swagger-ui.html` após a execução da aplicação. Ela fornece informações detalhadas sobre os endpoints disponíveis e seu uso.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

---

# English

This repository contains the backend code for an e-commerce application. The backend is responsible for handling business logic, database interactions, and APIs for the e-commerce platform.

As I update this application, I will add its features and any other changes regarding the application configuration in this README.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [License](#license)

## Features

- User authentication and authorization
- Product catalog management
- Shopping cart functionality
- Order processing
- Payment gateway integration
- Admin dashboard for managing the store
- Reporting and analytics

## Technologies

- **Java 8**: The primary programming language used.
- **Spring Framework**: For building the application.
- **Spring Data JPA**: For database interactions.
- **Hibernate**: ORM framework.
- **PostgreSQL**: Relational database.
- **Maven**: For dependency management and building the project.

## Architecture

The application follows a layered architecture:
1. **Controller Layer**: Handles HTTP requests and responses.
2. **Service Layer**: Contains business logic.
3. **Repository Layer**: Interacts with the database.

## Getting Started

### Prerequisites

- Java 8
- Maven

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ananiasc/MarketBackend.git
    cd ecommerce-backend
    ```

2. Install dependencies:
    ```bash
    mvn clean install
    ```

3. Set up the database:
    - Ensure PostgreSQL is running.
    - Create a database named `marketdb`.
    - Update the `application.properties` file with your database credentials.

## Configuration

The application configuration is managed through the `application.properties` file located in the `src/main/resources` directory.

```properties
# Database configuration
spring.application.name=market-manager-backend
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

api.security.token.secret=${JWT_SECRET}
```
## API Documentation

The API documentation is available at `/swagger-ui.html` after running the application. It provides detailed information about the available endpoints and their usage.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
