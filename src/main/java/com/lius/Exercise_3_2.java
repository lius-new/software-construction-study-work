package com.lius;

import java.util.ArrayList;
import java.util.Random;

public class Exercise_3_2 {
    //    private static final short OPERATION_NUMBER = 50;
    private static final short COLUMN_NUMBER = 5;

    private int current = 0;
    private final ArrayList<BinaryOperation_3_2> operationList = new ArrayList<>();

    public void generateBinaryExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();
            } while (contains(anOperation));
            operationList.add(anOperation);
            operationCount--;
        }
    }

    private BinaryOperation_3_2 generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);
        if (opValue == 1) {
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }

    public void generateAdditionExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        Random random = new Random();
        while (operationCount > 0) {
            do {
                anOperation = new AdditionOperation();
            } while (contains(anOperation));
            operationList.add(anOperation);
            operationCount--;
        }
    }

    public void generateSubstractExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        Random random = new Random();
        while (operationCount > 0) {
            do {
                anOperation = new SubstractOperation();
            } while (contains(anOperation));
            operationList.add(anOperation);
            operationCount--;
        }
    }

    private boolean contains(BinaryOperation_3_2 binaryOperation_3_2) {
        boolean found = false;
        for (int i = 0; i < operationList.size(); i++) {
            if (binaryOperation_3_2.equals(operationList.get(i))) {
                found = true;
                break;
            }
        }
        return false;
    }

    void formatAndDisplay() {
        //TODO: 打印算式
        for (int i = 0; i < operationList.size(); i++) {
            System.out.print(i + 1 + ". " + operationList.get(i).asString() + "\t");
            if ((i + 1) % 5 == 0) System.out.println("\n");
        }
    }

    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    public BinaryOperation_3_2 next() {
        return operationList.get(current++);

    }


}
