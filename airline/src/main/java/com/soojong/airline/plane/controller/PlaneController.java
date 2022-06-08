package com.soojong.airline.plane.controller;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.service.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping("/api/v1/planes")
    public ResponseEntity<List<Plane>> findAllPlanes(){

        log.info("{} 메소드 시작 " , "PlaneController.findAllPlanes");

        long startTime = System.currentTimeMillis();
        List<Plane> allPlanes = planeService.findAllPlanes(); // 핵심 로직
        long endTime = System.currentTimeMillis();

        log.info("{} 메소드 수행 소요시간 : {} 초" , "PlaneController.findAllPlanes", (float)(endTime-startTime)/1000 );

        return new ResponseEntity<>(allPlanes,HttpStatus.OK);


    }

}
