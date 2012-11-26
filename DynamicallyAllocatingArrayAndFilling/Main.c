/* 
 * File:   Main.c
 * Author: baha
 *
 * Created on November 22, 2012, 6:41 PM
 */
#define ARRAY_SIZE 10

int resultArray[ARRAY_SIZE][ARRAY_SIZE];
int matrixAArray[ARRAY_SIZE][ARRAY_SIZE];
int matrixBArray[ARRAY_SIZE][ARRAY_SIZE];


#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <sys/timeb.h>

void makeZero(int *ptr) {
    int i = 0;
    for (i = 0; i < ARRAY_SIZE * ARRAY_SIZE; i++) {
        ptr[i] = 0;
    }
}

void fillRandomly(int *ptr) {
    int i = 0;
    for (i = 0; i < ARRAY_SIZE * ARRAY_SIZE; i++) {
        ptr[i] = rand() % 5 + 1;
    }
}

void printArray(int *ptr, int from, int to) {
    int i;
    for (i = from; i < to; i++) {
        int j;
        for (j = 0; j < ARRAY_SIZE; j++) {
            printf("%d ", ptr[ARRAY_SIZE * i + j]);
        }
        printf("\n");
    }
    printf("\n");
}

void calculateMatrix(int from, int to) {
    int i, j, k;
    for (i = from; i < to; i++) {
        for (j = 0; j < ARRAY_SIZE; j++) {
            resultArray[i][j] = 0;
            for (k = 0; k < ARRAY_SIZE; k++) {
                resultArray[i][j] += matrixAArray[i][k] * matrixBArray[k][j];
            }
        }
    }
}

void makeCopy(int *arraya, int *arrayb, int from, int to) {
    int i;

    for (i = from; i < to; i++) {
        int j;
        for (j = 0; j < ARRAY_SIZE; j++) {
            arrayb[ARRAY_SIZE * i + j] = arraya[ARRAY_SIZE * i + j];
        }
    }
}

int main2(int argc, char** argv) {
    srand(time(NULL));

    fillRandomly(matrixAArray);
    printf("matrix A:\n");
    printArray(matrixAArray, 0, ARRAY_SIZE);
    printf("matrix B:\n");
    printArray(matrixBArray, 0, ARRAY_SIZE);
    makeCopy(&matrixAArray, &matrixBArray, 0, 10);
    printf("after copy B:\n");
    printArray(matrixBArray, 0, ARRAY_SIZE);

    return (EXIT_SUCCESS);
}

