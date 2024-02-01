package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.exceptions.ResourceNotFoundException;
import com.felipe.msfuelsupply.gasStation.GasStation;
import com.felipe.msfuelsupply.gasStation.GasStationRepository;
import com.felipe.msfuelsupply.gasStation.dtos.GasStationResponseDTO;
import com.felipe.msfuelsupply.supply.dtos.SupplyRequestDTO;
import com.felipe.msfuelsupply.supply.dtos.SupplyResponseDTO;
import com.felipe.msfuelsupply.vehicle.VehicleRepository;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplyService {

    private SupplyRepository supplyRepository;
    private VehicleRepository vehicleRepository;
    private GasStationRepository gasStationRepository;

    public SupplyService(SupplyRepository supplyRepository,
                         VehicleRepository vehicleRepository,
                         GasStationRepository gasStationRepository) {
        this.supplyRepository = supplyRepository;
        this.vehicleRepository = vehicleRepository;
        this.gasStationRepository = gasStationRepository;
    }

    @Transactional
    public SupplyResponseDTO create(SupplyRequestDTO dto) {
        var vehicleOp = vehicleRepository.findById(UUID.fromString(dto.vehicleId()));
        if(vehicleOp.isEmpty())
            throw new ResourceNotFoundException("Vehicle", "ID", dto.vehicleId());

        var gasStationOp = gasStationRepository.findById(UUID.fromString(dto.gasStationId()));
        if(gasStationOp.isEmpty())
            throw new ResourceNotFoundException("Gas Station", "ID", dto.gasStationId());

        var newSupply = new Supply(vehicleOp.get(), gasStationOp.get(), LocalDateTime.now(), dto.value(), dto.litres());
        var savedSupply = supplyRepository.save(newSupply);

        return SupplyResponseDTO.createSupplyResponseDTO(
                savedSupply,
                VehicleResponseDTO.createVehicleResponseDTO(savedSupply.getVehicle()),
                GasStationResponseDTO.createGasStationResponseDTO(savedSupply.getGasStation())
        );
    }

    public void findById() {

    }

    public void findAll() {

    }

    @Transactional
    public void update() {

    }

    @Transactional
    public void deleteById() {

    }
}
