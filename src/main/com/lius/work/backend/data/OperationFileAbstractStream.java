package com.lius.work.backend.data;

import com.lius.work.backend.exercise.OperationTable;

import java.io.IOException;

public abstract class OperationFileAbstractStream {

    abstract Object readStream(String path) throws IOException, ClassNotFoundException;

    abstract <T> void writeStream(T data, String path) throws IOException;

}
