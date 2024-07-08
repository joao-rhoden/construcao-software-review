#!/bin/bash

# Defina o diretório onde o JAR está localizado
APP_DIR="/home/ubuntu/my-spring-boot-app"
JAR_FILE="my-application.jar"

# Mude para o diretório da aplicação
cd $APP_DIR

# Inicie a aplicação em segundo plano e redirecione a saída para /dev/null
nohup java -jar $JAR_FILE > /dev/null 2>&1 &
