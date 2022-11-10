package com.lius.work.backend.operation;

import java.io.IOException;
import java.io.Serializable;

public class SubtractOperation extends OperationBase {


    public SubtractOperation() throws IOException {
        generateOperation('-');
    }

    public SubtractOperation(int left_value, int right_value, int result, char operate) {
        construct(left_value, right_value, result, operate);
    }

    public static OperationBase[][] generateSubtractOperation(int operateCount) {
        OperationBase[][] subtractOperations = new OperationBase[operateCount + 1][operateCount + 1];

        for (int i = 0; i <= operateCount; i++) {
            for (int j = 0; j <= i; j++) {
                subtractOperations[i][j] = new SubtractOperation(i, j, i - j, '-');
            }
        }
        return subtractOperations;
    }

    @Override
    boolean checkingCalculation(int result) {
        return result < getLower();
    }

    @Override
    int calculate(int left, int right) {
        return left - right;
    }
}
