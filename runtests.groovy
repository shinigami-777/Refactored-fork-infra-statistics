#!/usr/bin/env groovy
@Grab('org.junit.platform:junit-platform-console-standalone:1.8.2')

import org.junit.platform.console.ConsoleLauncher

ConsoleLauncher.main(
        "--classpath", "out",
        "--scan-classpath",
        "--include-classname", ".*Test"
)
