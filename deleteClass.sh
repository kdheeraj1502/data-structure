#!/bin/bash

# Set the parent folder path
parent_folder="/Users/dheeraj.kumar/Documents/data-structure/data-structure/production/data-structure"

# Check if the parent folder exists
if [ ! -d "$parent_folder" ]; then
    echo "Parent folder not found: $parent_folder"
    exit 1
fi

# Recursively find and delete .class files in subfolders
find "$parent_folder" -type f -name "*.class" -exec rm -f {} \;

echo "Deleted .class files in $parent_folder and its subfolders."
