#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
void buildArrayVertex(arrayVertex *av,int size){
    av->size = size;
    av->indx = 0;
    av->data = (Vertex *) malloc(av->size * sizeof(Vertex));
}
void addVertex(arrayVertex *av,Vertex v){
    setName(&av->data[av->indx],v.name);
    setPred(&av->data[av->indx],v.pred);
    setDist(&av->data[av->indx],v.dist);
    av->indx++;
}
int getDistByIndx(arrayVertex av,int i){
    return av.data[i].dist;
}
char getPredByIndx(arrayVertex av,int i){
    return av.data[i].pred;
}
char getNameByIndx(arrayVertex av,int i){
    return av.data[i].name;
}
void displayArrayVertex(arrayVertex av){
    int j;
    for(j = 0;j < av.indx; j++){
        displayVertex(av.data[j]);
    }
}
int getIndxVertexByName(arrayVertex av,char name){
    int i =0;
    while( i < av.indx && av.data[i].name != name){
        i++;
    }
    if (i < av.indx){
        return i;
    }
    else{
        return -1;
    }
}
void setDistByIndx(arrayVertex *av,int i,int d){
    setDist(&av->data[i],d);
}
void setPredByIndx(arrayVertex *av,int i,char p){
    setPred(&av->data[i],p);
}
