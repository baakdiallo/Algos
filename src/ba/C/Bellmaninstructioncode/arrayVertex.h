extern void buildArrayVertex(arrayVertex * av,int size);
extern void addVertex(arrayVertex *av,Vertex v);
extern int getDistByIndx(arrayVertex av,int i);
extern char getPredByIndx(arrayVertex av,int i);
extern void displayArrayVertex(arrayVertex av);
extern int getIndxVertexByName(arrayVertex av,char name);
extern char getNameByIndx(arrayVertex av,int i);
extern void setDistByIndx(arrayVertex *av,int i,int d);
extern void setPredByIndx(arrayVertex *av,int i,char p);

