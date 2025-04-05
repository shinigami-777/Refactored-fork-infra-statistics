#!/usr/bin/env groovy
@Grab('org.junit.jupiter:junit-jupiter-api:5.7.2')
@Grab('org.junit.jupiter:junit-jupiter-engine:5.7.2')
@Grab('org.junit.platform:junit-platform-console-standalone:1.8.2')
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.5.2')

import org.junit.jupiter.api.*
import static org.junit.jupiter.api.Assertions.*

class ExampleTest {

    @Test
    void exampletest() {
        def examplstring = "testing..."

        assertNotNull(examplstring)
        assertEquals(examplstring, "testing...")
    }
}
