#!/usr/bin/env bash
if [ "$1" == "week1" ]
then
  if [ -e percolation.zip ]
  then
    rm percolation.zip
  fi

  zip percolation.zip src/week1/Percolation.java src/week1/PercolationStats.java
fi

if [ "$1" == "week2" ]
then
  if [ -e queues.zip ]
  then
    rm queues.zip
  fi

  zip queues.zip src/week2/Deque.java src/week2/RandomizedQueue.java src/week2/Permutation.java
fi
