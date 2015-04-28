#!/bin/bash

set -e -u

if [ $# -eq 0 ]
then
    ./gradlew tasks
else
    ./gradlew $1
fi