#!/bin/bash

# Atualizar pacotes e instalar Java
sudo apt-get update
sudo apt-get install -y openjdk-11-jdk

# Certifique-se de que você está na versão correta do Java
java -version
