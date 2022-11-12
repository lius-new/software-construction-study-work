package com.lius.work.backend;

import com.lius.work.backend.data.OperationFileStream;
import com.lius.work.backend.exercise.ExerciseSheet;
import com.lius.work.backend.exercise.OperationTable;
import com.lius.work.backend.operation.ComponentUseOperationData;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.lius.work.backend.exercise.ExerciseSheet.getOperationTableNumber;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        OperationBase[][] operationBases = ExerciseSheet.generateOperationBase(100);
//        OperationTable<OperationBase[][]> operationTable = new OperationTable<>(operationBases);
//        OperationTable<OperationBase[]> operationTableNumber = getOperationTableNumber(operationTable, 40);
//
//        Util.printOperateBaseForArray(operationTableNumber.getData());

//        Util.printOperateBase(operationTable.getData());
//        System.out.println("---------------------------------");
//        Util.printOperateBaseForArray(operationTable.getData());

//        OperationFileStream operationFileStream = new OperationFileStream();
//        operationFileStream.writeStream(operationBases, "./data/test.dat");
//        operationFileStream.readStream(null, "/home/lius/directory/code-resp/java-resp/school-demo/software-construction-study-work/test.dat");

//        OperationTable<OperationBase[][]> operationTable1 = new OperationTable<OperationBase[][]>();
//        operationFileStream.readStream(operationTable1, "./data/test.dat");
//        Util.printOperateBase(operationTable1.getData());


//        OperationTable<List<OperationBase>> listOperationTable = ExerciseSheet.generateOperationAddition(20);
//        List<OperationBase> data = listOperationTable.getData();
//
//        ComponentUseOperationData<OperationBase> operationBaseComponentUseOperationData = new ComponentUseOperationData<>(data);
//        System.out.println(operationBaseComponentUseOperationData.get(1));

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0, 1);
        integers.add(1,2);
        integers.clear();
        System.out.println(integers);
    }

}
