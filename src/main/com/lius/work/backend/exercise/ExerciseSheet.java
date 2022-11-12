package com.lius.work.backend.exercise;

import com.lius.work.backend.operation.AdditionOperation;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.backend.operation.SubtractOperation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseSheet {

    public static OperationTable<List<OperationBase>> generateOperationByTypeAndCount(String type, int operateCount) {
        if (type.equals("加法")) {
            return generateOperationAddition(operateCount);
        } else if (type.equals("减法")) {
            return generateOperationSubtract(operateCount);
        } else {
            return getOperationTableNumber(ExerciseSheet.generateOperationBase(100), operateCount);
        }
    }

    public static OperationTable<List<OperationBase>> generateOperationAddition(int operateCount) {
        Exercise exercise = new Exercise();
        exercise.generateAdditionOperation(operateCount);
        List<OperationBase> operationBases = exercise.getOperationBases();
        return new OperationTable<>(operationBases);
    }

    public static OperationTable<List<OperationBase>> generateOperationSubtract(int operateCount) {
        Exercise exercise = new Exercise();
        exercise.generateSubtractOperation(operateCount);
        List<OperationBase> operationBases = exercise.getOperationBases();
        return new OperationTable<>(operationBases);
    }

    public static OperationTable<OperationBase[][]> generateOperationBase(int operateCount) {
        OperationBase[][] operationBases1 = AdditionOperation.generateAdditionOperation(operateCount);
        OperationBase[][] operationBases2 = SubtractOperation.generateSubtractOperation(operateCount);

        for (int i = 1, k = 0; i <= operateCount; i++, k++) {
            for (int j = 0; j < i; j++) {
                operationBases1[i][operationBases1.length - j - 1] = operationBases2[k][j];
            }
        }
        operationBases1[operateCount] = operationBases2[operateCount];
        return new OperationTable<>(operationBases1);
    }

    public static OperationTable<List<OperationBase>> getOperationTableNumber(OperationTable<OperationBase[][]> operationTable, int count) {
        // 获取两个数据
        Random random = new Random();
        // 维护二维数组
        int[][] indexs = new int[count][2];
        int index1, index2;
        for (int i = 0; i < count; i++) {
            do {
                index1 = random.nextInt(100);
                index2 = random.nextInt(100);
            } while (contains(indexs, index1, index2));
            indexs[i] = new int[]{index1, index2};
        }

        OperationBase[][] data = operationTable.getData(); // 数据对应的位置
        List<OperationBase> data1 = new ArrayList<>();// 数据存放
        for (int i = 0; i < count; i++) {
            int[] index = indexs[i];
            data1.add(data[index[0]][index[1]]);
        }
        return new OperationTable<>(data1);
    }

    public static boolean contains(int[][] indexs, int index1, int index2) {
        boolean found = false;
        for (int i = 0; i < indexs.length; i++) {
            if (indexs[i][0] == index1 && indexs[i][1] == index2) {
                found = true;
                break;
            }
        }
        return found;
    }

}
