package com.felipe.msfuelsupply.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.msfuelsupply.security.dtos.LoginRequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final String ACCESS_KEY = "chaveDeSegredo";
    private final String URI_BASE = "http://localhost:9090/api/v1/usuarios";

    public ResponseEntity<String> loginUser(LoginRequestBody request) throws JsonProcessingException {
        request.setChaveAcesso(ACCESS_KEY);
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        var objectMapper = new ObjectMapper();

        var requestBody = objectMapper.writeValueAsString(request);

        RequestEntity<String> requestEntity = RequestEntity
                .post(URI_BASE + "/login")
                .headers(headers)
                .body(requestBody);

        // O return dessa requisição deve ser o token do usuário, se o usuário enviar algum dado inválido
        // uma HttpClientErrorException será lançada
        return restTemplate.exchange(requestEntity, String.class);
    }
}
