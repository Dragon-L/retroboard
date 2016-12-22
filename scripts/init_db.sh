#!/usr/bin/env bash

createuser retroboard_admin
#createuser retroboard_admin -P password   create user with password

#create database and assign owner
createdb -O retroboard_admin retroboard