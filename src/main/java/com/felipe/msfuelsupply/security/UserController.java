package com.felipe.msfuelsupply.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.felipe.msfuelsupply.security.dtos.LoginRequestBody;
import com.felipe.msfuelsupply.security.dtos.SignUpRequestBody;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        return service.loginUser(dto);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> create(@RequestBody @Valid SignUpRequestBody dto) throws JsonProcessingException {
        var response = service.createUser(dto);

        if(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();

        return response;
    }
}
