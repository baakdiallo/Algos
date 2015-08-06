#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
void buildArrayEdge(arrayEdge*ae,int size){
    ae->size = size;
    ae->indx = 0;
    ae->data = (Edge *) malloc(ae->size * sizeof(Edge));
}
void addEdge(arrayEdge *ae,Edge e){
    setLeftVertex(&ae->data[ae->indx],e.left);
    setRightVertex(&ae->data[ae->indx],e.right);
    setCostEdge(&ae->data[ae->indx],e.cost);
    ae->indx++;
}
int getCostByIndx(arrayEdge ae,int i){
    return ae.data[i].cost;
}
void displayArrayEdge(arrayEdge ae){
    int j;
    for(j = 0;j < ae.indx; j++){
        displayEdge(ae.data[j]);
    }
}int isInArrayEdge(arrayEdge ae,char n,char m){
    int i = 0;
    while((i < ae.indx) && (n != ae.data[i].left || m != ae.data[i].right)){
        i++;
    }
    if (i < ae.indx){
        return i;
    }
    else{
        return -1;
    }
}

