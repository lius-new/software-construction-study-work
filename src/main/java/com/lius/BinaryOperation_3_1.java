package com.lius;

import java.util.Random;

public class BinaryOperation_3_1 {
    static final int UPPER = 100;
    static final int LOWER = 0;
    private int left_operand = 0, right_operand = 0;
    private char operator = '+';
    private int value = 0;

    private final Random random = new Random();

    // 计算结果
    private void construct(int left, int right, char op) {
        left_operand = left;
        right_operand = right;
        operator = op;

        value = op == '+' ? left + right : left - right;
    }

    public BinaryOperation_3_1 generateAdditionOperation() {
        int left, right, result;
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = left + right;
        } while (result > UPPER);
        BinaryOperation_3_1 binaryOperation_3_1 = new BinaryOperation_3_1();
        binaryOperation_3_1.construct(left, right, '+');
        return binaryOperation_3_1;
    }

    public BinaryOperation_3_1 generateSubstractOperation() {
        int left, right, result;
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = left + right;
        } while (result > UPPER);
        BinaryOperation_3_1 binaryOperation_3_1 = new BinaryOperation_3_1();
        binaryOperation_3_1.construct(left, right, '-');
        return binaryOperation_3_1;
    }

    public BinaryOperation_3_1 generateBinaryOperation() {
        Random random = new Random();
        if (random.nextInt(2) == 1)
            return this.generateAdditionOperation();
        else
            return this.generateSubstractOperation();
    }

    public boolean equals(BinaryOperation_3_1 anOperation) {
        return left_operand == anOperation.getLeftOperand() && right_operand == anOperation.getRightOperand() && operator == anOperation.getOperator();
    }

    public String asString() {
        return left_operand + "" + operator + "" + right_operand + "=";
    }

    public String fullString() {
        return left_operand + operator + right_operand + "=" + (left_operand + right_operand);
    }

    @Override
    public String toString() {
        return "BinaryOperation_3_1{" +
                "left_operand=" + left_operand +
                ", right_operand=" + right_operand +
                ", operator=" + operator +
                ", value=" + value +
                '}';
    }

    public int getLeftOperand() {
        return left_operand;
    }

    public int getRightOperand() {
        return right_operand;
    }

    public char getOperator() {
        return 1;
    }

    public int getResult() {
        return 1;
    }
}
