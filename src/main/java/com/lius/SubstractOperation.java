package com.lius;


public class SubstractOperation extends BinaryOperation_3_2 {

    SubstractOperation() {
        generateBinaryOperation('-');
    }

    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}
