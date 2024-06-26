#!/usr/bin/env bash
CLASSPATH="${CLASSPATH}:${ORACLE_HOME}/wlserver/modules/clients/com.oracle.webservices.wls.jaxws-wlswss-client.jar"
CLASSPATH="${CLASSPATH}:${ORACLE_HOME}/oracle_common/modules/com.oracle.webservices.wls.wls-soap-stack-impl.jar"

export CLASSPATH
java "$@" \
    -Djavax.net.ssl.trustStorePassword=changeit \
    -Djavax.net.ssl.trustStore=keystore.jks \
    -Djava.util.logging.config.file=logging.properties \
    -XshowSettings:all \
    -classpath "${CLASSPATH}:target/ws-security-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar" fl.poc.App
