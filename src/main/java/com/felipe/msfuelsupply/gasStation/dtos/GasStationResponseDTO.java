package com.felipe.msfuelsupply.gasStation.dtos;

import com.felipe.msfuelsupply.gasStation.GasStation;

import java.util.UUID;

public record GasStationResponseDTO (

        UUID id,
        String name,
        String district,
        String street,
        String numberToContact
){
    public static GasStationResponseDTO createGasStationResponseDTO(GasStation gasStation) {
        return new GasStationResponseDTO(
                gasStation.getId(),
                gasStation.getName(),
                gasStation.getDistrict(),
                gasStation.getStreet(),
                gasStation.getNumberToContact()
        );
    }
}
