package com.lius.work.backend.exercise;

import com.lius.work.backend.operation.AdditionOperation;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.backend.operation.SubtractOperation;

import java.io.IOException;

public class ExerciseSheet {

    public static OperationBase[][] generateOperationBase(int operateCount) throws IOException {
        OperationBase[][] operationBases1 = AdditionOperation.generateAdditionOperation(operateCount);
        OperationBase[][] operationBases2 = SubtractOperation.generateSubtractOperation(operateCount);

        for (int i = 1, k = 0; i <= operateCount; i++, k++) {
            for (int j = 0; j < i; j++) {
                operationBases1[i][operationBases1.length - j - 1] = operationBases2[k][j];
            }
        }
        operationBases1[operateCount] = operationBases2[operateCount];

        return operationBases1;
    }

}
