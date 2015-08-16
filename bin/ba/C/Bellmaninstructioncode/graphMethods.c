#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
#include "listMethods.h"
#include "networkMethods.h"
#include "vertexMethods.h"
#include "arrayVertex.h"
#include "edgeMethods.h"
#include "arrayEdge.h"
void buildGraph(Graph *g,int size1,int size2){
    int i;
    g->size = size1;
    g->data = (List *) malloc(size1 * sizeof(List));
    g->indx = 0;
   buildArrayVertex(&g->av,size1);
   buildArrayEdge(&g->ae,size2);
    for (i = 0; i < g->size; i++){
        buildList(&g->data[i]);
    }
}
void addDataByIndx(Graph *g,char name,int cost,int indx,int gIndx){
    addHead(&g->data[gIndx],name,cost,indx);
}
void displayGraph(Graph g){
    int i;
    for (i = 0; i < g.size; i++){
        displayList(g.data[i]);
        printf("\n");
    }
}
void initGraphByNetwork(Graph *g){
    Vertex v;
    Edge e;
    int i,j,c,d;
    char nn,mm;
    Network n = networkLoading();
    g->start = n.start;
    g->end = n.end;
    buildGraph(g,n.nbrVertex,n.nbrEdge);
    for (i = 0; i < n.nbrVertex; i++){
        setName(&v,n.vertex[i]);
        setPred(&v,'?');
        setDist(&v,2147483647);
        addVertex(&g->av,v);
    }
    for (i = 0; i < n.nbrEdge ; i++){
      setLeftVertex(&e,n.edge[2 * i]);
      setRightVertex(&e,n.edge[2 * i + 1]);
      setCostEdge(&e,n.cost[i]);
      addEdge(&g->ae,e);
    }
    i = getIndxVertexByName(g->av,n.start);
    g->av.data[i].dist = 0;
    i = 0;
    while (i < n.nbrVertex){
        nn = getNameByIndx(g->av,i);
        j = 0;
        while (j < n.nbrVertex){
            mm = getNameByIndx(g->av,j);
            if ( (d = isInArrayEdge(g->ae,nn,mm)) != -1){
                c = getCostByIndx(g->ae,d);
                addDataByIndx(g,mm,c,j,i);
            }
            j++;
        }
        i++;
    }
    return g;
}
