#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <time.h>

#define ERROR -32768;

typedef struct {
    unsigned short int left_operand, right_operand;
    char opeartor;
    unsigned short int value;
} Equation;

typedef Equation Exercise[50];

int randomInt()
{
    srand((unsigned)time(NULL));
    return rand();
}

_Bool check(int anInteger,int low ,int high)
{
    return anInteger >= low && anInteger <= high;
}

Equation generateAdditionEquation()
{
    int m,n;
    do{
        m = randomInt();
        n = randomInt();
    }while(!check(m,0,100) || !check(n,0,100) || !check(m+n,0,100));
    Equation e = {.left_operand=m,.right_operand=n,.opeartor='+'};
    return e;
}
Equation generateSubstractEquation()
{
    int m,n;
    do{
       m = randomInt();
       n = randomInt();
    }while(!check(m,0,100) || !check(n,0,100) || !check(m+n,0,100));
    Equation e = {.left_operand=m,.right_operand=n,.opeartor='-'};
    return e;
}
Equation generateEquation()
{
    int operator = randomInt() % 2;
    if (operator == 0)
        return generateAdditionEquation();
    else
        return generateSubstractEquation();
}

void toString(Equation equation) 
{
    if (equation.opeartor == '+')
        printf(" %d + %d = " ,equation.left_operand,equation.right_operand );
    else
        printf(" %d - %d = " ,equation.left_operand,equation.right_operand );
}

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
