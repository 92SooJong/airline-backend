package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.util.AbstractTemplate;
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


        AbstractTemplate<List<Plane>> abstractTemplate = new AbstractTemplate(watch){

            @Override
            protected List<Plane> call() {
                sleep(2500); // 테스트를 위한 2.5초의 딜레이
                return planeRepository.findAll(); // 핵심 로직
            }
        };

        return abstractTemplate.execute("PlaneService.findAllPlanes");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
