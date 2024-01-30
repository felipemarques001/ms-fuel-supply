package com.felipe.msfuelsupply.vehicle.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateVehicleDTO(
        @NotBlank(message = "The value of model cannot be empty")
        String model,

        @NotBlank(message = "The value of brand cannot be empty")
        String brand
) {
}
