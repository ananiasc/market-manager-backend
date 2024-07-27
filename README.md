![Java](https://img.shields.io/badge/Java-1.8-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green)

# Market Backend (E-Commerce)

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
spring.datasource.url=jdbc:postgresql://localhost:5432/marketdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## API Documentation

The API documentation is available at `/swagger-ui.html` after running the application. It provides detailed information about the available endpoints and their usage.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
