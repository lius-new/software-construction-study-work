package com.lius.work.backend.operation;

import java.io.Serializable;
import java.util.Random;


/**
 * 生成Operation
 */
public abstract class OperationBase implements Serializable {
    public static final long serialVersionUID = 24324234L;

    private int upper = 100;
    private int lower = 0;

    private int left_value;
    private int right_value;
    private int value;
    private char operate;

    public OperationBase() {
    }

    public OperationBase(int left_vale, int right_value, int result, char operate) {
        this.left_value = left_vale;
        this.right_value = right_value;
        this.value = result;
        this.operate = operate;
    }

    public void construct(int left_vale, int right_value, int result, char operate) {
        this.left_value = left_vale;
        this.right_value = right_value;
        this.value = result;
        this.operate = operate;
    }

    abstract boolean checkingCalculation(int result);

    abstract int calculate(int left, int right);

    /**
     * 生成
     */
    public void generateOperation(char operate) {
        int left, right, result;
        Random random = new Random();
        left = random.nextInt(upper);
        do {
            right = random.nextInt(upper);
            result = calculate(left, right);
        } while (checkingCalculation(result));
        construct(left, right, result, operate);
    }


    public boolean equals(OperationBase operationBase) {
        return asString().equals(operationBase.asString());
    }

    public String asString() {
        return left_value + "" + operate + "" + right_value + "=";
    }

    @Override
    public String toString() {
        return "OperationBase{" +
                "upper=" + upper +
                ", lower=" + lower +
                ", left_value=" + left_value +
                ", right_value=" + right_value +
                ", value=" + value +
                ", operate=" + operate +
                '}';
    }

    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public int getLeft_value() {
        return left_value;
    }

    public int getRight_value() {
        return right_value;
    }

    public int getValue() {
        return value;
    }
}