package com.felipe.msfuelsupply.user.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestBody {

        @NotBlank(message = "The value of username cannot be empty")
        private String username;

        @NotBlank(message = "The value of password cannot be empty")
        private String password;

        private String accessKey;
}
