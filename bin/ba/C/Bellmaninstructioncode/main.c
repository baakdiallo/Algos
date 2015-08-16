#include <stdio.h>
#include <stdlib.h>
#include "Variable.h"
#include "listMethods.h"
#include "vertexMethods.h"
#include "arrayVertex.h"
#include "graphMethods.h"
#include "networkMethods.h"
#include "bellmanMetods.h"
#include "printShortPah.h"
#define rc printf("\n")
int main()
{   arrayVertex result;
    Graph g;
    initGraphByNetwork(&g);
    result = findShortPath(g);
    printPath(result,g.start,g.end);
    return 0;
}
