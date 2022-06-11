package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.util.WatchCallback;
import com.soojong.airline.util.WatchStrategyContext;
import com.soojong.airline.util.WatchTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final WatchTemplate watchTemplate;

    public List<Plane> findAllPlanes() {

        // 익명 내부클래스 형태로 전달
        return watchTemplate.execute(new WatchCallback<List<Plane>>() {
            @Override
            public List<Plane> call() {
                sleep(2500);
                return planeRepository.findAll();
            }
        }, "PlaneService.findAllPlanes");


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
