package com.lius;

public class AdditionOperation extends BinaryOperation_3_2 {
    AdditionOperation() {
        generateBinaryOperation('+');
    }

    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    /**
     * 计算
     */
    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}
