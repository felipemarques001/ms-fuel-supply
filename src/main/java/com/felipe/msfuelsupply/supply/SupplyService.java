package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.exceptions.ResourceNotFoundException;
import com.felipe.msfuelsupply.gasStation.GasStationRepository;
import com.felipe.msfuelsupply.gasStation.dtos.GasStationResponseDTO;
import com.felipe.msfuelsupply.supply.dtos.SupplyRequestDTO;
import com.felipe.msfuelsupply.supply.dtos.SupplyResponseDTO;
import com.felipe.msfuelsupply.vehicle.VehicleRepository;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final VehicleRepository vehicleRepository;
    private final GasStationRepository gasStationRepository;

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

    public SupplyResponseDTO findById(UUID id) {
        var supplyOp = supplyRepository.findById(id);
        if(supplyOp.isEmpty())
            throw new ResourceNotFoundException("Supply", "ID", id.toString());

        return SupplyResponseDTO.createSupplyResponseDTO(
                supplyOp.get(),
                VehicleResponseDTO.createVehicleResponseDTO(supplyOp.get().getVehicle()),
                GasStationResponseDTO.createGasStationResponseDTO(supplyOp.get().getGasStation())
        );
    }

    public List<SupplyResponseDTO> findAll() {
        var supplyResponseDTOList = new ArrayList<SupplyResponseDTO>();
        var supplySavedList = supplyRepository.findAll();
        supplySavedList.forEach(
                supply -> supplyResponseDTOList.add(
                             SupplyResponseDTO.createSupplyResponseDTO(
                                    supply,
                                    VehicleResponseDTO.createVehicleResponseDTO(supply.getVehicle()),
                                    GasStationResponseDTO.createGasStationResponseDTO(supply.getGasStation())
                             )
                )
        );

        return supplyResponseDTOList;
    }

    @Transactional
    public SupplyResponseDTO update(UUID id, SupplyRequestDTO dto) {
        var supplyOp = supplyRepository.findById(id);
        if(supplyOp.isEmpty())
            throw new ResourceNotFoundException("Supply", "ID", id.toString());

        var vehicleOp = vehicleRepository.findById(UUID.fromString(dto.vehicleId()));
        if(vehicleOp.isEmpty())
            throw new ResourceNotFoundException("Vehicle", "ID", dto.vehicleId());

        var gasStationOp = gasStationRepository.findById(UUID.fromString(dto.gasStationId()));
        if(gasStationOp.isEmpty())
            throw new ResourceNotFoundException("Gas Station", "ID", dto.gasStationId());

        supplyOp.get().setVehicle(vehicleOp.get());
        supplyOp.get().setGasStation(gasStationOp.get());
        supplyOp.get().setValue(dto.value());
        supplyOp.get().setLitres(dto.litres());

        var updatedSupply = supplyRepository.save(supplyOp.get());

        return SupplyResponseDTO.createSupplyResponseDTO(
                updatedSupply,
                VehicleResponseDTO.createVehicleResponseDTO(updatedSupply.getVehicle()),
                GasStationResponseDTO.createGasStationResponseDTO(updatedSupply.getGasStation())
        );
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!(supplyRepository.existsById(id)))
            throw new ResourceNotFoundException("Supply", "ID", id.toString());

        supplyRepository.deleteById(id);
    }
}
