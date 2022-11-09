package com.lius.work.backend;


import com.lius.work.backend.BinaryOperation;

public class AdditionOperation extends BinaryOperation {
    public AdditionOperation() {
        generateBinaryOperation('+');
    }

    @Override
    protected boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    @Override
    protected int calculate(int left, int right) {
        return left + right;
    }

}
