#!/bin/bash

# using wrk to measure throughput

# best throughput with spring-webflux (netty)
#wrk -t8 -c2000 --timeout 10 -d30s -s post.lua http://localhost:8080/payment
#Running 30s test @ http://localhost:8080/payment
#  8 threads and 2000 connections
#  Thread Stats   Avg      Stdev     Max   +/- Stdev
#    Latency   768.66ms    1.02s    9.07s    94.23%
#    Req/Sec   428.96    214.17     1.59k    68.39%
#  101885 requests in 30.10s, 17.49MB read
#Requests/sec:   3384.82
#Transfer/sec:    594.99KB
#
#
# best throughput with spring-web (tomcat)
#wrk -t12 -c2000 --timeout 10 -d30s -s post.lua http://localhost:8080/payment
#Running 30s test @ http://localhost:8080/payment
#  12 threads and 2000 connections
#  Thread Stats   Avg      Stdev     Max   +/- Stdev
#    Latency     1.95s   308.36ms   2.26s    91.38%
#    Req/Sec   175.41    212.91     1.10k    84.38%
#  29363 requests in 30.08s, 5.88MB read
#Requests/sec:    976.20
#Transfer/sec:    200.20KB
#
#
#


wrk -t8 -c2000 --timeout 10 -d30s -s post.lua http://localhost:8080/payment
