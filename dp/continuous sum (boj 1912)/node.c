#include "node.h"
#include <stdio.h>
#include <stdlib.h>

struct __Node {
  Type object;
  Node *next;
};

Node* Node__create(Type object) {
  Node *newNode = malloc(sizeof(Node));
  newNode -> object = object;
  newNode -> next = NULL;
  return newNode;  
}

Node* Node__get_next(Node *node) {
  return node -> next;
}

void Node__set_next(Node *node, Node *next_node) {
  node -> next = next_node;
}

void Node__freeNode(Node *node) {
  if (node != NULL && node -> next == NULL)
    free(node);
}

Type Node__get_value(Node *node) {
  return node -> object;
}
