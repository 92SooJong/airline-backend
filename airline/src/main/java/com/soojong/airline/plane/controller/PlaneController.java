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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaneController {

    private final PlaneService planeService;
    private final Watch watch;

    @GetMapping("/api/v1/planes")
    public ResponseEntity<List<Plane>> findAllPlanes(){

        MethodTime methodTime = watch.startWatch("PlaneController.findAllPlanes"); // 측정 시작
        List<Plane> allPlanes = planeService.findAllPlanes(); // 핵심 로직
        watch.endWatch(methodTime); // 측정 종료
        return new ResponseEntity<>(allPlanes,HttpStatus.OK);

    }



}
