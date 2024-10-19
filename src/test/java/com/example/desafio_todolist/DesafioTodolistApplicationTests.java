package com.example.desafio_todolist;

import com.example.desafio_todolist.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testCreateToDoSuccess() {
        var todo = new ToDo("ToDo1", "Test Success ToDo", true, 1);

        webClient.
                post().
                uri("/todos").
                bodyValue(todo).
                exchange().
                expectStatus().
                isOk().
                expectBody().
                jsonPath("$", null).isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].title").isEqualTo(todo.getTitle())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].done").isEqualTo(todo.isDone())
                .jsonPath("$[0].priority").isEqualTo(todo.getPriority());

    }

    @Test
    void testCreateToDoFailure() {
        webClient.
                post().
                uri("/todos").
                bodyValue(
                        new ToDo("","", false, 0)
                ).exchange()
                .expectStatus()
                .isBadRequest();
    }

}
