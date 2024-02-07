package com.felipe.msfuelsupply.security.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestBody {

    @NotBlank(message = "The value of 'nome' cannot be empty")
    private String nome;

    @NotBlank(message = "The value of 'username' cannot be empty")
    private String username;

    @NotBlank(message = "The value of 'password' cannot be empty")
    private String password;

    @NotEmpty(message = "Please provide at least one group ID")
    private List<String> idsGrupo;

    private String chaveAcesso;
}
