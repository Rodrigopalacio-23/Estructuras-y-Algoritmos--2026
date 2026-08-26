#!/usr/bin/env bash
set -euo pipefail

# Build (skip tests by default for speed)
mvn -B -DskipTests package

JAR=target/estructuras-algoritmos-0.1.0-SNAPSHOT.jar
if [ ! -f "$JAR" ]; then
  echo "Jar not found: $JAR"
  exit 1
fi

java -jar "$JAR"
