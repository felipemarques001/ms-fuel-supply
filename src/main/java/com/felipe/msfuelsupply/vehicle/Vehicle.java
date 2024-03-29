package com.felipe.msfuelsupply.vehicle;

import com.felipe.msfuelsupply.vehicle.dtos.VehicleRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false, unique = true, length = 7)
    private String plate;

    public Vehicle(VehicleRequestDTO dto) {
        model = dto.model();
        brand = dto.brand();
        plate = dto.plate();
    }
}
