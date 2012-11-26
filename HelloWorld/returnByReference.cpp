#include <iostream>
#include <stdlib.h>
using namespace std;
class Person {
private:
    string name;
    int age;
public:
    Person():name(""),age(0){}
    void set_age(int age){this->age=age;}
    int get_age(){return age;}
    void set_name(string name){this->name=name;}
    string get_name(){return name;}
    char &replace_letter(int i){
        return name[i];
    }
};
int main(){
    Person person;
    person.set_name("John Doe");
    person.set_age(30);
    
    return EXIT_SUCCESS;
}