#!/bin/bash

set -e

if [[ ! $BUILD_SERVER ]]; then
    VBoxManage -v >/dev/null 2>&1 || { echo >&2 "VirtualBox is required. Please install the latest version."; exit 1; }
    vagrant -v >/dev/null 2>&1 || { echo >&2 "Vagrant is required. Please install the latest version."; exit 1; }
    chef -v >/dev/null 2>&1 || { echo >&2 "Chef Development Kit is required. Please install the latest version."; exit 1; }
fi

if [ $# -eq 0 ]
then
    ./gradlew tasks
else
    ./gradlew $1
fi