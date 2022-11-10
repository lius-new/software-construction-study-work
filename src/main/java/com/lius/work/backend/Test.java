package com.lius.work.backend;

import com.lius.work.backend.data.OperationFileStream;
import com.lius.work.backend.exercise.ExerciseSheet;
import com.lius.work.backend.exercise.OperationTable;
import com.lius.work.backend.operation.OperationBase;
import com.lius.work.util.Util;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OperationBase[][] operationBases = ExerciseSheet.generateOperationBase(20);
        OperationTable<OperationBase[][]> operationTable = new OperationTable<>(operationBases);

//        Util.printOperateBase(operationTable.getData());
//        System.out.println("---------------------------------");
//        Util.printOperateBaseForArray(operationTable.getData());

        OperationFileStream operationFileStream = new OperationFileStream();
        operationFileStream.writeStream(operationBases, "./data/test.dat");
//        operationFileStream.readStream(null, "/home/lius/directory/code-resp/java-resp/school-demo/software-construction-study-work/test.dat");

        OperationTable<OperationBase[][]> operationTable1 = new OperationTable<OperationBase[][]>();
        operationFileStream.readStream(operationTable1, "./data/test.dat");
        Util.printOperateBase(operationTable1.getData());
    }

}
