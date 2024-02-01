package com.felipe.msfuelsupply.vehicle;

import com.felipe.msfuelsupply.exceptions.FieldAlreadyInUseException;
import com.felipe.msfuelsupply.exceptions.ResourceNotFoundException;
import com.felipe.msfuelsupply.supply.Supply;
import com.felipe.msfuelsupply.supply.SupplyRepository;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleRequestDTO;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final SupplyRepository supplyRepository;

    public VehicleService(VehicleRepository vehicleRepository, SupplyRepository supplyRepository) {
        this.vehicleRepository = vehicleRepository;
        this.supplyRepository = supplyRepository;
    }

    @Transactional
    public VehicleResponseDTO create(VehicleRequestDTO dto) {
        if(vehicleRepository.existsByPlate(dto.plate()))
            throw new FieldAlreadyInUseException("plate", dto.plate());

        var newVehicle = new Vehicle(dto);
        var savedVehicle = vehicleRepository.save(newVehicle);

        return VehicleResponseDTO.createVehicleResponseDTO(savedVehicle);
    }

    public VehicleResponseDTO findById(UUID id) {
        var vehicleOp = vehicleRepository.findById(id);
        if(vehicleOp.isEmpty())
            throw new ResourceNotFoundException("Vehicle", "ID", id.toString());

        return VehicleResponseDTO.createVehicleResponseDTO(vehicleOp.get());
    }

    public List<VehicleResponseDTO> findAll() {
        var vehicleResponseDTOList = new ArrayList<VehicleResponseDTO>();
        var vehicleList = vehicleRepository.findAll();
        vehicleList.forEach(vehicle -> vehicleResponseDTOList.add(
                VehicleResponseDTO.createVehicleResponseDTO(vehicle))
        );
        return vehicleResponseDTOList;
    }

    @Transactional
    public VehicleResponseDTO updateVehicle(UUID id, VehicleRequestDTO dto) {
        var vehicleOp = vehicleRepository.findById(id);
        if(vehicleOp.isEmpty())
            throw new ResourceNotFoundException("Vehicle", "ID", id.toString());

        vehicleOp.get().setPlate(dto.plate());
        vehicleOp.get().setBrand(dto.brand());
        vehicleOp.get().setModel(dto.model());

        var updatedVehicle = vehicleRepository.save(vehicleOp.get());
        return VehicleResponseDTO.createVehicleResponseDTO(updatedVehicle);
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!(vehicleRepository.existsById(id)))
            throw new ResourceNotFoundException("Vehicle", "ID", id.toString());

        List<Supply> suppliesRelated = supplyRepository.findByVehicleId(id);
        suppliesRelated.forEach(supply -> supplyRepository.deleteById(supply.getId()));

        vehicleRepository.deleteById(id);
    }
}
