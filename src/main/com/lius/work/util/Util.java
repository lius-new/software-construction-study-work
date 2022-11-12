package com.lius.work.util;

import com.lius.work.backend.operation.OperationBase;

import java.util.Arrays;

public class Util {

    public static void printOperateBaseForArray(OperationBase[][] operationBases) {
        for (int i = 0; i < operationBases.length; i++) {
            Object[] objects = Arrays.stream(operationBases[i]).map(item -> item.asString() + "\t").toArray();
            System.out.println(Arrays.toString(objects));
        }
    }

    public static void printOperateBaseForArray(OperationBase[] operationBases) {
        for (int i = 0; i < operationBases.length; i++) {
            System.out.println(operationBases[i].asString());
        }
    }

    public static void printOperateBase(OperationBase[][] operationBases) {
        for (int i = 0; i < operationBases.length; i++) {
            Object[] objects = Arrays.stream(operationBases[i]).map(item -> item.asString() + "\t").toArray();
            for (int w = 0; w < objects.length; w++) {
                System.out.printf("%6s", objects[w]);
            }
            System.out.println();
        }
    }

}
