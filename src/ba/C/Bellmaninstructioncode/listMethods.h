extern void buildList(List *l);
extern void addHead(List *l,char name,int cost,int indx);
extern void addFoot(List *l,char name,int cost,int indx);
extern int isEmpty(List l);
extern void displayList(List l);
extern void reverseList(List *l);
extern char getNameCel(List l);
extern int getCostCel(List l);
extern int getIndxCel(List l);
