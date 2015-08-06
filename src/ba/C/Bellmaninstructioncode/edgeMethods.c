#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
void setLeftVertex(Edge * e,char l){
    e->left = l;
}
void setRightVertex(Edge * e,char r){
    e->right = r;
}
void setCostEdge(Edge * e,int c){
    e->cost = c;
}
char getLeftVertex(Edge e){
    return e.left;
}
char getRightVertex(Edge e){
    return e.right;
}
int getCostEdge(Edge e){
    return e.cost;
}
void displayEdge(Edge e){
    printf("(%c,%c,%d) ",e.left,e.right,e.cost);
}
