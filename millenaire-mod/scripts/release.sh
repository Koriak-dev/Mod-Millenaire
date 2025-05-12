#!/bin/bash

# Script to automate the release process

VERSION=$(cat gradle.properties | grep mod_version | cut -d'=' -f2)
echo "Preparing release v$VERSION"

# Build the mod
./gradlew build

# Create release package
mkdir -p release
cp build/libs/*.jar release/

echo "Release v$VERSION is ready in the release/ directory"
