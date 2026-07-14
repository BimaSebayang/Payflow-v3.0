# PayFlow

PayFlow is a simple event-driven payment gateway built using Java 17 and Spring Boot Microservices.

## Architecture

```
                Client
                   │
                   ▼
          Payment Gateway Service
                   │
         ┌─────────┴─────────┐
         ▼                   ▼
 Payment Main         Payment History
         │
         ▼
      Rabbit Topic
```

## Modules

| Module | Description |
|---------|-------------|
| paymentgateway | API Gateway / Entry Point |
| paymentmain | Main payment processing |
| paymenthistory | Store payment history |
| paymentscheduler | Scheduled jobs |

## Technology

- Java 17
- Spring Boot 3.3.x
- PostgreSQL
- Kafka
- Redis
- Docker
- Maven
- Spring Data JPA
- Spring Validation
- Swagger

## Features

- Payment Processing
- Payment History
- Event Driven Architecture
- Kafka Messaging
- Redis Cache / Data Grid
- Scheduler
- REST API

## Running

```bash
docker compose up
```

or

```bash
mvn clean install

mvn spring-boot:run
```

---

Developed for learning purposes.
