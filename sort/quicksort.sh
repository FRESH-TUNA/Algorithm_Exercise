#!/bin/bash

# global variable
numbers=()

input() {
  numbers=($@)
}

print() {
  echo ${numbers[@]}
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

  pivot_insert_pos+=1
  swap $pivot_insert_pos $i
  echo $pivot_insert_pos
}

quicksort() {
  start=$1
  end=$2

  if [ $start -eq ${$end-1} ]
  then
    pivot_index=$(partition $start $length ${($start + $length) / 2})
    quicksort $start ${pivot_index+1}
    quicksort ${pivot_index+1} $length
  fi
}

input $@
quicksort 0 ${#numbers[@]};
echo ${numbers[@]}
