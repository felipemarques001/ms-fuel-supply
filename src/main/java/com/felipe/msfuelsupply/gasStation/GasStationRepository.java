package com.felipe.msfuelsupply.gasStation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, UUID> {

    boolean existsByName(String name);
}
