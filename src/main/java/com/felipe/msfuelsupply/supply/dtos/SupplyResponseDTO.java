package com.felipe.msfuelsupply.supply.dtos;

import com.felipe.msfuelsupply.gasStation.GasStation;
import com.felipe.msfuelsupply.gasStation.dtos.GasStationResponseDTO;
import com.felipe.msfuelsupply.supply.Supply;
import com.felipe.msfuelsupply.vehicle.Vehicle;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SupplyResponseDTO (
        UUID id,
        LocalDateTime dataCreated,
        BigDecimal value,
        BigDecimal litres,
        VehicleResponseDTO vehicle,
        GasStationResponseDTO gasStation
){
    public static SupplyResponseDTO createSupplyResponseDTO(Supply supply,
                                                            VehicleResponseDTO vehicleDTO,
                                                            GasStationResponseDTO gasStationDTO) {
        return new SupplyResponseDTO(
              supply.getId(),
              supply.getDataCreated(),
              supply.getValue(),
              supply.getLitres(),
              vehicleDTO,
              gasStationDTO
        );
    }
}
