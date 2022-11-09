package com.lius.work.backend;

import java.util.Random;

public abstract class BinaryOperation {
    public final int UPPER = 100;
    public final int LOWER = 0;

    private int left_operand = 0, right_operand = 0;
    private char operator = '+';
    private int value = 0;

    private void construct(int left, int right, char op, int result) {
        left_operand = left;
        right_operand = right;
        operator = op;
        value = result;
    }

    public void generateBinaryOperation(char anOperation) {
        Random random = new Random();
        int left, right, result;
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = calculate(left, right);
        } while (!checkingCalculation(result));

        construct(left, right, anOperation, value);
    }

    protected abstract boolean checkingCalculation(int anInteger);

    protected abstract int calculate(int left, int right);

    public boolean equals(BinaryOperation binaryOperation) {
        return left_operand == binaryOperation.left_operand && right_operand == binaryOperation.right_operand && operator == binaryOperation.operator;
    }


    public String asString() {
        return left_operand +
                "" + operator + "" + right_operand;
    }

    public String fullString() {
        return left_operand +
                "" + operator + "" + right_operand +
                "=" + value;
    }


    @Override
    public String toString() {
        return left_operand +
                "" + operator + "" + right_operand +
                "=";
    }

    public int getLeft_operand() {
        return left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    public char getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }
}
