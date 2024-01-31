package com.felipe.msfuelsupply.gasStation;

import com.felipe.msfuelsupply.gasStation.dtos.GasStationRequestDTO;
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
@Table(name = "TB_GAS_STATION")
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String street;

    @Column(
            nullable = false,
            name = "number_to_contact"
    )
    private String numberToContact;

    public GasStation(GasStationRequestDTO dto) {
        this.name = dto.name();
        this.district = dto.district();
        this.street = dto.street();
        this.numberToContact = dto.numberToContact();
    }
}
