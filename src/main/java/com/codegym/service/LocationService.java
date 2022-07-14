package com.codegym.service;

import com.codegym.model.Location;
import com.codegym.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationService implements ILocationService {

    @Autowired
    ILocationRepository locationRepository;

    @Override
    public List<Location> selectAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> selectLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public boolean ifExists(Long id) {
        return locationRepository.existsById(id);
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }
}
