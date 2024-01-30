package com.felipe.msfuelsupply.vehicle;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleDto create(VehicleDto dto) {
        if(vehicleRepository.existsByPlate(dto.plate()))
            throw new RuntimeException("Veículo já cadastrado!");
        var newVehicle = new Vehicle(dto);
        var savedVehicle = vehicleRepository.save(newVehicle);
        return VehicleDto.createVehicleDto(savedVehicle);
    }

    public VehicleDto findByPlate(String plate) {
        var vehicleOp = vehicleRepository.findByPlate(plate);
        if(vehicleOp.isEmpty())
            throw new RuntimeException("Vehicle not found with this plate!");
        return VehicleDto.createVehicleDto(vehicleOp.get());
    }

    public List<VehicleDto> findAll() {
        var vehicleDtoList = new ArrayList<VehicleDto>();
        var vehicleList = vehicleRepository.findAll();
        vehicleList.forEach(vehicle ->
                vehicleDtoList.add(VehicleDto.createVehicleDto(vehicle))
        );
        return vehicleDtoList;
    }

    @Transactional
    public void deleteByPlate() {

    }
}
