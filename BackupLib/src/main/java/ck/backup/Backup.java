package ck.backup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ck.db.DBConnect;

/**
 * apply the main functions of this library, such as backup, restore and search.
 * 
 * @author ck &lt chengkechengke@gmail.com &gt
 * @version 2014-08-06
 */
public class Backup {
	public static boolean backup(String key, String remark) {

		return true;
	}

	public static boolean restore(String key) {
		return true;
	}

	/**
	 * search records in table src_table.
	 * 
	 * @param conditions
	 *            the conditions in SQL where part.
	 * @return records in the table src_table. if the conditions is null or the size of
	 *         conditions is zero, return all records; otherwise return the
	 *         records according the conditions.
	 */
	public static List<SrcTable> searchSrc(Iterator<String> conditions) {
		DBConnect db = new DBConnect();
		db.open();
		ResultSet rs = db.query(constructSql(conditions, "src_table"));
		ArrayList<SrcTable> ans = new ArrayList<SrcTable>();
		try {
			while (rs.next()) {
				SrcTable a = new SrcTable();
				a.setId(rs.getString("id"));
				a.setText(rs.getString("text"));
				ans.add(a);
			}
		} catch (SQLException e) {
			System.out.println("cannot read the records in table src_table!");
			e.printStackTrace();
		}
		db.close();
		return ans;
	}

	/**
	 * 
	 * @param conditions
	 *            the conditions in SQL where part
	 * @return records in the table des_table. if the conditions is null or the size of
	 *         conditions is zero, return all records; otherwise return the
	 *         records according the conditions.
	 */
	public static List<DesTable> searchDes(Iterator<String> conditions) {
		DBConnect db = new DBConnect();
		db.open();
		ResultSet rs = db.query(constructSql(conditions, "des_table"));
		ArrayList<DesTable> ans = new ArrayList<DesTable>();
		try {
			while (rs.next()) {
				DesTable a = new DesTable();
				a.setId(rs.getString("id"));
				a.setText(rs.getString("text"));
				a.setTheTime(rs.getDate("the_time"));
				a.setRemark(rs.getString("remark"));
				ans.add(a);
			}
		} catch (SQLException e) {
			System.out.println("cannot read the records in table des_table!");
			e.printStackTrace();
		}
		db.close();
		return ans;
	}

	/**
	 * construct the SQL select language
	 * 
	 * @param conditions
	 *            the conditions in SQL where part.
	 * @param tablename
	 *            the table to be searched
	 * @return the SQL query string. f the conditions is null or the size of
	 *         conditions is zero, ignore the wher part.
	 */
	private static String constructSql(Iterator<String> conditions,
			String tablename) {
		StringBuilder sql = new StringBuilder("select * from " + tablename);
		if (conditions == null)
			return sql.toString();
		if (conditions.hasNext()) {
			sql.append(" where " + conditions.next());
		}
		while (conditions.hasNext()) {
			sql.append(" and " + conditions.next());
		}
		return sql.toString();
	}
}
