package com.lius;


import java.util.Random;

abstract class BinaryOperation_3_2 {
    static final int UPPER = 100;
    static final int LOWER = 0;

    private int left_operand = 0, right_operand = 0;
    private char operator = '+';
    private int value = 0;

    protected void generateBinaryOperation(char anOperator) {
        int left, right, reuslt;

        Random random = new Random();
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            reuslt = left + right;
        } while (!(checkingCalculation(reuslt)));

        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = reuslt;
    }

    abstract boolean checkingCalculation(int anInteger);

    abstract int calculate(int left, int right);

    public boolean equals(BinaryOperation_3_2 anOperation) {
        return left_operand == anOperation.left_operand && right_operand == anOperation.right_operand && operator == anOperation.operator;
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
}
