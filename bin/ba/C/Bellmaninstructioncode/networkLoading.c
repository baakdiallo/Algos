#include <stdio.h>
#include <stdlib.h>
#define cr printf("\n")
#include "Variable.h"
Network networkLoading(){
    Network n;
    int nbr1,nbr2,nbr3,nbr,j;
    char c;
    FILE *f = NULL;
    f = fopen("C:\\Users\\Ibrahima\\workdvision\\Beginner\\Bellmaninstructioncode\\networkConfig3.txt","rt");
    if (f == NULL){
        printf("Error to oppen this file...!");
    }
    else{
        int i;
        fscanf(f,"%d",&i);
        if (i == 0){
            n.type = noOriented;
        }
        else{
            n.type = oriented;
        }
        fscanf(f,"%d",&i);
        nbr1 = i;
        n.nbrVertex = nbr1;
        n.vertex = (char *) malloc(nbr1 * sizeof(char));
        fscanf(f,"%d",&i);
        nbr2 = i;
        nbr3 = nbr2;

        if(n.type == oriented){
           n.nbrEdge = nbr2;

           nbr2 *=2;
           n.edge = (char *) malloc(nbr2 * sizeof(char));
        }
        else{
            n.nbrEdge = 2 * nbr2;
            nbr2 *= 4;
            n.edge = (char *) malloc(nbr2 * sizeof(char));
        }
        i = 0;
        while(i < (nbr1 + nbr2)){
            fscanf(f,"%c",&c);
            if((int) c >=65 && (int) c <= 90){
                if(i < nbr1){
                    n.vertex[i] = c;
                    i++;
                }
                else{
                if(n.type == oriented){
                    j = i - nbr1;
                    n.edge[j] = c;
                    i++;
                }
                else{
                    if((i - nbr1) % 2 != 0){
                        j = i - nbr1;
                        n.edge[j] = c;
                        n.edge[j + 1] = n.edge[j];
                        n.edge[j + 2] = n.edge[j - 1] ;
                        i = i + 3;
                    }
                else{
                    j = i - nbr1;
                    n.edge[j] = c;
                    i++;
                }

                }

                }
            }

        }
        n.cost = (int *) malloc(n.nbrEdge * sizeof(int));
        i = 0;
        while (i < n.nbrEdge){
            fscanf(f,"%d",&nbr);
            if (n.type == oriented){
              n.cost[i] = nbr;
              i++;
            }
            else{
                n.cost[i] = nbr;
                n.cost[i + 1] = nbr;
                i += 2;
            }

        }
        int cp = 0;
        while( (c = fgetc(f)) != EOF){
            if ((int) c >= 65 && (int) c <= 90){
                if (cp == 0){
                     n.start = c;
                     cp++;
                }
                else{
                     n.end = c;
                }

            }
        }
        fclose(f);
        return n;
    }
}
