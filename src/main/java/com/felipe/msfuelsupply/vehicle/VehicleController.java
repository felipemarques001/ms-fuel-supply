package com.felipe.msfuelsupply.vehicle;

import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import com.felipe.msfuelsupply.vehicle.dtos.UpdateVehicleDTO;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid VehicleDto dto) {
        var response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{plate}")
    public ResponseEntity<APIGlobalResponseDTO> findByPlate(@PathVariable String plate) {
        var response = service.findByPlate(plate);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        var response = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{plate}")
    public ResponseEntity<APIGlobalResponseDTO> updateVehicle(@RequestBody @Valid UpdateVehicleDTO dto,
                                                              @PathVariable String plate) {
        var response = service.updateVehicle(dto, plate);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity deleteVehicle(@PathVariable String plate) {
        service.deleteByPlate(plate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
