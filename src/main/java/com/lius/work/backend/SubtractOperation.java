package com.lius.work.backend;

import com.lius.work.backend.BinaryOperation;

public class SubtractOperation extends BinaryOperation {
    public SubtractOperation() {
        generateBinaryOperation('-');
    }

    @Override
    protected boolean checkingCalculation(int anInteger) {
        return anInteger >= LOWER;
    }

    @Override
    protected int calculate(int left, int right) {
        return left + right;
    }
}
