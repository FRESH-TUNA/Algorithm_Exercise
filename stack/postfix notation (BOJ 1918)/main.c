#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "node.h"
#define MAX_LENGTH 100

Node *tree_head;
char line[MAX_LENGTH + 1];

void init() {
  tree_head = Node__create(0);
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

bool is_higher_priority(char character) {
  
}

void call() {
  for(int i = 0; i < strlen(line); ++i) {
    if(is_left_bracket(line[i])) {
      
    }
    else if (is_right_bracket(line[i])) {

    } 
    else if(is_operator(line[i])) {

    } 
    else {

    }
  }
}

int main() {
  init();
  input();
  return 0;
}
