package com.jishnuc.todo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TodoClient {

    private final String BASE_URL="https://jsonplaceholder.typicode.com/todos";

    private final HttpClient httpClient;
    public TodoClient(){
        httpClient=HttpClient.newHttpClient();
    }

    public String getAllTodos() throws IOException, InterruptedException {
        HttpRequest request=HttpRequest
                            .newBuilder()
                            .GET()
                            .uri(URI.create(BASE_URL))
                            .build();
        var response=httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
