#include <stdio.h>
#include <stdlib.h>
#include "List.h"
int main()
{
    int i;
    list l;
    initList(&l);
    int v[] = {2,3,5,7,11,13,17,19,23,29};
    printf("Program about simple linked list");
    n_line;
    for(i = 0; i < 10; i++)
       l = addDataOnHead(&l,v[i]);
    displayAllCell(l);
    n_line;
    wasFound(l,17);
    removeData(&l,29);
    n_line;
    displayAllCell(l);
    sortData(&l);
    n_line;//Got to the next line by using the character carriage return
    puts("The list after sort operation");
    displayAllCell(l);
    n_line;
    puts("The list after reverse operation");
    l = reverseData(l);
    displayAllCell(l);
    breakList(&l);//Free the memory allocation
    return 0;
}
