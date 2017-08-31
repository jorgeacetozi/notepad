#!/bin/bash
set -e

SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-dev}

# Start notepad application with specific JVM_ARGS and SPRING_PROFILE
java ${JVM_ARGS} -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} ${NOTEPAD_HOME}/notepad.jar
