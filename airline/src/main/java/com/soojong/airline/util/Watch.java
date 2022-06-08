package com.soojong.airline.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Watch {

    private String requestId;
    private int depth =0;

    public MethodTime startWatch(String methodName){
        requestId = createRequestId();
        depth++;
        log.info("[{}] {} 메소드 시작 " , requestId,methodName);
        return new MethodTime(methodName,System.currentTimeMillis(),requestId);
    }

    public void endWatch(MethodTime methodTime){
        depth--;
        if(depth == 0) releaseRequestId();
        long durationMillis = System.currentTimeMillis() - methodTime.getMethodStartMillis();
        log.info("[{}] {} 메소드 수행 소요시간 : {} 초" , methodTime.getRequestId(),methodTime.getMethodName(), (float)durationMillis/1000 );

    }

    private String createRequestId(){

        if(requestId == null) return UUID.randomUUID().toString().substring(0,8);
        return requestId;
    }


    private void releaseRequestId(){
        requestId = null;
    }

}
