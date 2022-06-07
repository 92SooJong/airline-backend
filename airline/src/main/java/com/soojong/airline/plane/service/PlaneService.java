package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public List<Plane> findAllPlanes() {

        List<Plane> allPlanes = planeRepository.findAll();

        return allPlanes;
    }
}
