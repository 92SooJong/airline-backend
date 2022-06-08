package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.util.MethodTime;
import com.soojong.airline.util.Watch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final Watch watch;

    public List<Plane> findAllPlanes() {

        MethodTime methodTime = watch.startWatch("PlaneService.findAllPlanes");
        List<Plane> allPlanes = planeRepository.findAll();
        watch.endWatch(methodTime,false);

        return allPlanes;
    }
}
