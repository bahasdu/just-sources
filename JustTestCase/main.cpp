/* 
 * File:   main.cpp
 * Author: baha
 *
 * Created on October 23, 2012, 8:23 AM
 */

#include <cstdlib>
#include "iostream"
#include "string.h"
using namespace std;

/*
 * 
 */

void changeVariables(string &input, int& day, int& month, int& year, int& hour, int& minutes, int& seconds) {
    int first = 0;
    int second = input.find('/', 0);
    string current = "";
    for (int i = first; i < second; i++)
        current += input[i];
    day = atoi(current.c_str());


    first = (++second);
    current = "";
    second = input.find('/', second);
    for (int i = first; i < second; i++)
        current += input[i];
    month = atoi(current.c_str());


    first = (++second);
    second = input.find(' ', second);
    current = "";
    for (int i = first; i < second; i++)
        current += input[i];
    year = atoi(current.c_str());

    first = (++second);
    current = "";
    second = input.find(':', second);
    for (int i = first; i < second; i++)
        current += input[i];
    hour = atoi(current.c_str());

    first = (++second);
    current = "";
    second = input.find(':', second);
    for (int i = first; i < second; i++)
        current += input[i];
    minutes = atoi(current.c_str());
    seconds = atoi(input.substr(++second, input.length() - 1).c_str());
}

int main2(int argc, char** argv) {
    //mm/dd/yyyy hh:nn:ss
    string input = "14/6/1991 12:13:44";
    int month = -1;
    int day = -1;
    int year = -1;
    int hour = -1;
    int minutes = -1;
    int seconds = -1;

    changeVariables(input, day, month, year, hour, minutes, seconds);

    return 0;
}


