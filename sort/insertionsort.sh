#!/bin/bash

numbers=($@)
temp_for_swap=0

for ((i=1; i<${#numbers[@]}; i++))
do
  for((j=0; j<i; j++))
  do
    if [ ${numbers[i]} -lt ${numbers[j]} ] 
    then
      #swap
      temp_for_swap=${numbers[i]}
      numbers[i]=${numbers[j]}
      numbers[j]=$temp_for_swap
    fi
  done
done

echo ${numbers[@]}
