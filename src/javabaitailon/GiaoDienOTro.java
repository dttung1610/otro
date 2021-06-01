package javabaitailon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GiaoDienOTro extends JFrame implements ActionListener, MouseListener {
	JSplitPane split;
	JLabel lbltitle,lblmssv,lblchon,lblmant,lblngaydi,lblngayden;
	JButton btntim,btnthem,btnxoa,btncapnhat,btnthoat,btnxuat,btnlammoi,btnTimMSSV,btnTimMNT;
	JTextField txtmssv,txtngaydi,txtngayden,txtmant,txtTimMSSV,txtTimMNT;
	JCheckBox chkdiachi,chkchunha;
	JCheckBox chkmssv;
	public static DefaultTableModel tableModel;
	QuanLyOTro dsot = new QuanLyOTro();
	private JTable table;
	public GiaoDienOTro() {
		super("Quản lý sinh vien ở trọ");
		setSize(700,600);
		setLocationRelativeTo(null);
		setResizable(false);
		GDOTro();
		setVisible(true);
	}
	private void GDOTro() {
		// TODO Auto-generated method stub
		split= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//phan dau
		JPanel pnorth= new JPanel();
		pnorth.add(lbltitle= new JLabel("-------------Quản lý Sinh Viên Ở Trọ-----------"));
		Font fp= new Font("times new roman", Font.BOLD, 35);
		lbltitle.setFont(fp);
		lbltitle.setForeground(Color.BLUE);
		add(pnorth,BorderLayout.NORTH);
		//phan ben trai
				JPanel pwest= new JPanel();
				add(pwest,BorderLayout.WEST);
				pwest.setPreferredSize(new Dimension(400, 400));
				pwest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Thông tin sinh viên ở trọ"));
				pwest.setLayout(null);
				pwest.add(lblmssv= new JLabel("MSSV: "));
				pwest.add(lblmant= new JLabel("Mã nhà trọ: "));
				pwest.add(lblngaydi= new JLabel("Ngày đến: "));
				pwest.add(lblngayden= new JLabel("Ngày đi: "));
				
				pwest.add(txtmssv= new JTextField());
				pwest.add(txtmant= new JTextField());
				pwest.add(txtngaydi= new JTextField());
				pwest.add(txtngayden= new JTextField());
				
				
				
				
				int w1 = 200, w2 = 200, h = 20;
				lblmssv.setBounds(10, 20, w1, h);
				txtmssv.setBounds(80, 20, w2, h);
				
				lblmant.setBounds(10, 50, w1, h);
				txtmant.setBounds(80, 50, w2, h);
				
				
				lblngayden.setBounds(10, 80, w1, h);
				txtngayden.setBounds(80, 80, w2, h);
				
				lblngaydi.setBounds(10, 110, w1, h);
				txtngaydi.setBounds(80, 110, 250, h);	
				
				JPanel peast= new JPanel();
				add(peast,BorderLayout.EAST);
				peast.setPreferredSize(new Dimension(290, 400));
				peast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn tìm kiếm "));
				peast.setLayout(null);
				
				
				peast.add(txtTimMSSV = new JTextField());
				
				peast.add(txtTimMNT = new JTextField());
				peast.add(chkmssv= new JCheckBox("Tìm theo mssv "));
				peast.add(btnTimMSSV = new JButton("Tìm Theo MSSV"));
				peast.add(btnTimMNT = new JButton("Tìm theo mã nhà trọ"));
				int w = 150, h1 = 20;
				
				txtTimMSSV.setBounds(20, 20, w, h1);
				
				txtTimMNT.setBounds(20,100, w, h1);
				btnTimMSSV.setBounds(100,50,w,h1);
				btnTimMNT.setBounds(100, 130,w,h);
				
				JLabel lblchon;
				peast.add(lblchon= new JLabel("Chọn tác vụ:"));
				lblchon.setBounds(20, 180, w, h1);
				peast.add(btnthem= new JButton("Thêm"));
			
				peast.add(btnlammoi= new JButton("Làm mới"));
				peast.add(btnthoat= new JButton("Thoát"));
				peast.add(btnxuat= new JButton("Xuất"));
				peast.add(btnxoa= new JButton("Xóa"));
				
				btnthem.setBounds(10, 220, 75, 20);
				btnxoa.setBounds(100, 220, 75, 20);
				btnlammoi.setBounds(190, 220, 85, 20);
				btnxuat.setBounds(55,260, 65,20);
				btnthoat.setBounds(165,260, 75,20);
				//bang
				JScrollPane scroll;
				String [] header= "MSSV;Mã nhà trọ;Ngày đến;Ngày đi".split(";");
				tableModel= new DefaultTableModel(header, 0);
				add(scroll= new JScrollPane(table= new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
				table.setRowHeight(20);
				scroll.setPreferredSize(new Dimension(0, 220));	
				
				btnthem.addActionListener(this);
				btnlammoi.addActionListener(this);
				btnTimMNT.addActionListener(this);
				btnTimMSSV.addActionListener(this);
				btnxoa.addActionListener(this);
				btnthoat.addActionListener(this);
				
				Database.getInstance().connect();
				updateTableData();
	}
	public static void main(String[] args) {
		 new GiaoDienOTro();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtmssv.setText(table.getValueAt(row, 0).toString());
		txtmant.setText(table.getValueAt(row, 1).toString());
		txtngayden.setText(table.getValueAt(row, 2).toString());
		txtngaydi.setText(table.getValueAt(row, 3).toString());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		if(o.equals(btnthem))
		{
			
			if(!txtmant.getText().matches("[0-9]+") && !txtmssv.getText().matches("[0-9]+"))
			{
				JOptionPane.showMessageDialog(this,"Mã điền chưa hợp lệ !","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(dsot.create(txtmssv.getText(),txtmant.getText(),txtngayden.getText(),txtngaydi.getText()))
			{
				Object[]rowData = {txtmssv.getText(),txtmant.getText(),txtngayden.getText(),txtngaydi.getText()};
				tableModel.addRow(rowData);
			}
		}else if(o.equals(btnxoa))
		{
			int row=table.getSelectedRow();
			tableModel.removeRow(row);
			xoarongtextfiles();
			JOptionPane.showMessageDialog(this,"Xoá thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(o.equals(btnTimMSSV))
		{
			String mSSV= txtTimMSSV.getText();
			OTro oT = dsot.TimKiemTheoMSSV(mSSV);
			if(oT!=null)
			{
				int index = dsot.docTuBang().indexOf(oT);
				table.getSelectionModel().setSelectionInterval(index, index);
			}
		}
		else if(o.equals(btnTimMNT))
		{
			String mNT =txtTimMNT.getText();
			OTro oT = dsot.TimKiemTheoMNT(mNT);
			if(oT!=null)
			{
				int index = dsot.docTuBang().indexOf(oT);
				table.getSelectionModel().setSelectionInterval(index, index);
			}
		}
		else if(o.equals(btnthoat))
		{
			int hoi=JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn thoát","Chú ý",JOptionPane.YES_NO_OPTION);
			
			if(hoi==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		else if(o.equals(btnlammoi))
		{
			xoarongtextfiles();
		}
		
	}
	private void updateTableData() {
		QuanLyOTro ds = new QuanLyOTro();
		ArrayList<OTro> list =ds.docTuBang();
		for(OTro nts: list) {
			String[] rowData = {nts.getMSSV(),nts.getMaNhaTro(),nts.getNgayden(),nts.getNgaydi()+ ""};
			tableModel.addRow(rowData);
		}
	}
		
		private void xoarongtextfiles() {
			
			txtmssv.setText("");
			txtngaydi.setText("");
			txtngayden.setText("");
			txtmant.setText("");
			txtmant.requestFocus();
			
		}
		
}
