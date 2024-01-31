package com.felipe.msfuelsupply.gasStation.dtos;

import com.felipe.msfuelsupply.gasStation.GasStation;
import jakarta.validation.constraints.NotBlank;

public record GasStationRequestDTO(

        @NotBlank(message = "The value of name cannot be empty")
        String name,

        @NotBlank(message = "The value of district cannot be empty")
        String district,

        @NotBlank(message = "The value of street cannot be empty")
        String street,

        @NotBlank(message = "The value of number cannot be empty")
        String numberToContact
) {
}
