#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
#include "arrayVertex.h"
void printPath(arrayVertex av,char start,char end){
    int i,j,k = 0;
    char p;
    char path[20];
    k++;
    path[0] = end;
    i = getIndxVertexByName(av,end);
    p = getPredByIndx(av,i);
    printf("Find the short path by the Bellman method");
    cr;
    while (p != '?'){
        path[k] = p;
        k++;
        i = getIndxVertexByName(av,p);
        p = getPredByIndx(av,i);
    }
    for (j = k - 1; j >=0; j--){
            if (j != 0){
                     printf("%c--->",path[j]);
            }
            else{
                 printf("%c",path[j]);
            }

    }
}

