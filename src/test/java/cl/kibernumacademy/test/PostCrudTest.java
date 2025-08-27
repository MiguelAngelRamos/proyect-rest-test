package cl.kibernumacademy.test;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import cl.kibernumacademy.client.PostsClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

// Indicar el orden de ejecución segun @Order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostCrudTest {
  
  private static PostsClient client;
  private static int createdId;
  private static final int USER_ID = 777;

  @BeforeAll
  static void setup() {
    client = new PostsClient();
  }

  @Test
  @DisplayName("GET /posts - lista todos los posts")
  void listPosts_ok() {
    Response response = client.listPosts();
    JsonPath json = response.jsonPath(); // Convertir el body a jsonpath para poder navegarlo facilmente
    List<Map<String, Object>> posts  = json.getList("$");
    Assertions.assertThat(posts).as("La lista de posts no debe ser vacia").isNotEmpty();
    Assertions.assertThat(response.getHeader("Content-Type")).contains("application/json");
  }
}
