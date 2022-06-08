package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public List<Plane> findAllPlanes() {

        log.info("{} 메소드 시작 " , "PlaneService.findAllPlanes");

        long startTime = System.currentTimeMillis();
        List<Plane> allPlanes = planeRepository.findAll();
        long endTime = System.currentTimeMillis();

        log.info("{} 메소드 수행 소요시간 : {} 초" , "PlaneService.findAllPlanes", (float)(endTime-startTime)/1000 );


        return allPlanes;
    }
}
