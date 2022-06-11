package com.soojong.airline.plane.controller;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.service.PlaneService;
import com.soojong.airline.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaneController{

    private final PlaneService planeService;
    private final WatchTemplate watchTemplate;

    @GetMapping("/api/v1/planes")
    public ResponseEntity<List<Plane>> findAllPlanes(){

        List<Plane> allPlanes = watchTemplate.execute(new WatchCallback<List<Plane>>() {
            @Override
            public List<Plane> call() {
                return planeService.findAllPlanes();
            }
        }, "PlaneController.findAllPlanes");

        return new ResponseEntity<>(allPlanes, HttpStatus.OK);

    }

}
