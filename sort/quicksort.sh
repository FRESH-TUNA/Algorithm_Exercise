#!/bin/bash

# global variable
numbers=()
partition_pos=-1

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
  start=$1;
  end=$2;
  partition_pos=$((start - 1))
  pivot_value=${numbers[$end]};

  for ((i=start; i<=end - 1; ++i))
  do
    if [ $pivot_value -gt ${numbers[i]} ];
    then
      ((partition_pos+=1))
      swap $partition_pos $i
    fi
  done

  ((partition_pos+=1))
  swap $partition_pos $end
}

quicksort() {
  start=$1
  end=$2

  if [ $start -lt $end ]
  then
    partition $start $end 
    quicksort $start $((partition_pos-1))
    quicksort $((partition_pos+1)) $end
  fi
}

input $@
quicksort 0 $((${#numbers[@]} - 1));
print
