<h1 align="center">
  To-Do List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Project&message=Java&color=8257E5&labelColor=000000" alt="Java" />
</p>

API for managing tasks (CRUD) [Based on the challenge](https://github.com/simplify-liferay/desafio-junior-backend-simplify) Back-end - Simplify.

API developed from a project created on [YOUTUBE](https://youtu.be/IjProDV001o).

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MySQL](https://dev.mysql.com/downloads/)

## Adopted Practices

- SOLID, DRY, YAGNI, KISS
- REST API
- Data Persistence and Queries with Spring Data JPA
- Dependency Injection
- Error response handling
- Automatic Swagger generation with OpenAPI 3

## How to Run

- Clone the git repository
- Build the project:
```
$ ./mvnw clean package
```
- Configure the `src/main/resources/aplication.properties.example` file:
  - Rename it to `aplication.properties`
  - Set your MySQL `username` and `password`:

```
spring.application.name=desafio-todolist
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DB
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
```

- Run the Application:

```
$ java -jar target/desafio-todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8080).

## API Endpoints

To make the HTTP requests below, the [Postman](https://www.postman.com/) tool was used:

- Create Task
```
$ [POST] http://localhost:8080/todos

  {
    "title": "Task Title",
    "description": "Task Description",
    "done": false,
    "priority": 1
  }
```

- Method Return
  <img src="files/endpoint_post.jpg">


- List Tasks

```
$ [GET] http://localhost:8080/todos
```


- Update task

```
$ [PUT] http://localhost:8080/todos
   {
    "id": 6,
    "title": "Task Title Updated",
    "description": "Task Description Updated",
    "done": true,
    "priority": 10
   }
```
- Method Return
<img src="/files/endpoint_put.jpg">


- Remove Task

```
[DELETE] http://localhost:8080/todos/{id}
```

## Swagger UI
```
http://localhost:8080/swagger-ui/index.html
```
<img src="/files/swagger-ui.jpg">
