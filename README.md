# Balance API

## Build Docker

```bash
./mvnw clean package -DskipTests
docker build -t balance-api-java .
```

## Requesting

Check the [request file](./src/test/resources/requests.http) using VSCode's RestClient extension