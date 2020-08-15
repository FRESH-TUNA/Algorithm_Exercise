#!/bin/bash

numbers=();
result=();
yosepuse_value=0;

init() {
  for ((i=1; i<=$1; ++i))
  do
    numbers+=($i)
  done
  yosepuse_value=$2
}

head() {
  echo ${numbers[0]};
}

pop() {
  value=${numbers[0]}
  numbers=("${numbers[@]:1}")
}

enqueue() {
  numbers+=($1)
}

nthMinusOnePopAndEnqueue() {
  for ((i=1; i < $yosepuse_value; i++))
  do
    head_value=$(head);
    pop;
    enqueue $head_value;
  done
}

append_to_result() {
  head_value=$(head);
  pop;
  result+=($head_value);
}

print_result() {
  echo ${result[@]};
}

call() {
  while [ ${#numbers[@]} -gt 1 ]
  do
    nthMinusOnePopAndEnqueue;
    append_to_result;
  done

  append_to_result;
  print_result;
}

init $@;
call;
