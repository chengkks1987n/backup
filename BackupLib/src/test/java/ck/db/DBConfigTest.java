package ck.db;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DBConfigTest extends TestCase {

    public DBConfigTest(String testName) {
	super(testName);
    }

    public static Test suite() {
        return new TestSuite(DBConfigTest.class);
    }

    public void testDBConfig() {
        assertTrue(DBConfig.getUsername().equalsIgnoreCase("ck"));
	assertTrue(DBConfig.getPassword().equalsIgnoreCase("123456"));
    }
}
