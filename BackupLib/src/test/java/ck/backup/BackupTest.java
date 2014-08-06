package ck.backup;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BackupTest extends TestCase {

    public BackupTest(String testName) {
	super(testName);
    }

    public static Test suite() {
        return new TestSuite(BackupTest.class);
    }

    public void testBackup() {
		IBackup b = new BackupImp();
		

    }
	
	
}
