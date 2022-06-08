package com.soojong.airline.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Watch {

    private String requestId;

    public MethodTime startWatch(String methodName){
        requestId = createRequestId();
        log.info("[{}] {} 메소드 시작 " , requestId,methodName);
        return new MethodTime(methodName,System.currentTimeMillis(),requestId);
    }

    public void endWatch(MethodTime methodTime,boolean isRelease){

        if(isRelease) releaseRequestId();

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
