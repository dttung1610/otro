package javabaitailon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLyTro {
	ArrayList<NhaTro> dsNT;
	NhaTro nt;
	public QuanLyTro(){
		dsNT= new ArrayList<NhaTro>();
		nt= new NhaTro();
		
	}
	@SuppressWarnings("static-access")
	public ArrayList<NhaTro> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from  NHATRO";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String MANT=rs.getString(1);
				String TENCT=rs.getString(2);
				String DIACHI=rs.getString(3);
				String SDT=rs.getString(4);
				
				NhaTro nt=new NhaTro(MANT, TENCT, DIACHI, SDT);
					dsNT.add(nt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNT;
	}
	@SuppressWarnings("static-access")
	public boolean create(String MANT, String TENCT, String DIACHI, String SDT) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into NhaTro values(?,?,?,?)");
			stmt.setString(1, MANT);
			stmt.setString(2, TENCT);
			stmt.setString(3, DIACHI);
			stmt.setString(4, SDT);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public NhaTro timKiemtheodiachi(String DIACHI) {
		NhaTro nt = new NhaTro(DIACHI);
		if(dsNT.contains(nt))
			return dsNT.get(dsNT.indexOf(nt));
		return null;
	}
	public NhaTro timKiemtheotenct(String TENCT) {
		NhaTro nt = new NhaTro(TENCT);
		if(dsNT.contains(nt))
			return dsNT.get(dsNT.indexOf(nt));
		return null;
	}
	public NhaTro timKiemtheosdt(String SDT) {
		NhaTro nt = new NhaTro(SDT);
		if(dsNT.contains(nt))
			return dsNT.get(dsNT.indexOf(nt));
		return null;
	}
	@SuppressWarnings("static-access")
	public boolean update(String MANT, String TENCT, String DIACHI, String SDT) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt=con.prepareStatement("update NhaTro"
					+ "set MANT=?"
					+ "set TENCT=?" 
					+ "set DIACHI=?"
					+ "set SDT=?");
			stmt.setString(1, MANT);
			stmt.setString(2, TENCT);
			stmt.setString(3, DIACHI);
			stmt.setString(4, SDT);
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String MANT) {
		@SuppressWarnings("static-access")
		Connection con=Database.getInstance().getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("Delete from NHATRO where MANT=?");
			statement.setString(1, MANT);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
}
