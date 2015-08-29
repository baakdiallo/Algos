#include <stdio.h>
#include <stdlib.h>
#include "Variable.h"
#include "TreeMethods.h"
#define cr printf("\n")
int main()
{
    int *array = (int *) malloc(5 * sizeof(int));
    int i;
    for(i = 0; i < 5; i++){
        array[i] = 2 * i + 1;
    }
    for(i = 0; i < 5; i ++){
        printf("%d ",array[i]);
    }
    cr;
    free(array);
    for(i = 0; i < 5; i ++){
        printf("%d ",array[i]);
    }
    array[3] = 12;
    for(i = 0; i < 5; i ++){
        printf("%d ",array[i]);
    }
    /*Tree a = NULL;
    Tree b;
    int t[10] = {15,5,16,3,12,20,10,13,6,7};
    int i;
    for (i = 0; i < 10; i++){
        buildTree(&b,t[i]);
        addDataTree(&a,b);
    }
    printf("la hauteur de l'arbre est %d\n",getHeight(a));
    breakTree(a);
    printf("%d",a->leftSon->data);
    printRGD(a)
    cr;
    for(i = 0; i < 10; i++){
       deleteData(&a,t[i]);
       printRGD(a);
       cr;
    }

    printRGD(a);
    breakTree(a);*/
    return 0;
}
