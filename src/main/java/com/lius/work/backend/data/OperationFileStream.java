package com.lius.work.backend.data;

import com.lius.work.backend.exercise.OperationTable;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.util.Util;

import java.io.*;

public class OperationFileStream extends OperationFileAbstractStream {

    @Override
    public <T> void readStream(OperationTable<T> obj, String path) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            T t = (T) objectInputStream.readObject();
            obj.construct((t));

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public <T> void writeStream(T data, String path) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
