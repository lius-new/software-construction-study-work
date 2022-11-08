package com.lius;

import java.util.Arrays;

public class Exercise_3_1 {
    private static final short OPERATION_NUMBER = 50;
    private static final short COLUMN_NUMBER = 5;

    private final BinaryOperation_3_1[] operation_3_1 = new BinaryOperation_3_1[OPERATION_NUMBER];

    /**
     * 填充operation_3_1类型
     */
    public void generateBinaryExercise() {
        BinaryOperation_3_1 anOperation, opCreator = new BinaryOperation_3_1();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateBinaryOperation();
            // 判断是否在习题库中
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateBinaryOperation();
            }
            operation_3_1[i] = anOperation;
        }
    }

    /**
     * 填充operation_3_1类型
     */
    public void generateAdditionExercise() {
        BinaryOperation_3_1 anOperation, opCreator = new BinaryOperation_3_1();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateAdditionOperation();
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateAdditionOperation();
            }
            operation_3_1[i] = anOperation;
        }
    }

    /**
     * 填充operation_3_1类型
     */
    public void generateSubstractExercise() {
        BinaryOperation_3_1 anOperation, opCreator = new BinaryOperation_3_1();
        for (int i = 0; i < OPERATION_NUMBER; i++) {
            anOperation = opCreator.generateSubstractOperation();
            while (contains(anOperation, i - 1)) {
                anOperation = opCreator.generateSubstractOperation();
            }
            operation_3_1[i] = anOperation;
        }
    }

    /**
     * 在每次将数据添加的时候，判断其是否已经存在
     */
    private boolean contains(BinaryOperation_3_1 anOperation, int length) {
        boolean found = false;
        for (int i = 0; i < length; i++) {
            if (anOperation.equals(operation_3_1[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    void formatAndDisplay() {
        //TODO: 打印算式
        for (int i = 0; i < operation_3_1.length; i++) {
            System.out.print(i + 1 + ". " + operation_3_1[i].asString() + "\t");
            if ((i + 1) % 5 == 0) System.out.println("\n");
        }
    }

    /**
     * 判断是否还有下一个
     *
     * @return
     */
    public boolean hasNext() {
        return Arrays.stream(operation_3_1).iterator().hasNext();
    }

    /**
     * 获取下一个
     */
    public BinaryOperation_3_1 next() {
        return Arrays.stream(operation_3_1).iterator().next();
    }
}
