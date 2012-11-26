//---------------------------------------------------------------------------
#include <iostream>
using namespace std;

double & GetWeeklyHours() {
    double h = 46.50;
    double &hours = h;
    return hours;
}
//---------------------------------------------------------------------------

int checkPointer() {
    double hours = GetWeeklyHours();

    cout << "Weekly Hours: " << GetWeeklyHours() << endl;
    hours = 10;
    cout << "Weekly Hours: " << GetWeeklyHours() << endl;

    return 0;
}