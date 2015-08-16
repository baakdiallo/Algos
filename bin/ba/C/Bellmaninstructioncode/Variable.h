#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
typedef enum nature Nature;
enum nature{
    oriented,noOriented
};
typedef struct cel Cel;
typedef Cel *List;
struct cel{
    char name;
    int cost;
    int indx;
    List next;
};
typedef struct vertex Vertex;
struct vertex{
   char name;
   char pred;
   int  dist;
   int indx;
};
typedef struct edge Edge;
struct edge{
    char left;
    char right;
    int cost;
};
typedef struct arrayvertex arrayVertex;
struct arrayvertex{
    int size;
    int indx;
    Vertex *data;
};
typedef struct arrayedge arrayEdge;
struct arrayedge{
    int size;
    int indx;
    Edge *data;
};
typedef struct graph Graph;
struct graph{
    int size;
    int indx;
    char start;
    char end;
    arrayVertex av;
    arrayEdge ae;
    List *data;
};
typedef struct network Network;
struct network{
    Nature type;
    int nbrVertex;
    int nbrEdge;
    char *vertex;
    char *edge;
    int *cost;
    char start;
    char end;
};
