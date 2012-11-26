/* 
 * File:   main2.cpp
 * Author: baha
 *
 * Created on October 23, 2012, 9:23 PM
 * 
 */

#include <cstdlib>
#include <string>
#include <iostream>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
                  //012345     
    string input = "title\nemail\n412\nstart-date\nclose-date\nbody\n";
    int first = 0;
    int second = input.find('\n', first);

    string title = input.substr(first, second);
    cout << title << endl;

    first = second+1;
    second = input.find('\n', first);
    string email = input.substr(first, second - 1);
    cout << email << endl;

    first = second+1;
    second = input.find('\n', first);
    int quantity = atoi(input.substr(first, second - 1).c_str());

    first = second+1;
    second = input.find('\n', first);
    string date = input.substr(first, second - 1).c_str();

    cout << date << endl;

    return 0;
}

