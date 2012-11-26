/* 
 * File:   SearchMain.c
 * Author: baha
 *
 * Created on November 24, 2012, 10:56 AM
 */

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <sys/timeb.h>

char letters[100];

void fillArray(char* letters) {
    int i = 0;
    for (i = 0; i < 100; i++) {
        char letter = rand() % 26 + 65;
        letters[i] = letter;
    }
}

void printData(char* data) {
    int i = 0;
    for (i = 0; i < 100; i++) {
        printf("id: [%d] value:[%c]\n", i, data[i]);
    }
}

void find(int rank, char value) {
    int i;
    for (i = 0; i < 100; i++) {
        if (letters[i] == value) {
            printf("rank:[%d] value: [%c] index: [%d]\n", rank, value, i);
        }
    }
}
int numbers[4] = {1, 2, 3, 4};

int getNumbers() {
    return &numbers;
}

char getChar() {
    return letters[rand() % 100 + 1];
}

int searchMain(int argc, char** argv) {
    int *ptr=getNumbers();
    ptr[1]=10;
    printf("finish\n");
}

