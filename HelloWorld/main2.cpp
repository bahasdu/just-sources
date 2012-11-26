#include <iostream>
#include <cstdlib>

using namespace std;

void find_first_greater_than(int*& ptr, int threshold) {

    while (*ptr <= threshold) {
        ptr++;
    }
}

int main2(int argc, char* argv[]) {

    int exam_scores[] = {74, 94, 64, 77, 68,
                         99, 58, 89, 74, 88,
                         100, 95, 71, 81, 89,
                         54, 76, 83, 88, 67};

    int* score = &exam_scores[0];

    cout << *score << endl;
    find_first_greater_than(score, 99);
    cout << *score << endl;

    return EXIT_SUCCESS;
}