#!/bin/bash

numbers=($@)
min_index=0
temp_for_swap=0

for ((i=0; i<${#numbers[@]}; i++))
do
  min_index=i
  for((j=i+1; j<${#numbers[@]}; j++))
  do
    if [ ${numbers[$min_index]} -gt ${numbers[j]} ] 
    then
      min_index=${numbers[j]}
    fi
  done

  #swap
  temp_for_swap=${numbers[i]}
  numbers[i]=${numbers[$min_index]}
  numbers[$min_index]=$temp_for_swap
done

echo ${numbers[@]}
