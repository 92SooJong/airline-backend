package com.soojong.airline.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WatchTemplate {

    private final Watch watch;

    public <T> T execute(WatchCallback<T> callback,String methodName){
        MethodTime methodTime = watch.startWatch(methodName);
        T result = callback.call();
        watch.endWatch(methodTime);
        return result;
    }

}
