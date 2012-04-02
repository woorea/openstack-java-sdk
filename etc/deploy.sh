#!/bin/sh
mvn -Dmaven.test.skip=true -DaltDeploymentRepository=snapshots::default::file:///Users/woorea/dev/maven/snapshots deploy
