package com.lius.work.backend.operation;

import java.io.IOException;
import java.io.Serializable;

public class AdditionOperation extends OperationBase {

    public AdditionOperation() throws IOException {
        generateOperation('+');
    }

    public AdditionOperation(int left_value, int right_value, int result, char operate) {
        construct(left_value, right_value, result, operate);
    }

    public static OperationBase[][] generateAdditionOperation(int operateCount) {
        OperationBase[][] additionOperations = new OperationBase[operateCount + 1][operateCount + 1];
        for (int i = 0; i <= operateCount; i++) {
            for (int j = 0; j <= operateCount - i; j++) {
                additionOperations[i][j] = new AdditionOperation(i, j, i + j, '+');
            }
        }
        return additionOperations;
    }

    @Override
    boolean checkingCalculation(int result) {
        return result > getUpper();
    }

    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}
