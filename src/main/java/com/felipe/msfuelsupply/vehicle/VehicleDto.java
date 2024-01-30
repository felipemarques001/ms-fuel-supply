package com.felipe.msfuelsupply.vehicle;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record VehicleDto(

        @NotBlank(message = "The value of model cannot be empty")
        String model,

        @NotBlank(message = "The value of brand cannot be empty")
        String brand,

        @NotBlank(message = "The value of plate cannot be empty")
        @Length(min = 7, max = 7, message = "The plate input need has 7 characters")
        String plate


) {

        public static VehicleDto createVehicleDto(Vehicle vehicle) {
                return new VehicleDto(vehicle.getModel(), vehicle.getBrand(), vehicle.getPlate());
        }
}
