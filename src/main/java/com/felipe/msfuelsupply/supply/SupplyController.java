package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.supply.dtos.SupplyRequestDTO;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
