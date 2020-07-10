#!/bin/bash

numbers=($@)

for ((i=0; i < ${#numbers[@]}; i++))
do
  for ((j=0; j < ${#numbers[@]}-i-1; j++))
  do
    if [ ${numbers[j]} -gt ${numbers[$((j+1))]} ]
    then
      temp=${numbers[j]}
      numbers[$j]=${numbers[$((j+1))]}
      numbers[$((j+1))]=$temp
    fi
  done
done 

echo ${numbers[@]}
