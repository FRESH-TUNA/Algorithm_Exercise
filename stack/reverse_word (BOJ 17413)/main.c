#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_LENGTH 100000

typedef struct _Deque {
  char *datas;
  int size;
  int front;
  int rear;
} Deque;

void Deque__init(Deque *deque, int size) {
  deque -> datas = malloc(sizeof(char) * (size + 1));
  deque -> front = -1;
  deque -> rear = -1;
  deque -> size = size;
}

bool Deque__is_empty(Deque *deque) {
  int front = deque -> front;
  int rear = deque -> rear;
  int size = deque -> size;

  return ( front == -1 ); 
}

bool Deque__is_full(Deque *deque) {
  int front = deque -> front;
  int rear = deque -> rear;
  int size = deque -> size;

  return (
    (front == 0 && rear == size - 1)
    || front == rear + 1
  ); 
}

void Deque__insert_front(Deque *deque, char new_value) {
  if (Deque__is_full(deque)) { 
    puts("overflow");
    return 1;
  } 
  
  if(deque -> front == -1) {
    deque -> front = 0;
    deque -> rear = 0;
  }
  else if (deque -> front == 0) 
    deque -> front = deque -> size - 1; 
  else
    --(deque -> front);
  deque -> datas[deque -> front] = new_value;
}

char Deque__delete_front(Deque *deque) {
  char front_value = deque -> datas[deque -> front];

  if (Deque__is_empty(deque)) { 
    puts("underflow");
    return 1;
  } 
  
  if(deque -> front == deque -> rear) {
    deque -> front = -1;
    deque -> rear = -1;
  }
  else if (deque -> front == deque -> size - 1) 
    deque -> front = 0; 
  else
    ++(deque -> front);
  return front_value;
}

char Deque__insert_rear(Deque *deque, char new_value) {
  if (Deque__is_full(deque)) { 
    puts("overflow");
    return 1;
  } 

  if(deque -> front == -1) {
    deque -> front = 0;
    deque -> rear = 0;
  }
  else if (deque -> rear == deque -> size - 1) 
    deque -> rear = 0; 
  else
    ++(deque -> rear);
  
  deque -> datas[deque -> rear] = new_value;
}

char Deque__delete_rear(Deque *deque) {
  if (Deque__is_empty(deque)) { 
    puts("underflow");
    return 1;
  } 

  char rear_value = deque -> datas[deque -> rear];
  if(deque -> front == deque -> rear) {
    deque -> front = -1;
    deque -> rear = -1;
  }
  else if (deque -> rear == 0) 
    deque -> rear = deque -> size - 1;
  else
    --(deque -> rear);
  return rear_value;
}

void Deque__destroy(Deque *stack){
  free(stack -> datas);
  free(stack);
}

typedef struct _ReverseService {   
  Deque deque;
  char *line;
  char *result;
  int last;
  int max_length;
} ReverseService;                

void ReverseService__init(ReverseService *service, char line[], int max_length) {
  service -> line = line;
  service -> max_length = max_length;
  service -> result = malloc(sizeof(char) * (strlen(line) + 1));
  service -> last = 0;
  Deque__init(&(service -> deque), max_length);
}

// void ReverseService__getNormalOrderWord(ReverseService *service) {
//   Deque *deque = &(service -> deque);
//   char *result = service -> result;
//   int last = service -> last;
//   char value;

//   while(!Deque__is_empty(deque)) 
//     result[last++] = Deque__delete_front(deque);

//   result[last] = '\0';
//   service -> last = last;
// }

void ReverseService__getReverseOrderWord(ReverseService *service) {
  Deque *deque = &(service -> deque);
  char *result = service -> result;
  int last = service -> last;

  while(!Deque__is_empty(deque)) {
    char value = Deque__delete_rear(deque);
    result[last++] = value;
  }

  result[last] = '\0';
  service -> last = last;
}

void ReverseService__call(ReverseService *service) {
  int findBracketFlag = 0;
  char *line = service -> line;
  char *result = service -> result;
  Deque *deque = &(service -> deque); 

  for(int i = 0; i < strlen(line); ++i) {
    if(line[i] == '<') {
      findBracketFlag = 1;
      ReverseService__getReverseOrderWord(service);
      Deque__insert_front(deque, '<');
    }
    else if(line[i] == '>') {
      findBracketFlag = 0;
      Deque__insert_front(deque, '>');
      ReverseService__getReverseOrderWord(service);
    }

    if(findBracketFlag == 1 && line[i] != '<') 
      Deque__insert_front(deque, line[i]);
    else if(findBracketFlag == 0) {
      if (line[i] == ' ') {
        Deque__insert_front(deque, ' ');
        ReverseService__getReverseOrderWord(service);
      }
      else if(line[i] != '<' && line[i] != '>')
        Deque__insert_rear(deque, line[i]);
    }
  }
  ReverseService__getReverseOrderWord(service);
  puts(result);
}

char line[MAX_LENGTH + 1];

main() {
  gets(line);
  call();
  return 0;
}

void call() {
  ReverseService service;
  ReverseService__init(&service, line, MAX_LENGTH);
  ReverseService__call(&service);
}
