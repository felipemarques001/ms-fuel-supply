package com.felipe.msfuelsupply.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.felipe.msfuelsupply.security.dtos.LoginRequestBody;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestBody dto) throws JsonProcessingException {
        ResponseEntity<String> response = service.loginUser(dto);

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}
