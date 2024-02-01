package com.felipe.msfuelsupply.vehicle.dtos;

import com.felipe.msfuelsupply.vehicle.Vehicle;
import jakarta.persistence.Column;

import java.util.UUID;

public record VehicleResponseDTO(
        UUID id,
        String model,
        String brand,
        String plate
) {
    public static VehicleResponseDTO createVehicleResponseDTO(Vehicle vehicle) {
        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getModel(),
                vehicle.getBrand(),
                vehicle.getPlate()
        );
    }
}
