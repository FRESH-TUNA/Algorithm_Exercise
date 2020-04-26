#include "./node.h"
#include <stdio.h>
#include <stdlib.h>

struct __Node {
  Type object;
  Node *left;
  Node *right;
};


Node* Node__create(void *object) {
  Node *newNode = malloc(sizeof(Node));
  newNode -> object = object;
  newNode -> left = NULL;
  newNode -> right = NULL;
  return newNode;  
}

Node* Node__set_left(Node *newNode) {
  newNode -> left = newNode; 
  return newNode;
}

Node* Node__set_right(Node *newNode) {
  newNode -> right = newNode; 
  return newNode;
}

void Node__freeNode(Node *node) {
  if (node -> left != NULL)
    Node__freeNode(node -> left);
  if (node -> right != NULL)
    Node__freeNode(node -> right);
  free(node);
}