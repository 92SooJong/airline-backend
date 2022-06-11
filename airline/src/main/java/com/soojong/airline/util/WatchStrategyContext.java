package com.soojong.airline.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WatchStrategyContext {

    private final Watch watch;

    // 전략을 입력받아 처리한다
    // 전략 = 비즈니스 로직
    public Object execute(WatchStrategy watchStrategy,String methodName){
        MethodTime methodTime = watch.startWatch(methodName);
        Object result = watchStrategy.call();
        watch.endWatch(methodTime);
        return result;
    }

}
