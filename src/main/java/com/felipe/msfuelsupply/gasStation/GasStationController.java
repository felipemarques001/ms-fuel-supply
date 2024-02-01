package com.felipe.msfuelsupply.gasStation;

import com.felipe.msfuelsupply.gasStation.dtos.GasStationRequestDTO;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gas_stations")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService service) {
        this.gasStationService = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid GasStationRequestDTO dto) {
        var response = gasStationService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        var response = gasStationService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        var response = gasStationService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> update(@PathVariable UUID id,
                                                       @RequestBody @Valid GasStationRequestDTO dto) {
        var response = gasStationService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        gasStationService.deleteByName(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
