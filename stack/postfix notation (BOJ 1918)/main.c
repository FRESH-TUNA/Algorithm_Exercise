#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_LENGTH 100

typedef struct _Deque {
  char *datas;
  int size;
  int front;
  int rear;
} Deque;

typedef struct _Tree {
  char *datas;
  int size;
  int front;
  int rear;
} Tree;

void init() {
  Deque__init(&answer, MAX_LENGTH + 1);
  Deque__init(&operators, MAX_LENGTH + 1);
}

void input() {
  gets(line);
}

bool is_operator(char character) {
  if(
    character == '+' 
    || character == '-'
    || character == '*'
    || character == '/'
  )
    return true;
  else 
    return false;
}

bool is_higher_priority(char character) {
  
}

void call() {
  for(int i = 0; i < strlen(line); ++i) {
    if(is_left_bracket(line[i]) && !Deque__is_empty(&operators)) 
      
    else if (is_right_bracket(line[i]) && !Deque__is_empty(&operators)) 
    else if (is_operator(line[i]) && is_higher_priority(line[i]))
      
    else if (is_operator(line[i]))

    else 
      
  }
}

int main() {
  init();
  input();
  return 0;
}
