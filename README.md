# Desafio-CRUD-springBoot-Angular

# Configuração de ambiente sprng boot

* postgres.url = localhost
* postgres.url.port = 5435
* postgres.dbname = contact-crud
* postgres.user = postgres
* postgres.password = fg@2020

## Como compilar o projeto spring boot
```shell
$ ./gradlew bootRun build -x test 
```

# Configuração do projeto Angular

## url do backend 
```url
http://localhost:8080/api/
```

## Como compilar o projeto angular
```shell
$ yarn install
$ yarn build 
```

# Subindo o projeto com docker-compose 

É só execulta o comando a baixo:

```shell
$ docker-compose -f docker/docker-compose.yml up -d
```