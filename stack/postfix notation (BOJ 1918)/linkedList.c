#include "stdlib.h"
#include "linkedList.h"
#include "node.h"
#include "type.h"

struct __LinkedList {
  Node *head;  
};

LinkedList* LinkedList__create() {
  LinkedList *list = malloc(sizeof(LinkedList));
  list -> head = NULL;
  return list;
}

void LinkedList__free(LinkedList *list) {
  Node *head = list -> head;
  Node *wish_to_destory = NULL;
  
  while(head != NULL) {
    wish_to_destory = head;
    head = Node__get_next(head);
    free(wish_to_destory);
  }
  free(list);
}

void LinkedList__push(LinkedList *list, Type object) {
  Node *new_node = Node__create(object);
  Node__set_next(new_node, list -> head);
  list -> head = new_node;
}

Type LinkedList__pop(LinkedList *list) {
  Node *poped_node = list -> head;
  Type value = Node__get_value(poped_node);
  list -> head = Node__get_next(list -> head);
  Node__freeNode(poped_node);
  return value;  
}

Type LinkedList__head(LinkedList *list) {
  if(list -> head != NULL) 
    return Node__get_value(list -> head);
  else 
    return NULL;
}
