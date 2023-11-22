# Build
- Spring Boot deployment | https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html
- Criar imagem docker de aplicação Java | https://www.youtube.com/watch?v=c-Bq6JUfRnk
  
Esse artigo é bem interessante, mas no Mac retornou [um erro](https://stackoverflow.com/questions/65456814/docker-apple-silicon-m1-preview-mysql-no-matching-manifest-for-linux-arm64-v8)
https://spring.io/guides/topicals/spring-boot-docker/
Nesse artigo tem algumas informaçoes sobre M1: https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1

A imagem do openjdk funciona sem problemas, mas é preciso entender a sintaxe de
tag das imagens: https://hub.docker.com/_/openjdk/tags?page=1&name=17

Minha imagem ficou com aproximadamente 500MB, mas a julgar pelo nome das imagens 
existentes, da pra ser menor.

Por motivos de segurança os builds de openjdk deixaram de ser feitos como era antes.
https://stackoverflow.com/a/75997220

Utilizando `eclipse-temurin:17-jdk-jammy` a imagem ficou por volta de 400MB.

# API
- Path Variable in Spring | https://www.baeldung.com/spring-pathvariable
- Request Param | https://www.baeldung.com/spring-request-param

# Test
- https://devwithus.com/java-spring-mock-repository/
- Disable Test in Junit 5 | https://mkyong.com/junit5/junit-5-how-to-disable-tests/