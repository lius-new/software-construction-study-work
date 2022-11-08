package com.lius.v1;

import java.util.Random;

/**
 * 一个简单生成算式的程序
 * 缺点:
 *  1. 程序没有明确清晰的算式，习题的含义，没有相应的变量，数据结构等
 *  2. 难以扩充和修改, 可能会造成重复的工作
 *  3. 单纯的阅读代码无法确定程序是否正确，需要查看输出(代码冗余)
 *  4. 缺乏编码规范,变量无含义，没有注释
 *. ...
 *
 */
public class BinaryOperation_0 {
    public static void main(String[] args) {
        short a, b, c;
        char f = '+';

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            a = (short) random.nextInt(2);
            b = (short) random.nextInt(101);
            c = (short) random.nextInt(101);
            if (a == 1) {
                f = '-';
            }
            System.out.println("" + (i + 1) + ":\t" + b + f + c + "=");
        }


    }
}
