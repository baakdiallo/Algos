#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
#define NULL ((void *) 0)
void buildList(List *l){
    *l = NULL;
}
int isEmpty(List l){
   if(l == NULL){
    return 1;
   }
   else{
    return 0;
   }
}
void addHead(List *l,char name,int cost,int indx){
    List p;
    p = (List) malloc(sizeof(Cel));
    p->name = name;
    p->cost = cost;
    p->indx = indx;
    p->next = *l;
    *l = p;
}
void addFoot(List *l,char name,int cost,int indx){
    List p,q;
    p = (List) malloc(sizeof(Cel));
    p->name = name;
    p->cost = cost;
    p->indx = indx;
    p->next = NULL;
    if (isEmpty(*l) == 1){
        *l = p;
    }
    else{
        q = *l;
        while(q->next != NULL){
            q = q->next;
        }
        q->next = p;
    }
}
void displayList(List l){
    if (l != NULL){
    while(l->next != NULL){
        printf("(%c,%d,%d)--->",l->name,l->cost,l->indx);
        l = l->next;
    }
    printf("(%c,%d,%d)",l->name,l->cost,l->indx);
    }
}
int getLength(List l){
  if (l == NULL){
    return 0;
  }
  else{
    return 1 + getLength(l->next);
  }
}
void reverseList(List *l){
    List p,q;
    q = *l;
    while(q != NULL){
        addHead(&p,q->name,q->cost,q->indx);
        q = q->next;
    }
    *l = p;
}
char getNameCel(List l){
    return l->name;
}
int getCostCel(List l){
    return l->cost;
}
int getIndxCel(List l){
    return l->indx;
}
