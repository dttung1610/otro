package javabaitailon;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class QuanLySinhVien {
	ArrayList<SinhVien> dsSV;
	SinhVien sv;
	public QuanLySinhVien() {
		dsSV= new ArrayList<SinhVien>();
		sv= new SinhVien();
	}
	@SuppressWarnings("static-access")
	public ArrayList<SinhVien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from sinhvien";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String MSSV=rs.getString(1);
				String hoTen=rs.getString(2);
				String ngaySinh=rs.getString(3);
				String gioiTinh=rs.getString(4);
				String queQuan=rs.getString(5);
				String CNganh=rs.getString(6);
				String lop=rs.getString(7);
				SinhVien sv=new SinhVien(MSSV, hoTen, ngaySinh, gioiTinh, queQuan, CNganh, lop);
					dsSV.add(sv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSV;
	}
	@SuppressWarnings("static-access")
	public boolean create(String mSSV, String hoTen, String ngaySinh,Object gioitinh, String queQuan, String cNganh,String lop) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into SinhVien values(?,?,?,?,?,?,?)");
			stmt.setString(1, mSSV);
			stmt.setString(2, hoTen);
			stmt.setString(3, ngaySinh);
			stmt.setString(4, (String) gioitinh);
			stmt.setString(5, queQuan);
			stmt.setString(6, cNganh);
			stmt.setString(7, lop);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	@SuppressWarnings("static-access")
	public boolean update(String mSSV, String hoTen, String ngaySinh, Object gioitinh, String queQuan, String cNganh,String lop) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt=con.prepareStatement("update SinhVien"
					+ "set hoTen=?"
					+ "set ngaySinh=?" 
					+ "set gioiTinh=?"
					+ "set queQuan=?"
					+ "set cNganh=?"
					+ "set lop=?" 
					+ "where mssv=?");
			//stmt.setString(1, mSSV);
			stmt.setString(1, hoTen);
			stmt.setString(2, ngaySinh);
			stmt.setString(3, (String) gioitinh);
			stmt.setString(4, queQuan);
			stmt.setString(5, cNganh);
			stmt.setString(6, lop);
			stmt.setString(7, mSSV);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	@SuppressWarnings("static-access")
	public boolean delete(String mSSV) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from SinhVien where MSSV=?");
			statement.setString(1, mSSV);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
}
