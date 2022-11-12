package com.lius.work.backend.exercise;

import java.io.Serializable;

public class OperationTable<T> {

    private T data;


    public OperationTable() {
    }

    public OperationTable(T data) {
        this.data = data;
    }

    public void construct(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }


    @Override
    public String toString() {
        return "OperationTable{" +
                "data=" + data +
                '}';
    }
}
