#!/usr/bin/env bash
CLASSPATH="${CLASSPATH}:/home/fl118890/Workspace/Oracle/products/14.1.1.0.0-basedir/wlserver/modules/clients/com.oracle.webservices.wls.jaxws-wlswss-client.jar"
CLASSPATH="${CLASSPATH}:/home/fl118890/Workspace/Oracle/products/14.1.1.0.0/oracle_common/modules/com.oracle.webservices.wls.wls-soap-stack-impl.jar"

export CLASSPATH
java "$@" \
    -Djavax.net.ssl.trustStorePassword=changeit \
    -Djavax.net.ssl.trustStore=/home/fl118890/Workspace/code/ws-security-poc/keystore.jks \
    -Djava.util.logging.config.file=logging.properties \
    -XshowSettings:all \
    -classpath "${CLASSPATH}:target/ws-security-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar" fl.poc.App
