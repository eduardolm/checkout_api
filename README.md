# Checkout API
## Objetivos
Desenvolver uma solução de e-commerce com a arquitetura de microsserviços e aplicar a integração entre eles orientada a eventos com Apache Kafka e garantir a compatibilidade entre da comunicação dos microsserviços com Schema Registry. Para isso, programaremos em Java utilizando a stack do Spring (Spring Boot, Spring Cloud Streams).
## Tecnologias utilizadas
 + Java 11
 + Spring Boot 2.4.5
 + Kafka
 + Avro
 + PostgreSQL
 + Github
## Como testar
Para testar essa API é preciso executar o `docker/docker-compose-sample.yml`, após passar as variáveis entre <>
Com os serviços sendo executados, executar esta API numa IDE e fazer os requests com Postman ou similar.
## Endpoints & Payloads
### Endpoints
#### Cadastrar checkout
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Cadastrar checkout | _api/v1/checkout_ | POST

### Payload
#### Cadastrar Checkout
##### POST - Cadastro de checkout (request)
    {
        "firstName": "John",
        "lastName": "Doe",
        "email": "teste@email.com",
        "address": "Rua do Super Herói, 410",
        "complement": "Casa",
        "country": "Brazil",
        "state": "São Paulo",
        "zip": "999999-999",
        "saveAddress": true,
        "saveInfo": true,
        "paymentMethod": "Credit Card",
        "cardName": "John Doe",
        "cardNumber": "1234567898713654",
        "cardDate": "2028-12-23",
        "cardCvv": "654",
        "products": [
            "Notebook MacBook Pro",
            "Mouse Gamer",
            "Teclado sem fio gamer"
        ]
    }

##### POST - response
    {
        "code": "dd1294dc-3def-42c6-8baf-7288d1ebd9c9"
    }
