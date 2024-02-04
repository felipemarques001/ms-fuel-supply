package com.felipe.msfuelsupply.vehicle;

import com.felipe.msfuelsupply.security.UserService;
import com.felipe.msfuelsupply.utils.APIGlobalResponseDTO;
import com.felipe.msfuelsupply.vehicle.dtos.VehicleRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final UserService userService;

    public VehicleController(VehicleService vehicleService,
                             UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid VehicleRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("cadastrar vehicle");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = vehicleService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler vehicle");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = vehicleService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("ler vehicle");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = vehicleService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> updateVehicle(@PathVariable UUID id,
                                                              @RequestBody @Valid VehicleRequestDTO dto) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("atualizar vehicle");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        var response = vehicleService.updateVehicle(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID id) {
        HttpStatusCode authorizationStatusCode = userService.verifyPermission("apagar vehicle");

        if(authorizationStatusCode.equals(HttpStatus.UNAUTHORIZED))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        vehicleService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
