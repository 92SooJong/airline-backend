package com.soojong.airline.config;

import com.soojong.airline.plane.controller.PlaneController;
import com.soojong.airline.plane.controller.PlaneControllerProxy;
import com.soojong.airline.plane.repository.PlaneRepository;
import com.soojong.airline.plane.service.PlanServiceProxy;
import com.soojong.airline.plane.service.PlaneService;
import com.soojong.airline.util.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProxyConfig {

    private final PlaneRepository planeRepository;
    private final Watch watch;

    @Bean
    public PlaneController planeController(){

        return new PlaneControllerProxy(new PlaneController(planeService()), watch);
    }

    @Bean
    public PlaneService planeService(){

        return new PlanServiceProxy(new PlaneService(planeRepository),watch);
    }


}
