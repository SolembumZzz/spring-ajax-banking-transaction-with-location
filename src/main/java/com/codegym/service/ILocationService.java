package com.codegym.service;

import com.codegym.model.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    List<Location> selectAllLocation();

    Optional<Location> selectLocationById(Long id);

    boolean ifExists(Long id);

    Location createLocation(Location location);

    Location updateLocation(Location location);


}
