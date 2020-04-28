#ifndef __NODE_H
#define __NODE_H

#include "type.h"

typedef struct __Node Node;

Node* Node__create(Type object);
Type Node__get_value(Node *node);
Node* Node__get_next(Node *node);
void Node__set_next(Node *node, Node *next_node);
void Node__freeNode(Node *node);

#endif /* __NODE_H */