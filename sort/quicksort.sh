#!/bin/bash

input() {
  numbers=($@)
}

swap() {
  first_index=$1
  second_index=$2

  temp_for_swap=${numbers[$first_index]}
  numbers[$first_index]=${numbers[$second_index]}
  numbers[$second_index]=$temp_for_swap
}

partition() {
  start=$1
  length=$2
  pivot_insert_pos=${start - 1}
  pivot_value=${numbers[$3]}

  for ((i=start; i<length; ++i))
  do
    if [ $pivot_value -ge ${numbers[i]} ]
    then
      pivot_insert_pos+=1
      swap $pivot_insert_pos $i
    fi
  done
}

quicksort() {
  start=$1
  length=$2
  pivot_index=${($start + $length) / 2}

  partition $start $length $pivot_index
  quicksort()
  quicksort()
    echo "foo1"
    foo2     
    quicksort  
}

input();
quicksort 0 ${#numbers[@]};