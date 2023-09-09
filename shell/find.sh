#!/bin/bash
read -p "read find String:" find_String
read -p "read find file path:" find_file
read -p "result in file path:" result_path
grep -n "$find_String" "$find_file" > "$result_path"
cat "$result_path"
