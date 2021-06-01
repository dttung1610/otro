package javabaitailon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
	public class QuanLyOTro {
		ArrayList<OTro> dsOT;
		OTro ot ;
		public QuanLyOTro(){
			dsOT= new ArrayList<OTro>();
			ot= new OTro();
			
		}
		public ArrayList<OTro> docTuBang(){
			try {
				Connection con=Database.getInstance().getConnection();
				String sql="select *from otro";
				Statement statement=con.createStatement();
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next()) {
					String mSSV=rs.getString(1);
					String maNhaTro=rs.getString(2);
					
					String ngayden=rs.getString(3);
					String ngaydi=rs.getString(4);
				
					OTro oT= new OTro(mSSV, maNhaTro,  ngayden, ngaydi);
						dsOT.add(oT);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return dsOT;
		}
		public boolean create(String mSSV, String maNhaTro,  String ngayden, String ngaydi) {
			Connection con=Database.getInstance().getConnection();
			PreparedStatement stmt= null;
			int n=0;
			try {
				stmt=con.prepareStatement("insert into OTro values(?,?,?,?)");
				stmt.setString(1, mSSV);
				stmt.setString(2, maNhaTro);
				stmt.setString(3,ngayden);
				stmt.setString(4,ngaydi);
			
				n=stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return n>0;
		}
		public boolean update(String mSSV, String maNhaTro, String ngayden, String ngaydi) {
			Connection con=Database.getInstance().getConnection();
			PreparedStatement stmt= null;
			int n=0;
			try {
				stmt=con.prepareStatement("update OTro"
						+ "set mSSV=?"
						+ "set maNhaTro=?"
						+ "set ngayden=?"
						+ "set ngaydi=?");
				stmt.setString(1, mSSV);
				stmt.setString(2, maNhaTro);
				stmt.setString(3,ngayden);
				stmt.setString(4,ngaydi);
				n=stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return n>0;
		}
		public boolean delete(String mSSV) {
			Connection con=Database.getInstance().getConnection();
			PreparedStatement statement = null;
			int n = 0;
			try {
				statement = con.prepareStatement("Delete from OTro where MSSV=?");
				statement.setString(1, mSSV);
				n = statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		
		public OTro TimKiemTheoMSSV(String MSSV)
		{
			OTro oT = new OTro(MSSV);
			if(dsOT.contains(oT))
				return dsOT.get(dsOT.indexOf(oT));
			return null;
		}
		
		public OTro TimKiemTheoMNT(String DC)
		{
			for(OTro oT :dsOT)
			{
				if(oT.getMaNhaTro().equals(DC)==true)
				{
					return dsOT.get(dsOT.indexOf(oT));
				}
			}
			return null;
		}
		
	}

