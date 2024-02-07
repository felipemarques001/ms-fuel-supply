package com.felipe.msfuelsupply.gasStation;

import com.felipe.msfuelsupply.gasStation.dtos.GasStationRequestDTO;
import com.felipe.msfuelsupply.security.UserService;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gas_stations")
public class GasStationController {

    private final GasStationService gasStationService;
    private final UserService userService;

    public GasStationController(GasStationService service, UserService userService) {
        this.gasStationService = service;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid GasStationRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("cadastrar gasstation");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = gasStationService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler gasstation");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = gasStationService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler gasstation");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = gasStationService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> update(@PathVariable UUID id,
                                                       @RequestBody @Valid GasStationRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("atualizar gasstation");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = gasStationService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("apagar supply");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        gasStationService.deleteByName(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
