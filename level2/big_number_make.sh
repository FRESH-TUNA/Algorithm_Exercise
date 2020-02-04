#!/bin/sh

number=$0
k=$1

service() {
  max=number
  for x in k
    max = get_max(max)
  end	
}

get_max() {
 max=0
 for x in number.length:
  if int(number[0:x] +number[x+1:]) > max
    max = number[0:x] +number[x+1:]
  fi		
 end
}



