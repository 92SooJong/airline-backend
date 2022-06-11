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
    private final WatchStrategyContext watchStrategyContext;

    @GetMapping("/api/v1/planes")
    public ResponseEntity<List<Plane>> findAllPlanes(){

        // Context에 전략을 주입한다.
        // Context => 시간 측정 기능(Watch)
        // 전략 => 비즈니스 로직
        // 즉, Context에 비즈니스 로직(전략)만 바꿔끼워주면 된다.
        List<Plane> allPlanes = (List<Plane>) watchStrategyContext.execute(planeService::findAllPlanes, "PlaneController.findAllPlanes");

        return new ResponseEntity<>(allPlanes,HttpStatus.OK);

    }

}
