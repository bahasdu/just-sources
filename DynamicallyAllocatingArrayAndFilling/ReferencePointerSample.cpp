#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <cstdio>

using namespace std;

class Point {
public:
    // Define "accessor" functions as
    //  reference types.
    unsigned& x();
    unsigned& y();
    void print();
private:
    unsigned obj_x;
    unsigned obj_y;
};

void Point::print() {
    printf("%p\n", &obj_x);
}

unsigned& Point::x() {
    return obj_x;
}

unsigned& Point::y() {
    return obj_y;
}

int main() {
    Point ThePoint;
    // Use x() and y() as l-values.
    ThePoint.x() = 7;
    ThePoint.y() = 9;
    ThePoint.print();
    // Use x() and y() as r-values.
    cout << "x = " << ThePoint.x() << "\n"
            << "y = " << ThePoint.y() << "\n";
}
