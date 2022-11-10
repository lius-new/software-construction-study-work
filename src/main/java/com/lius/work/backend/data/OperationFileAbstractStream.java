package com.lius.work.backend.data;

import com.lius.work.backend.exercise.OperationTable;
import com.lius.work.backend.operation.OperationBase;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class OperationFileAbstractStream {

    abstract <T> void readStream(OperationTable<T> obj, String path) throws IOException, ClassNotFoundException;

    abstract <T> void writeStream(T data, String path) throws IOException;

}
