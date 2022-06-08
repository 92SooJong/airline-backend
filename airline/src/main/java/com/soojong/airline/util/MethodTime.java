package com.soojong.airline.util;

public class MethodTime {

    private String methodName;
    private long methodStartMillis;
    private String requestId;


    public MethodTime(String methodName, long methodStartMillis, String requestId) {
        this.methodName = methodName;
        this.methodStartMillis = methodStartMillis;
        this.requestId = requestId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getMethodStartMillis() {
        return methodStartMillis;
    }

    public void setMethodStartMillis(long methodStartMillis) {
        this.methodStartMillis = methodStartMillis;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
