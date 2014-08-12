package ck.backup;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.ArrayList;

public class BackupTest extends TestCase {

	public BackupTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BackupTest.class);
	}

	public void testSearchSrc() {
		List<SrcTable> a1 = Backup.searchSrc(null);
		assertTrue(a1.size() == 6);

		ArrayList<String> c2 = new ArrayList<String>();
		List<SrcTable> a2 = Backup.searchSrc(c2.iterator());
		assertTrue(a2.size() == 6);

		c2.add("text like '%ngl%'");
		a2 = Backup.searchSrc(c2.iterator());
		assertTrue(a2.size() == 2);

		c2.add("id != '01'");
		a2 = Backup.searchSrc(c2.iterator());
		Assert.assertEquals("02", a2.get(0).getId());
		assertTrue(a2.size() == 1);
	}

	public void testSearchDes() {
		List<DesTable> a1 = Backup.searchDes(null);
		assertTrue(a1.size() == 0);

		ArrayList<String> c2 = new ArrayList<String>();
		List<DesTable> a2 = Backup.searchDes(c2.iterator());
		assertTrue(a2.size() == 0);
	}
}
