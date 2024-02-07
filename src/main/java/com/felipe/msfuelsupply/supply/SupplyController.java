package com.felipe.msfuelsupply.supply;

import com.felipe.msfuelsupply.security.UserService;
import com.felipe.msfuelsupply.supply.dtos.SupplyRequestDTO;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/supplies")
public class SupplyController {

    private final SupplyService supplyService;
    private final UserService userService;

    public SupplyController(SupplyService supplyService, UserService userService) {
        this.supplyService = supplyService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid SupplyRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("cadastrar supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = supplyService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = supplyService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = supplyService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> update(@PathVariable UUID id,
                                                       @RequestBody @Valid SupplyRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("atualizar supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = supplyService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("apagar supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        supplyService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
