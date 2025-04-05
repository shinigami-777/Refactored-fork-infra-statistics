#!/usr/bin/env groovy
GrabConfig(systemClassLoader=true)
@Grab('org.xerial:sqlite-jdbc:3.16.1')
import org.sqlite.*
import org.junit.jupiter.api.*

class DBhelperTest {

    File tempDir
    @BeforeEach
    void setUp() {
        def tempDir = File.createTempDir()
        println "Temp directory created at: ${tempDir.absolutePath}"
    }

    @AfterEach
    void tearDown() {
        if(tempDir){
            tempDir.deleteDir()
            println "Temp directory deleted."
        }
    }

    @Test
    void testDoImportHandlesNullDb() {
        def mockDb = [
                rows: { String sql ->
                    return [[name: "file123.json.gz"]]
                }
        ]
        def result = DBHelper.doImport(mockDb, "file123.json.gz")
        assert !result : "Should return false when the file is already imported"
    }
}
