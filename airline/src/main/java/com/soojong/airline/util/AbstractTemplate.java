package com.soojong.airline.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final Watch watch;

    public T execute(String methodName){

        MethodTime methodTime = watch.startWatch(methodName);
        T result = call();
        watch.endWatch(methodTime);
        return result;
    }

    protected abstract T call();

}
