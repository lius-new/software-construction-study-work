package com.lius.work.backend.exercise;

import com.lius.work.backend.operation.AdditionOperation;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.backend.operation.SubtractOperation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 用于生成数据
 */
public class Exercise {
    private int count;
    private final List<OperationBase> operationBases = new ArrayList<>();

    public void generateAdditionOperation(int operateCount) {
        AdditionOperation additionOperation;
        for (int i = 0; i < operateCount; i++) {
            do {
                additionOperation = new AdditionOperation();
            } while (contains(additionOperation));
            operationBases.add(additionOperation);
        }
    }

    public void generateOperation(int operateCount) throws IOException {
        Random random = new Random();
        OperationBase operationBase;
        for (int i = 0; i < operateCount; i++) {
            // TODO: 逻辑存在问题
            do {
                if (random.nextInt(2) == 1) {
                    operationBase = new AdditionOperation();
                } else {
                    operationBase = new SubtractOperation();
                }
            } while (contains(operationBase));
            operationBases.add(operationBase);
        }
    }

    public void generateSubtractOperation(int operateCount) {
        SubtractOperation subtractOperation;
        for (int i = 0; i < operateCount; i++) {
            do {
                subtractOperation = new SubtractOperation();
            } while (contains(subtractOperation));
            operationBases.add(subtractOperation);
        }
    }

    public boolean contains(OperationBase operationBase) {
        boolean found = false;
        for (int i = 0; i < operationBases.size(); i++) {
            if (operationBase.equals(operationBases.get(i))) {
                found = true;
                break;
            }
        }
        return found;
    }


    public List<OperationBase> getOperationBases() {
        return operationBases;
    }
}
