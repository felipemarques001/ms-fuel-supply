package com.felipe.msfuelsupply.vehicle;

import com.felipe.msfuelsupply.vehicle.dtos.UpdateVehicleDTO;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public VehicleDto updateVehicle(UpdateVehicleDTO dto, String plate) {
        var vehicleOp = vehicleRepository.findByPlate(plate);
        if(vehicleOp.isEmpty())
            throw new RuntimeException("Vehicle not found with this plate!");
        vehicleOp.get().setBrand(dto.brand());
        vehicleOp.get().setModel(dto.model());
        var updatedVehicle = vehicleRepository.save(vehicleOp.get());
        return VehicleDto.createVehicleDto(updatedVehicle);
    }

    @Transactional
    public void deleteByPlate(String plate) {
        if(!(vehicleRepository.existsByPlate(plate)))
            throw new RuntimeException("Vehicle not found with this plate!");
        vehicleRepository.deleteByPlate(plate);
    }
}
