package com.soojong.airline.util;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestDepth {

    private String requestId; // Watch를 소유하고있는 request ID를 표시
    private int depth; // 메소드의 Depth를 측정하기 위한 용도

    public RequestDepth() {
        this.depth = 0;
        this.requestId = UUID.randomUUID().toString().substring(0,8);
    }

    // 요청ID 만들기
    public String createRequestId(){
        if(requestId == null) return UUID.randomUUID().toString().substring(0,8);
        return requestId;
    }

    public void addDepth(){
        depth++;
    }

    public void minusDepth(){
        depth--;
    }

}
