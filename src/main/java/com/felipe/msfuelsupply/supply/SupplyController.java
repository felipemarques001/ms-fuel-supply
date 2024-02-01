package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.supply.dtos.SupplyRequestDTO;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/supplies")
public class SupplyController {

    private SupplyService service;

    public SupplyController(SupplyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid SupplyRequestDTO dto) {
        var response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        var response = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        var response = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> update(@PathVariable UUID id,
                                                       @RequestBody @Valid SupplyRequestDTO dto) {
        var response = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
