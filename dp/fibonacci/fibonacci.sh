#!/bin/bash

memory=(0 1 1)

fibonachi() {
  wish=$1

  if [ ${memory[$wish]} ]
  then
    echo ${memory[$wish]}
  else
    memory[$wish]=$(($(fibonachi $((wish-1)))+$(fibonachi $((wish-2)))))
    echo ${memory[$wish]}
  fi
}

service() {
  wish=$1

  if [ $wish -le 2 ]
  then
    echo ${memory[$wish]}
  else
    echo $(fibonachi $wish)
  fi
}

service $1