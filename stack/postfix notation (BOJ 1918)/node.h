#ifndef __NODE_H
#define __NODE_H

typedef struct __Node Node;
typedef char Type;

Node* Node__create(void *object);
Node* Node__set_left(Node *newNode);
Node* Node__set_right(Node *newNode);
void Node__freeNode(Node *node);

#endif /* __NODE_H */