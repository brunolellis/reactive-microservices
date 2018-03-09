#!/bin/bash

function runtest {
    mvn -DSIM_USERS=$1 gatling:test
    cp -rf target/gatling/* charts
    rm -rf target
    sleep 5
}

#runtest 1000
#runtest 1000
#runtest 1000

#sleep 10

#runtest 5000
runtest 5000
runtest 5000


