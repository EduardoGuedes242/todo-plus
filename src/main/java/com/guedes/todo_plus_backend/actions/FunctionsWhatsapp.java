package com.guedes.todo_plus_backend.actions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class FunctionsWhatsapp {

  public void sendMessage(String numberPhone, String message) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    headers.set("apiKey", "B6D711FCDE4D4FD5936544120E713976");
    headers.set("Content-Type", "application/json");
    String url = "http://149.18.51.246:30780/message/sendText/inforvix-sistemas-0343";
    String body = String.format("""
            {
                "number": "%s",
                "options": {
                    "delay": 1200,
                    "presence": "composing",
                    "linkPreview": false
                },
                "textMessage": {
                    "text": "%s"
                }
            }
            """, numberPhone, message);

    HttpEntity entity = new HttpEntity<>(body, headers);
    restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
  }
}
