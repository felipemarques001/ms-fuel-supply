package com.felipe.msfuelsupply.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.msfuelsupply.exceptions.JWTTokenNotFoundException;
import com.felipe.msfuelsupply.security.dtos.LoginRequestBody;
import com.felipe.msfuelsupply.security.dtos.SignUpRequestBody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final String ACCESS_KEY = "chaveDeSegredo";
    private final String URI_BASE = "http://localhost:9090/api/v1/usuarios";

    private final HttpServletRequest servletRequest;

    public UserService(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

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

        // Do the request and returns the user's JWT token.
        // This request can throw one HttpClientErrorException.Unauthorized exception,
        // the handling of this exception is at GlobalExceptionHandler
        return restTemplate.exchange(requestEntity, String.class);
    }

    public HttpStatusCode verifyPermission(String permission) {
        // Verifica se token JWT foi enviado na requisição
        var authHeader = servletRequest.getHeader("Authorization");
        if(authHeader == null)
            throw new JWTTokenNotFoundException();

        final String URI = URI_BASE + "/verificarPermissao/" + permission;
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.set("Authorization", authHeader);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI)
                .headers(headers)
                .build();

        return restTemplate
                .exchange(requestEntity, String.class)
                .getStatusCode();
    }

    public ResponseEntity<String> createUser(SignUpRequestBody request) throws JsonProcessingException {
        // Verify if the user who call this method has permission to create a new user
        HttpStatusCode authorizationStatusCode = verifyPermission("cadastrar usuario");
        if (authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        request.setChaveAcesso(ACCESS_KEY);

        // Build the request
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        var objectMapper = new ObjectMapper();

        var requestBody = objectMapper.writeValueAsString(request);

        RequestEntity<String> requestEntity = RequestEntity
                .post(URI_BASE)
                .headers(headers)
                .body(requestBody);

        // Do the request
        // This request can throw one HttpClientErrorException.BadRequest exception,
        // the handling of this exception is at GlobalExceptionHandler
        return restTemplate.exchange(requestEntity, String.class);
    }
}
