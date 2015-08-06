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
arrayVertex  findShortPath(Graph g){
    arrayVertex av;
    Vertex v;
    List l;
    int i,j,k,dx,dy,c,nbr;
    char nn,mm;
    buildArrayVertex(&av,g.size);
    for (i = 0; i < g.size; i++){
        setName(&v,g.av.data[i].name);
        setPred(&v,g.av.data[i].pred);
        setDist(&v,g.av.data[i].dist);
        addVertex(&av,v);
    }
    for (k = 0; k < g.size - 1; k++){
        for (i = 0; i < g.size ; i++){
            nn = getNameByIndx(g.av,i);
            l = g.data[i];
            while(l != NULL){
                j = getIndxCel(l);
                dy = getDistByIndx(av,j);
                c = getCostCel(l);
                dx = getDistByIndx(av,i);
                if(dx == 2147483647){
                    nbr = dx;
                }
                else{
                    nbr = dx + c;
                }
                if (nbr < dy){
                    setDistByIndx(&av,j,nbr);
                    setPredByIndx(&av,j,nn);
                }
                l = l->next;
            }
        }
    }
    return av;
}
