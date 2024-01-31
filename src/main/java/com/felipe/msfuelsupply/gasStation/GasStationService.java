package com.felipe.msfuelsupply.gasStation;

import com.felipe.msfuelsupply.exceptions.FieldAlreadyInUseException;
import com.felipe.msfuelsupply.exceptions.ResourceNotFoundException;
import com.felipe.msfuelsupply.gasStation.dtos.GasStationRequestDTO;
import com.felipe.msfuelsupply.gasStation.dtos.GasStationResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    @Transactional
    public GasStationResponseDTO create(GasStationRequestDTO dto) {
        if(gasStationRepository.existsByName(dto.name()))
            throw new FieldAlreadyInUseException("name", dto.name());

        var newGasStation = new GasStation(dto);
        var savedGasStation = gasStationRepository.save(newGasStation);
        return GasStationResponseDTO.createGasStationResponseDTO(savedGasStation);
    }

    public GasStationResponseDTO findById(UUID id) {
        var gasStationOp = gasStationRepository.findById(id);
        if(gasStationOp.isEmpty())
            throw new ResourceNotFoundException("Gas station", "ID", id.toString());

        return GasStationResponseDTO.createGasStationResponseDTO(gasStationOp.get());
    }

    public List<GasStationResponseDTO> findAll(){
        var gasStationResponseDTOList = new ArrayList<GasStationResponseDTO>();
        List<GasStation> gasStationList = gasStationRepository.findAll();
        gasStationList.forEach(gasStation -> gasStationResponseDTOList.add(
                    GasStationResponseDTO.createGasStationResponseDTO(gasStation)
            )
        );

        return gasStationResponseDTOList;
    }

    @Transactional
    public GasStationResponseDTO update(UUID id, GasStationRequestDTO dto) {
        var gasStationOp = gasStationRepository.findById(id);
        if(gasStationOp.isEmpty())
            throw new ResourceNotFoundException("Gas station", "ID", id.toString());

        gasStationOp.get().setName(dto.name());
        gasStationOp.get().setDistrict(dto.district());
        gasStationOp.get().setStreet(dto.street());
        gasStationOp.get().setNumberToContact(dto.numberToContact());

        var updateGasStation = gasStationRepository.save(gasStationOp.get());
        return GasStationResponseDTO.createGasStationResponseDTO(updateGasStation);
    }

    @Transactional
    public void deleteByName(UUID id) {
        if(!(gasStationRepository.existsById(id)))
            throw new ResourceNotFoundException("Gas station", "ID", id.toString());
        gasStationRepository.deleteById(id);
    }
}
