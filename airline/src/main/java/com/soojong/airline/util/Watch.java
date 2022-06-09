package com.soojong.airline.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Watch {


    private final ThreadLocal<RequestDepth> requestDepth = new ThreadLocal<>();

    // 메소드 시간 측정 시작
    public MethodTime startWatch(String methodName){

        syncRequestDepth();
        requestDepth.get().addDepth();
        String requestId = requestDepth.get().getRequestId();

        int depth = requestDepth.get().getDepth();
        log.info("[{}] {} | {} 메소드 시작 " , requestId,depthCallArrow(depth),methodName);
        return new MethodTime(methodName,System.currentTimeMillis(),requestId);
    }

    // 메소드 시간 측정 종료
    public void endWatch(MethodTime methodTime){
        int depth = requestDepth.get().getDepth();
        long durationMillis = System.currentTimeMillis() - methodTime.getMethodStartMillis();
        log.info("[{}] {} | {} 메소드 종료, 소요시간 : {} 초" , methodTime.getRequestId(),
                depthReturnArrow(depth),methodTime.getMethodName(), (float)durationMillis/1000 );

        endMethodWatch();

    }

    private void syncRequestDepth(){

        if(requestDepth.get() == null) requestDepth.set(new RequestDepth());


    }

    // 시계 반납
    private void endMethodWatch(){
        requestDepth.get().minusDepth();
        if(requestDepth.get().getDepth() == 0) requestDepth.remove();


    }

    private String depthCallArrow(int depth){
        StringBuilder result= new StringBuilder();
        for(int i=0; i<depth; i++){
            result.append("--");
        }
        return result + "->";

    }

    private String depthReturnArrow(int depth){
        StringBuilder result= new StringBuilder("<-");
        for(int i=0; i<depth; i++){
            result.append("--");
        }
        return result.toString();

    }

}
