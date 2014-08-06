package ck.db;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectTest extends TestCase {

    public DBConnectTest(String testName) {
	super(testName);
    }

    public static Test suite() {
        return new TestSuite(DBConnectTest.class);
    }

    public void testDBConnect() {
	DBConnect db = new DBConnect();
	db.open();
	ResultSet rs = db.query("select * from src_table");
	try {
	    assertTrue(rs.next());
	    if (rs.next()) {
		System.out.println("[ck] the id is " + rs.getString("id"));
	    }
	} catch (SQLException e) {
	}
	db.close();
	assertTrue(true);
    }
}
