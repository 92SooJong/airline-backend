package com.soojong.airline.plane.service;

import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.util.WatchTemplate;

public class PlanServiceProxy extends PlaneService {

    public PlanServiceProxy(PlaneRepository planeRepository) {
        super(planeRepository);
    }
}
