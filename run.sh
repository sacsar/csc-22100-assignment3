#!/usr/bin/env bash

./gradlew cli:build

java -jar ./cli/build/libs/cli.jar