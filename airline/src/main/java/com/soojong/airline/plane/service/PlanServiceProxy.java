package com.soojong.airline.plane.service;

import com.soojong.airline.plane.entity.Plane;
import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.util.MethodTime;
import com.soojong.airline.util.Watch;
import com.soojong.airline.util.WatchTemplate;

import java.util.List;

public class PlanServiceProxy extends PlaneService {

    private final PlaneService planeService;
    private final Watch watch;

    public PlanServiceProxy(PlaneService planeService, Watch watch) {
        super(null); // 부모가 기본 생성자가 없기 때문에 작성 해줘야한다!
        this.planeService = planeService;
        this.watch = watch;
    }

    @Override
    public List<Plane> findAllPlanes() {
        MethodTime methodTime = watch.startWatch("planeService.findAllPlanes");
        List<Plane> allPlanes = planeService.findAllPlanes();
        watch.endWatch(methodTime);

        return allPlanes;
    }
}
