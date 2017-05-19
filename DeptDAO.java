package day15_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;

public class DeptDAO {
	
	public void deptUpdate(int deptNo, String deptName){
		Connection conn = DBUtil.getConnect();
		PreparedStatement st = null;
		String sql = "update departments set department_name = ? where department_id = ?";
		ResultSet rs = null;
		int count = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, deptName);
			st.setInt(2, deptNo);
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(deptNo + "번이 " + count + "갱신 되었습니다.");
			DBUtil.dbclose(conn, st, rs);
		}
	}
	public void deptInsert(int deptNo, String deptName){
		Connection conn = DBUtil.getConnect();
		PreparedStatement st = null;
		String sql = "insert into departments(department_id, department_name) values(?, ?)";
		ResultSet rs = null;
		int count = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptNo);
			st.setString(2, deptName);
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(deptNo + "번이 " + count + "추가 되었습니다.");
			DBUtil.dbclose(conn, st, rs);
		}
	}
	public void deptDelete(int deptNo){
		Connection conn = DBUtil.getConnect();
		PreparedStatement st = null;
		String sql = "delete from departments where department_id = ?";
		ResultSet rs = null;
		int count = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptNo);
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(deptNo + "번 " + count + "건이 삭제되었습니다.");
			DBUtil.dbclose(conn, st, rs);
		}
	}
	
	public List<DeptDTO> deptSelectAll(){
		Connection conn = DBUtil.getConnect();
		PreparedStatement st = null;
		String sql = "select * from departments";
		ResultSet rs = null;
		List<DeptDTO> deptList = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				deptList.add(makeDept(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbclose(conn, st, rs);
		}
		return deptList;
	}
	private DeptDTO makeDept(ResultSet rs) throws SQLException{
		int department_id = rs.getInt(1);
		String department_name = rs.getString(2);
		int manager_id = rs.getInt(3);
		int location_id = rs.getInt(4);
		DeptDTO dept = new DeptDTO(department_id, department_name, manager_id, location_id);
		return dept;
	}
}
