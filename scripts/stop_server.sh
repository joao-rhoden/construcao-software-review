#!/bin/bash

# Encontre o PID da aplicação Java e mate o processo
pid=$(pgrep -f 'java -jar my-application.jar')
if [ -n "$pid" ]; then
    kill $pid
fi
