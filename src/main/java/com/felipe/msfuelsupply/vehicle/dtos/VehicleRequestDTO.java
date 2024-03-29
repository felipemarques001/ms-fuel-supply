package com.felipe.msfuelsupply.vehicle.dtos;

import com.felipe.msfuelsupply.vehicle.Vehicle;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record VehicleRequestDTO(

        @NotBlank(message = "The value of model cannot be empty")
        String model,

        @NotBlank(message = "The value of brand cannot be empty")
        String brand,

        @NotBlank(message = "The value of plate cannot be empty")
        @Length(min = 7, max = 7, message = "The plate input need has 7 characters")
        String plate
) {
}
