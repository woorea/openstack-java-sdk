#!/bin/sh
mvn -Dmaven.test.skip=true -DaltDeploymentRepository=releases::default::file:///Users/woorea/dev/maven/releases deploy
