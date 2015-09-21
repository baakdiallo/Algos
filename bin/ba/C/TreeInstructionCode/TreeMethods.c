#include <stdlib.h>
#include <stdio.h>
#include "Variable.h"
#define NULL ((void *) 0)
void buildTree(Tree *a,int data){
    *a = (Tree) malloc(sizeof(Cel));
    (*a)->data = data;
    (*a)->leftSon = NULL;
    (*a)->rightSon = NULL;
}
void addDataTree(Tree *a,Tree b){
    if(*a == NULL){
        *a = b;
    }
    else if((*a)->data > b->data){
        addDataTree(&(*a)->leftSon,b);
    }else{
        addDataTree(&(*a)->rightSon,b);
    }
}
void printRGD(Tree a){
    if(a != NULL){
        printf("%d ",a->data);
        printRGD(a->leftSon);
        printRGD(a->rightSon);
    }
}
void printGRD(Tree a){
    if(a != NULL){
        printGRD(a->leftSon);
        printf("%d ",a->data);
        printGRD(a->rightSon);
    }
}

void printGDR(Tree a){
    if(a != NULL){
        printGDR(a->leftSon);
        printGDR(a->rightSon);
        printf("%d ",a->data);
    }
}
Tree searchDataTree(Tree a,int data){
    if(a == NULL){
        return NULL;
    }
    else if(a->data == data){
        return a;
    }
    else if(a->data > data){
        searchDataTree(a->leftSon,data);
    }
    else{
        searchDataTree(a->rightSon,data);
    }
}
int getMaxData(int nbr1,int nbr2){
    int max;
    max = (nbr1 < nbr2) ? nbr2 : nbr1;
    return max;
}
int getHeight(Tree a){
    if(a == NULL ){
        return -1;
    }else{
        return  1 + getMaxData(getHeight(a->leftSon),getHeight(a->rightSon));
    }
}
Tree getMaximum(Tree a){
    if(a == NULL){
        return NULL;
    }
    else if(a->rightSon == NULL){
        return a;
    }
    else{
        return getMaximum(a->rightSon);
    }
}
Tree getMinimum(Tree a){
    if(a == NULL){
        return NULL;
    }
    else if(a->leftSon == NULL){
        return a;
    }
    else{
        return getMinimum(a->leftSon);
    }
}
void deleteData(Tree *a,int d){
    Tree p,q;
    q = *a;
    p = NULL;
    int find = 0;
    while(q != NULL && find == 0){
        if(q->data == d){
            find = 1;
        }
        else if(q->data > d){
            p = q;
            q = q->leftSon;
        }
        else{
            p = q;
            q = q->rightSon;
        }
    }
    if(find == 1){//the data is found
        if(q->leftSon == NULL && q->rightSon == NULL){
            if(p == NULL){
                *a = NULL;
            }
            else{
            if(p->leftSon == q){
                p->leftSon = NULL;
            }
             else{
                p->rightSon = NULL;
            }
            }

        }
        else if(q->leftSon != NULL && q->rightSon != NULL){
              Tree r = q->rightSon,s = NULL;
              while(r->leftSon != NULL){
                s = r;
                r = r->leftSon;
              }
            if(p == NULL){
                *a = r;
                 r->leftSon = q->leftSon;
                 if(s != NULL){
                    r->rightSon = q->rightSon;
                 }
            }
            else{
            if(p->leftSon == q){
                p->leftSon = r;
              }
              else{
                p->rightSon = r;
              }
              if(s != NULL){
                s->leftSon = r->rightSon;
                r->rightSon = q->rightSon;

            }
              r->leftSon = q->leftSon;

              }

        }
        else{
            if(q->leftSon == NULL){
               if(p == NULL){
                *a = q->rightSon;
               }
               else{
                if(p->leftSon == q){
                 p->leftSon = q->rightSon;
               }
               else{
                p->rightSon = q->rightSon;
               }
               }
            }
            else{
                if(p == NULL){
                    *a = q->leftSon;
                }
                else{
                if(p->leftSon == q){
                p->leftSon = q->leftSon;
               }
               else{
                 p->rightSon = q->leftSon;
               }
                }

               }
            }
            free(q);
        }
    }

void breakTree(Tree a){
    if(a != NULL){
        breakTree(a->leftSon);
        breakTree(a->rightSon);
        free(a);
    }
}
