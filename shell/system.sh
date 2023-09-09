#!/bin/bash

df -h

free -h

top -bn1 | grep Cpu(s)
