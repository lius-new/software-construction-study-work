#include<stdio.h>
#include<string.h>

#define ERROR -32768;


// 使用的数据结构
typedef struct {
    unsigned short int left_operand, right_operand;
    char opeartor;
    unsigned short int value;
} Equation;

// Exercise[50] 只是一种类型
typedef Equation Exercise[50];

// 输出表达式
void toString(Equation equation) 
{
    if (equation.opeartor == '+')
        printf(" %d + %d = " ,equation.left_operand,equation.right_operand );
    else
        printf(" %d - %d = " ,equation.left_operand,equation.right_operand );
}

// 计算结果
int calculate(Equation equation)
{
    if (equation.opeartor=='+')
        return equation.left_operand + equation.right_operand;
    else
        return equation.left_operand - equation.right_operand;
    return ERROR;
}

int main (int argc, char *argv[])
{
	

	return 0;
}
