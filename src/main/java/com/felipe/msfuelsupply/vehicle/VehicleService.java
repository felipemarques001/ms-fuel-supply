package com.felipe.msfuelsupply.vehicle;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public Vehicle create(VehicleRequestDto dto) {
        if(vehicleRepository.existsByPlate(dto.plate()))
            throw new RuntimeException("Veículo já cadastrado!");
        var newVehicle = new Vehicle(dto);
        return vehicleRepository.save(newVehicle);
    }

    public void findById() {

    }

    public void findByBrand() {

    }

    public void findByModel() {

    }

    public void findAll() {

    }

    @Transactional
    public void deleteByPlate() {

    }
}
