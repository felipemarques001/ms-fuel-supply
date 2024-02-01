package com.felipe.msfuelsupply.supply.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record SupplyRequestDTO (

        @Length(min = 36, max = 36, message = "The sent value doesn't represents an ID")
        String vehicleId,

        @Length(min = 36, max = 36, message = "The sent value doesn't represents an ID")
        String gasStationId,

        @NotNull(message = "The field of value cannot be empty")
        BigDecimal value,

        @NotNull(message = "The value of litres cannot be empty")
        BigDecimal litres
){
}
