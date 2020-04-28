#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "linkedList.h"
#define MAX_LENGTH 100

LinkedList *list;
char line[MAX_LENGTH + 1];

void init() {
  list = LinkedList__create();
}

void input() {
  gets(line);
}

bool is_left_bracket(char character) {
  return character == '(';
}

bool is_right_bracket(char character) {
  return character == ')';
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

int priority(char operator) {
  if(operator == '(')
    return 1;
  else if(operator == '+' || operator == '-')
    return 2;
  else if(operator == '*' || operator == '/')
    return 3;
  else
    return 4;
}

void call() {
  for(int i = 0; i < strlen(line); ++i) {
    if(is_left_bracket(line[i]))
      LinkedList__push(list, line[i]);
    else if(is_right_bracket(line[i])) {
      while(!is_left_bracket(LinkedList__head(list)))
        putchar(LinkedList__pop(list));
      LinkedList__pop(list);
    } 
    else if(is_operator(line[i])) {
      while(LinkedList__head(list) != NULL && priority(LinkedList__head(list)) >= priority(line[i]))
        putchar(LinkedList__pop(list));
      LinkedList__push(list, line[i]);
    }
    else 
       putchar(line[i]);
  }
  while(LinkedList__head(list) != NULL) 
    putchar(LinkedList__pop(list));
  LinkedList__free(list);
}

int main() {
  init();
  input();
  call();
  return 0;
}
