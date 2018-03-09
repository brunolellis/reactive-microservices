gatling-maven-plugin-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

To test it out, simply execute the following command:

    $ mvn gatling:test -Dgatling.simulationClass=simulation.PaymentLoadSimulation

or simply:

    $ mvn gatling:test

To change the number of concurrent users:
    $ mvn -DSIM_USERS=100 gatling:test
