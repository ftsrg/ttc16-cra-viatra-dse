#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"
cd hu.bme.mit.viatra.ttc.dse
java -cp "target/hu.bme.mit.viatra.ttc.dse-0.0.1-SNAPSHOT.jar:target/lib/*" hu.bme.mit.viatra.ttc.dse.DseSolverMain $@
