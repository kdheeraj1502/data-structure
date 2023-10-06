#!/bin/bash

# Set the parent folder path
parent_folder="/Users/dheeraj.kumar/Documents/data-structure/data-structure/out/production/data-structure"

# Check if the parent folder exists
if [ ! -d "$parent_folder" ]; then
    echo "Parent folder not found: $parent_folder"
    exit 1
fi

# Recursively find .class files and compile them
find "$parent_folder" -type f -name "*.class" -exec sh -c '
    class_file="$1"
    folder="$(dirname "$class_file")"
    filename_noext="${class_file%.class}"

    # Run Fernflower to decompile the .class file in the current folder
    java -jar "/Applications/IntelliJ IDEA CE.app/Contents/plugins/java-decompiler/lib/java-decompiler.jar" -dgs=true "$class_file" "$folder"

    echo "Decompiled $class_file to $folder/$filename_noext.java"
' sh {} \;
