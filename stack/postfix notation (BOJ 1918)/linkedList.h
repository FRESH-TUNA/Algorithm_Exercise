#ifndef __LINKEDLIST_H
#define __LINKEDLIST_H

#include "type.h"

typedef struct __LinkedList LinkedList;

LinkedList* LinkedList__create();
void LinkedList__free(LinkedList *list);
void LinkedList__push(LinkedList *list, Type object);
Type LinkedList__pop(LinkedList *list);
Type LinkedList__head();

#endif /* __LINKEDLIST_H */
