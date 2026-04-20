# Cadastro de cliente com Hexagonal Architecture

# Versões utilizadas

- JDK 21, variáveis PATH e JAVA_HOME
- MAVEN 4.0.0
- Spring Boot 3.3.5

## Baixar dependências
```
mvn clean install
```

## Rodando a aplicação mock para retornar informações de endereço ao informar o CEP

### Baixar o WireMock

Site oficial = https://wiremock.org/docs/download-and-installation/

### Execução
```
java -jar .\wiremock-standalone-4.0.0-beta.29.jar --port 8082
```

### Pós execução

Serão criadas algumas pastas no local da execução. Em ./mappings criar o arquivo address.json
```
{
    "request": {
        "method": "GET",
        "url": "/addresses/38400000"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua Hexagonal",
            "city": "Teresópolis",
            "state": "Rio de Janeiro"
        }
    }
}
```
### Re-run no WireMock
```
java -jar .\wiremock-standalone-4.0.0-beta.29.jar --port 8082
```
