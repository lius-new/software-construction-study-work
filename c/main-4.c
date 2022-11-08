#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int generateOperand(){
    return rand() % 100;
}

void generateExerciseOfAdditionEquations(int len)
{
    int n , m, v ;
    srand((unsigned)time(NULL)); // 因为循环很快
    for (int i = 1;  i <= len ; i++) {
       do {
          n =  generateOperand();
          m =  generateOperand();
          v = m + n;
       }while( v >= 100 );
       printf("%d. %d+%d= \t",i,n,m);
       if (i % 5==0) printf("\n");
    }
}


int main (int argc, char *argv[])
{
    generateExerciseOfAdditionEquations(20);
	return 0;
}
