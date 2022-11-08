#include<stdio.h>
#include<string.h>

#define ERROR -32768;

typedef int Equation[3]; // [operand1 ,operand2,operator]
typedef Equation Exercise[50];

void toString(Equation equation)
{
    if (equation[2] == '+')
        printf("%d + %d=",equation[0],equation[1]);
    else
        printf("%d - %d=",equation[0],equation[1]);
}

int calculate(Equation equation)
{
    if (equation[2] == '+')
        return equation[0] + equation[1];
    else
        return equation[0] - equation[1];
    return ERROR;
}

int main (int argc, char *argv[])
{
    for(int i = 0; i < 50;i++){

    }

	return 0;
}
