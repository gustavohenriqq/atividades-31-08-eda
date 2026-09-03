@echo off
title Atividade 31-08 - Java
set "JAVA_HOME=C:\Users\Dell\Downloads\Java\jdk8"
cd /d "%~dp0"

echo Compilando Exercicios.java ...
"%JAVA_HOME%\bin\javac.exe" Exercicios.java
if errorlevel 1 (
    echo.
    echo *** Erro na compilacao. Veja as mensagens acima. ***
    pause
    exit /b
)

echo Compilado com sucesso! Iniciando o programa...
echo.
"%JAVA_HOME%\bin\java.exe" Exercicios

echo.
pause
