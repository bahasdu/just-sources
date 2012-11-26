#ifndef _LINKEDLIST_H_
#define _LINKEDLIST_H_
#include "string.h"


using namespace std;

class EmptyListException : public logic_error {

public:
    EmptyListException(const string& what_arg ) throw() :
            logic_error ("Empty list exception: " + what_arg) {}}
;

template <typename T>
class Node {
private:
    T data;
    Node* next;

public:
    Node(T d, Node* n = NULL) : data(d), next(n) {}
    T& getData() {
        return data;
    }
    Node*& getNext() {
        return next;
    }

};

template <typename T>
class LinkedList {

protected:

    Node<T>* head;  // Beginning of list
    Node<T>* tail;  // End of list
    int count;    // Number of nodes in list

public:

    LinkedList(void) : head(NULL), tail(NULL), count(0) {}
    LinkedList(const LinkedList<T>& src);  // Copy constructor
    virtual ~LinkedList(void);  // Destructor

    virtual T& front(void) {

        if (head == NULL) {
            throw EmptyListException("front()");
        }
        return head->getData();
    }
    virtual T& back(void) {
        if (tail == NULL) {
            throw EmptyListException("back()");
        }
        return tail->getData();
    }
    virtual int size(void) {
        return count;
    }
    virtual bool empty(void) {
        return count == 0;
    }

    virtual void push_front(T);  // Insert element at beginning
    virtual void push_back(T);   // Insert element at end
    virtual void pop_front(void);  // Remove element from beginning
    virtual void pop_back(void);  // Remove element from end

    virtual void dump(void);  // Output contents of list
};

// Copy constructor
template <typename T>
LinkedList<T>::LinkedList(const LinkedList<T>& src) :
        head(NULL), tail(NULL), count(0) {

    Node<T>* current = src.head;
    while (current != NULL) {
        this->push_back(current->getData());
        current = current->getNext();
    }

}

// Destructor
template <typename T>
LinkedList<T>::~LinkedList(void) {

    while (!this->empty()) {
        this->pop_front();
    }
}

// Insert an element at the beginning
template <typename T>
void LinkedList<T>::push_front(T d) {

    Node<T>* new_head = new Node<T>(d, this->head);

    if (this->empty()) {
        this->head = new_head;
        this->tail = new_head;
    } else {
        this->head = new_head;
    }
    this->count++;
}

// Insert an element at the end
template <typename T>
void LinkedList<T>::push_back(T d) {

    Node<T>* new_tail = new Node<T>(d, NULL);

    if (this->empty()) {
        this->head = new_tail;
    } else {
        this->tail->getNext() = new_tail;
    }

    this->tail = new_tail;
    this->count++;
}

// Remove an element from the beginning
template <typename T>
void LinkedList<T>::pop_front(void) {

    if (this->head == NULL) {
        throw EmptyListException("pop_front()");
    }

    Node<T>* old_head = head;

    if (this->size() == 1) {
        this->head = NULL;
        this->tail = NULL;
    } else {
        this->head = this->head->getNext();
    }

    delete old_head;
    this->count--;
}

// Remove an element from the end
template <typename T>
void LinkedList<T>::pop_back(void) {

    if (this->tail == NULL) {
        throw EmptyListException("pop_back()");
    }

    Node<T>* old_tail = this->tail;

    if (this->size() == 1) {
        this->head = NULL;
        this->tail = NULL;
    } else {

        // Traverse the list
        Node<T>* current = this->head;
        while (current->getNext() != this->tail) {
            current = current->getNext();
        }

        // Unlink and reposition
        current->getNext() = NULL;
        this->tail = current;
    }

    delete old_tail;
    this->count--;
}

// Display the contents of the list
template <typename T>
void LinkedList<T>::dump(void) {

    cout << "(";

    if (this->head != NULL) {
        Node<T>* current = this->head;
        while (current->getNext() != NULL) {
            cout << current->getData() << ", ";
            current = current->getNext();
        }
        cout << current->getData();
    }

    cout << ")" << endl;
}

#endif
