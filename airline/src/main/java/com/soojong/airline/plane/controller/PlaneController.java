package com.soojong.airline.plane.controller;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping("/api/v1/planes")
    public ResponseEntity<List<Plane>> findAllPlanes(){

        List<Plane> allPlanes = planeService.findAllPlanes();

        return new ResponseEntity<>(allPlanes,HttpStatus.OK);


    }

}
