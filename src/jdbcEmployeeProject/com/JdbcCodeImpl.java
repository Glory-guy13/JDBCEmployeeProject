package jdbcEmployeeProject.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCodeImpl  {



	public static boolean add(Employee e) {
		boolean f=false;
		try {
			Connection con = JdbcConnect.connect();
			String query = "insert into emptable (eid,ename,sal,phno) values (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, e.getEid());
			pst.setString(2, e.getEname());
			pst.setDouble(3, e.getSal());
			pst.setLong(4, e.getPhno());

			pst.executeUpdate();

			f=true;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return f;

	}

	public static void display_by_id(int id) {

		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable where eid = ? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet set  = pst.executeQuery();
			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSalary:\t"+set.getDouble(3)+"\nPhoneno:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void display_by_name(String name) {

		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable where ename = ? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			ResultSet set  = pst.executeQuery();
			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSalary:\t"+set.getDouble(3)+"\nPhone no:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void display_all() {
		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable ";

			Statement st = con.createStatement();


			ResultSet set = st.executeQuery(query);

			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSal:\t"+set.getDouble(3)+"\nPhno:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static boolean delete(int id) {
		boolean f = false;
		try {
			Connection con = JdbcConnect.connect();
			String query = "delete from emptable where eid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);

			pst.execute();
			f=true;
			System.out.println("Employee with id : "+id+" deleted successfully...!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static void sortAsPerName() {

		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable order by ename asc";
			PreparedStatement pst  = con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSal:\t"+set.getDouble(3)+"\nPhno:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sortAsPerSal() {
		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable order by sal asc";
			PreparedStatement pst  = con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSal:\t"+set.getDouble(3)+"\nPhno:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sortAsPerPhone() {
		try {
			Connection con = JdbcConnect.connect();
			String query = "select * from emptable order by phno asc";
			PreparedStatement pst  = con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while(set.next()) {
				System.out.println("Id:\t"+set.getInt(1)+"\nName:\t"+set.getString(2)+"\nSal:\t"+set.getDouble(3)+"\nPhno:\t"+set.getLong(4)+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void update_Name(String s,int id) {
		try {
			Connection con = JdbcConnect.connect();
			String query = "update emptable set ename = ? where eid = ?";
			PreparedStatement pst  = con.prepareStatement(query);
			pst.setString(1, s);
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Name update successfully....!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update_Sal(double s,int id) {
		try {
			Connection con = JdbcConnect.connect();
			String query = "update emptable set sal = ? where eid = ?";
			PreparedStatement pst  = con.prepareStatement(query);
			pst.setDouble(1, s);
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Salary update successfully....!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update_Phno(long s,int id) {
		try {
			Connection con = JdbcConnect.connect();
			String query = "update emptable set phno = ? where eid = ?";
			PreparedStatement pst  = con.prepareStatement(query);
			pst.setLong(1, s);
			pst.setInt(2, id);
			pst.execute();
			System.out.println("Phno update successfully....!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
