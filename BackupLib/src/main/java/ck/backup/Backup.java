package ck.backup;
import java.util.Iterator;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import ck.db.*;

public class Backup {
	public static boolean backup(String key, String remark) {
		
		return true;
	}
	public static boolean restore(String key){
		return true;
	}
	
	public static Iterator<SrcTable> searchSrc(Iterator<String> conditions){			
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
		} catch(SQLException e) {
			System.out.println("cannot read the records in table src_table!"); 
			e.printStackTrace(); 			
		}
		db.close();	
		return ans.iterator();
	}
	
	public static Iterator<DesTable> searchDes(Iterator<String> conditions){
		return null;
	}
	
	private static String constructSql(Iterator<String> conditions, String tablename) {
		StringBuilder sql = new StringBuilder("select * from " + tablename);	
		if (conditions.hasNext()) {
			sql.append(" where "+conditions.next());
		}
		while (conditions.hasNext()) {
			sql.append(" and "+conditions.next());
		}	
		return sql.toString();
	}
}