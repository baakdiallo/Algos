#include <stdio.h>
#include <stdlib.h>
#include "List.h"
void initList(list *l){
  *l = NULL;
}
boolean isEmpty(list l){
   if(l == NULL)
     return true;
   else
     return false;
}
list buildList(int data){
    list l = (list) malloc(sizeof(cell));
    l->data = data;
    l->next = NULL;
    return l;
}
void breakList(list *l){
   if(*l != NULL){
       breakList(&(*l)->next);
       free(*l);
   }
   *l = NULL;
}
int getData(list l){
  return l->data;
}
list getNext(list l){
   return l->next;
}
list getHead(list l){
   return l;
}
list getTail(list l){
   while(!isEmpty(l->next))
      l = l->next;
   return l;
}
list addDataOnHead(list *l,int data){
   list p = (list) malloc(sizeof(cell));
   p->data = data;
   p->next = *l;
   *l = p;
   return *l;
}
list addDataOnTail(list *l,int data){
   if(*l == NULL){
      list p = (list) malloc(sizeof(cell));
      p->data = data;
      p->next = NULL;
      return p;
   }
   else
     (*l)->next = addDataOnTail(&(*l)->next,data);
   return *l;
}
void displayOneCell(cell c){
  printf("%d ",c.data);
}
void displayAllCell(list l){
  if(l != NULL){
    displayOneCell(*l);
    displayAllCell(l->next);
  }
}
boolean containsData(list l,int data){
   if(isEmpty(l))
      return false;
   else if(l->data == data)
      return true;
   else
      return containsData(l->next,data);
}
void  wasFound(list l,int data){
   boolean b = containsData(l,data);
   if(b)
     printf("The data %d is present on the list",data);
   else
     printf("The data %d is not present on the list",data);
}
void removeData(list *l,int data){
    boolean found = containsData(*l,data);
    if(!found)
        printf("That is impossible to remove this data");
    else if((*l)->data == data){
        list p = *l;
        *l = (*l)->next;
        free(p);
    }
    else{
        list q,p = *l;
        while(p->data != data){
            q = p;
            p = p->next;
        }
        q->next = p->next;
        free(p);
    }
}
void sortData(list *l){
    //For to simplified this function, swap the data.
   list p = *l;
   while(!isEmpty(p->next)){
      list q = p->next;
      while(!isEmpty(q)){
        if(p->data > q->data){
            int value = p->data;
            p->data = q->data;
            q->data = value;
        }
        q = q->next;//Increment the pointer q
      }
      p = p->next;//Increment the pointer p
   }
}
list reverseData(list l){
   list p = l,q;
   initList(&q);//Q is going to the list result
   while(!isEmpty(p)){
      addDataOnHead(&q,getData(p));
      p = getNext(p);
   }
   return q;//Return the new reference
}
