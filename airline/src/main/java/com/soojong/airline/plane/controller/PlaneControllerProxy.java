package com.soojong.airline.plane.controller;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.service.PlaneService;
import com.soojong.airline.util.MethodTime;
import com.soojong.airline.util.Watch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
public class PlaneControllerProxy extends PlaneController{

    private final PlaneController planeController;
    private final Watch watch;

    public PlaneControllerProxy(PlaneController planeController, Watch watch) {
        super(null);
        this.planeController = planeController;
        this.watch = watch;
    }

    @Override
    public ResponseEntity<List<Plane>> findAllPlanes() {
        MethodTime methodTime = watch.startWatch("PlaneController.findAllPlanes");
        ResponseEntity<List<Plane>> allPlanes = planeController.findAllPlanes();
        watch.endWatch(methodTime);
        return allPlanes;

    }
}
