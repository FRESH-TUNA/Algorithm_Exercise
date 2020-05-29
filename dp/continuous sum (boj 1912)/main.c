#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_LENGTH 100000

int amount_of_number;
short numbers[MAX_LENGTH + 1];
int sub_answer[MAX_LENGTH + 1];
int answer;

void input() {
  scanf("%d", &amount_of_number);
  for(int i = 1; i <= amount_of_number; ++i) 
    scanf("%d", numbers + i);
}

void calculate_sub_answer(int number) {
  if(number == 1) {
    sub_answer[1] = numbers[1];
    answer = sub_answer[1];
  }
  else if(sub_answer[number - 1] < 0) {
    sub_answer[number] = numbers[number];
    if(answer < sub_answer[number])
      answer = sub_answer[number];
  }
  else {
    sub_answer[number] = sub_answer[number - 1] + numbers[number];
    if(answer < sub_answer[number])
      answer = sub_answer[number];
  }
}

void call() {
  for(int i = 1; i <= amount_of_number; ++i) 
    calculate_sub_answer(i);
  printf("%d", answer);
}

int main() {
  input();
  call();
  return 0;
}
