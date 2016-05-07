#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"
cd hu.bme.mit.viatra.ttc.dse

java -Dorg.eclipse.emf.common.util.ReferenceClearingQueue=false -cp "target/hu.bme.mit.viatra.ttc.dse-0.0.1-SNAPSHOT.jar:target/lib/*" hu.bme.mit.viatra.ttc.dse.DseSolverMain $@ | tee results.log
