package com.example.bookmyspace.service;

import com.example.bookmyspace.model.Floor;
import com.example.bookmyspace.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {
    private final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }

    public Optional<Floor> getFloorById(Long id) {
        return floorRepository.findById(id);
    }

    public Floor saveFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    public void deleteFloor(Long id) {
        floorRepository.deleteById(id);
    }
}
