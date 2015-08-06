#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
void setName(Vertex *v,char name){
    v->name = name;
}
void setPred(Vertex *v,char pred){
    v->pred = pred;
}
void setDist(Vertex *v,int dist){
    v->dist = dist;
}
void setIndx(Vertex *v,int indx){
    v->indx = indx;
}

char getName(Vertex v){
    return v.name;
}
char getPred(Vertex v){
    return v.pred;
}
int getDist(Vertex v){
    return v.dist;
}
int getIndx(Vertex v){
    return v.indx;
}
void displayVertex(Vertex v){
    char name;
    if (v.dist == 2147483647){
        name = (char) 126;
        printf("(%c,%c,%c) ",v.name,v.pred,name);
    }
    else{
        printf("(%c,%c,%d) ",v.name,v.pred,v.dist);
    }

}
