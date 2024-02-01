package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.gasStation.GasStation;
import com.felipe.msfuelsupply.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SUPPLY")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "vehicle_id",
            nullable = false
       )
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(
            name = "gas_station_id",
            nullable = false
    )
    private GasStation gasStation;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataCreated;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private BigDecimal litres;

    public Supply(Vehicle vehicle, GasStation gasStation, LocalDateTime localDateTime,
                  BigDecimal value, BigDecimal litres) {
        this.vehicle = vehicle;
        this.gasStation = gasStation;
        this.dataCreated = localDateTime;
        this.value = value;
        this.litres = litres;
    }
}
