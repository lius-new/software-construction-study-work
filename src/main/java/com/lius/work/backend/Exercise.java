package com.lius.work.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise {
    private final short UPPER_LENGTH = 50;
    private final short COL_LENGTH = 5;

    private List<BinaryOperation> binaryOperations = new ArrayList<>();
    private int current;

    public void generateBinaryExercise(int operationCount) {
        BinaryOperation anOperation;
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();
            } while (contains(anOperation));
            binaryOperations.add(anOperation);
            operationCount--;
        }
    }

    public void generateAdditionExercise(int operationCount) {
        BinaryOperation anOperation;
        while (operationCount > 0) {
            do {
                anOperation = new AdditionOperation();
            } while (contains(anOperation));
            binaryOperations.add(anOperation);
            operationCount--;
        }
    }

    public void generateSubtractExercise(int operationCount) {
        BinaryOperation anOperation;
        while (operationCount > 0) {
            do {
                anOperation = new SubtractOperation();
            } while (contains(anOperation));
            binaryOperations.add(anOperation);
            operationCount--;
        }
    }

    public BinaryOperation generateOperation() {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            return new AdditionOperation();
        }
        return new SubtractOperation();
    }

    public boolean hashNext() {
        return current <= binaryOperations.size() - 1;
    }

    public BinaryOperation next() {
        return binaryOperations.get(current++);
    }

    public List<BinaryOperation> getBinaryOperations() {
        return binaryOperations;
    }

    public boolean contains(BinaryOperation binaryOperation) {
        boolean found = false;
        for (int i = 0; i < binaryOperations.size(); i++) {
            if (binaryOperations.get(i).equals(binaryOperation)) {
                found = true;
                break;
            }
        }
        return found;
    }

}
