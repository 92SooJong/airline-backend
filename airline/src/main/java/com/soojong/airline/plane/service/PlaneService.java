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

        MethodTime methodTime = watch.startWatch("PlaneService.findAllPlanes"); // 측정 시작
        List<Plane> allPlanes = planeRepository.findAll(); // 핵심로직
        sleep(2500); // 테스트를 위한 2.5초의 딜레이
        watch.endWatch(methodTime); // 측정 종료

        return allPlanes;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
