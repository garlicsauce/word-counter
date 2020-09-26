# Word counter application

## Table of Contents
1. [**Overview**](#Overview)
2. [**Prerequisites**](#Prerequisites)
3. [**Quick start**](#QuickStart)
4. [**Build with**](#BuiltWith)

## Overview <a name="Overview"></a>

This repository contains demo application for counting words from a file.

## Prerequisites <a name="Prerequisites"></a>

Here are some conventions that I made:
* input file has to contain text
* input file has to be provided as an argument

## Quick start <a name="QuickStart"></a>

### Running application

To run application you can:
* use maven - `mvn spring-boot:run -Dspring-boot.run.arguments=src/main/resources/input2.txt` (feel free to provide your own input file)
* use IDE - main method is located in WordCounterApplication class

### Running tests

All tests were written in Spock. POM file was configured to compile & run groovy tests. 
To invoke them use: `./mvn clean test`

## Built with <a name="BuiltWith"></a>

* [Java 12](https://jdk.java.net/12/)
* [Maven](https://maven.apache.org/) - dependency management & build tool 
* [Spring boot](https://spring.io/projects/spring-boot) - to have a context ;)
* [Spock](http://spockframework.org/) - for beautiful tests
