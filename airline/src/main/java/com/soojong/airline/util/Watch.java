package com.soojong.airline.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Watch {

    private String requestId; // Watch를 소유하고있는 request ID를 표시
    private int depth =0; // 메소드의 Depth를 측정하기 위한 용도

    // 메소드 시간 측정 시작
    public MethodTime startWatch(String methodName){
        requestId = createRequestId();
        depth++;
        log.info("[{}] {} | {} 메소드 시작 " , requestId,depthCallArrow(depth),methodName);
        return new MethodTime(methodName,System.currentTimeMillis(),requestId);
    }

    // 메소드 시간 측정 종료
    public void endWatch(MethodTime methodTime){

        long durationMillis = System.currentTimeMillis() - methodTime.getMethodStartMillis();
        log.info("[{}] {} | {} 메소드 종료, 소요시간 : {} 초" , methodTime.getRequestId(),
                depthReturnArrow(depth),methodTime.getMethodName(), (float)durationMillis/1000 );
        depth--;
        if(depth == 1) releaseWatch();

    }

    // 요청ID 만들기
    private String createRequestId(){
        if(requestId == null) return UUID.randomUUID().toString().substring(0,8);
        return requestId;
    }

    // 시계 반납
    private void releaseWatch(){
        requestId = null;
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
