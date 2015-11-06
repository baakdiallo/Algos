#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED
#define n_line printf("\n")
//The next declaration is used to implement the abstract data type
typedef struct cell cell;
typedef cell * list;
struct cell{
   int data;
   list next;
};
//The next declaration is used to implement the boolean type
typedef enum boolean boolean;
enum boolean{
  true = 1,false = 0
};
//Define all functions over the linked list
//The next function is used to check if the list is empty or not
boolean isEmpty(list l);
//The next function is used to initialize the list
void initList(list *l);
//The next function is used to build a list
list buildList(int data);
//The next function is used to break the list
void breakList(list *l);
//The next function is used to return the data of list
int getData(list l);
//The next function is used to return the next of list
list getNext(list l);
//The next function is used to add a data on  head
list addDataOnHead(list *l,int data);
//The next function is used to add data on tail
list addDataOnTail(list *l,int data);
//The next function is used to return the head of list
list getHead(list l);
//The next function is used to return the tail list
list getTail(list l);
//The next function is used to display one cell
void displayOneCell(cell c);
//The next function is used to display all cell
void displayAllCell(list l);
//The next function is used to search data into the list
boolean containsData(list l,int data);
//The next function is used to remove data from the list or sequence
void removeData(list *l,int data);
//The next function is used to sort the list
void sortData(list *l);
//The next function is used to reverse the list
list reverseData(list l);
#endif // LIST_H_INCLUDED
