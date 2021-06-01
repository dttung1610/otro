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
import javax.swing.table.DefaultTableModel;


@SuppressWarnings({ "serial", "unused" })
public class GiaoDienTro extends JFrame implements ActionListener, MouseListener {
	JSplitPane split;
	JLabel lbltitle, lblmant,lbltenct, lblsdt,lblchon,lbldiachi,lblnhap;
	JButton btntim,btnthem,btnxoa,btncapnhat,btnthoat,btnluu;
	JTextField txtdiachi,txttenct,txtsdt,txtmant,txtnhap;
	JCheckBox chkdiachi,chktenct,chksdt;
	public static DefaultTableModel tableModel;
	private JTable table;
	QuanLyTro dsnt=new QuanLyTro();
	public GiaoDienTro() {
		super("Quản lý nhà trọ");
		setSize(700,600);
		setLocationRelativeTo(null);
		setResizable(false);
		giaodientro();
		setVisible(true);
	}
	private void giaodientro() {
		// TODO Auto-generated method stub
		split= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//phan dau
		JPanel pnorth= new JPanel();
		pnorth.add(lbltitle= new JLabel("-------------Quản lý Nhà Trọ-----------"));
		Font fp= new Font("times new roman", Font.BOLD, 35);
		lbltitle.setFont(fp);
		lbltitle.setForeground(Color.BLUE);
		add(pnorth,BorderLayout.NORTH);
		//phan ben trai
				JPanel pwest= new JPanel();
				add(pwest,BorderLayout.WEST);
				pwest.setPreferredSize(new Dimension(400, 400));
				pwest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Thông tin nhà trọ"));
				pwest.setLayout(null);
				pwest.add(lblmant= new JLabel("Mã nhà trọ: "));
				pwest.add(lbltenct= new JLabel("Tên chủ trọ: "));
				pwest.add(lbldiachi= new JLabel("Địa chỉ: "));
				pwest.add(lblsdt= new JLabel("SDT: "));
				
				pwest.add(txtmant= new JTextField());
				pwest.add(txtdiachi= new JTextField());
				pwest.add(txttenct= new JTextField());
				pwest.add(txtsdt= new JTextField());
				
				
				
				
				int w1 = 200, w2 = 300, h = 20;
				lblmant.setBounds(10, 20, w1, h);
				txtmant.setBounds(80, 20, w2, h);
				
				lbltenct.setBounds(10, 50, w1, h);
				txttenct.setBounds(80, 50, w2, h);
				
				lbldiachi.setBounds(10, 80, w1, h);
				txtdiachi.setBounds(80, 80, w2, h);
				
				lblsdt.setBounds(10, 110, w1, h);
				txtsdt.setBounds(80, 110, w1, h);
				JPanel peast= new JPanel();
				add(peast,BorderLayout.EAST);
				peast.setPreferredSize(new Dimension(290, 400));
				peast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn tìm kiếm "));
				peast.setLayout(null);
				//peast.setLayout(new BoxLayout(peast, BoxLayout.Y_AXIS));
				peast.add(lblnhap=new JLabel("Nhập Vào địa chỉ cần tìm:"));
				peast.add(txtnhap=new JTextField(10));
				peast.add(chkdiachi= new JCheckBox("Tìm theo địa chỉ"));
				peast.add(chktenct= new JCheckBox("Tìm theo chủ nhà"));
				peast.add(chksdt= new JCheckBox("Tìm theo SDT"));
				int w = 200, h1 = 20;
				lblnhap.setBounds(20, 100, w, h1);
				txtnhap.setBounds(20, 120, w, h1);
				chkdiachi.setBounds(20, 20, w, h1);
				chktenct.setBounds(20, 50, w, h1);
				chksdt.setBounds(20, 80, w, h1);
				
				JLabel lblchon;
				//btntim.setBounds(240, 130, 65,20);
				peast.add(lblchon= new JLabel("Chọn tác vụ:"));
				lblchon.setBounds(20, 180, w, h1);
				peast.add(btnthem= new JButton("Thêm"));
				peast.add(btntim= new JButton("Tìm"));
				peast.add(btncapnhat= new JButton("Cập nhật"));
				peast.add(btnthoat= new JButton("Thoát"));
				
				peast.add(btnluu=new JButton("Lưu"));
				
				peast.add(btnxoa= new JButton("Xóa"));
				btntim.setBounds(180, 140, 65,20);
				btnthem.setBounds(10, 220, 75, 20);
				btnxoa.setBounds(100, 220, 75, 20);
				btncapnhat.setBounds(190, 220, 85, 20);
				btnluu.setBounds(55,260, 65,20);
				
				btnthoat.setBounds(165,260, 75,20);
				//bang
				JScrollPane scroll;
				String [] header= "Mã nhà trọ;Tên chủ trọ;Địa chỉ;SDT".split(";");
				tableModel= new DefaultTableModel(header, 0);
				add(scroll= new JScrollPane(table= new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
				table.setRowHeight(20);
				scroll.setPreferredSize(new Dimension(0, 220));	
				btntim.addActionListener(this);
				btnthem.addActionListener(this);
				btnxoa.addActionListener(this);
				btncapnhat.addActionListener(this);
				btnluu.addActionListener(this);
				table.addMouseListener(this);
				btnthoat.addActionListener(this);
				//khi chuong trinh chay nap toan bo du lien lang bang
				Database.getInstance().connect();
				updateTableData();
				
				
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();//lay dong chon tren table;
		txtmant.setText(table.getValueAt(row, 0).toString());
		txttenct.setText(table.getValueAt(row, 1).toString());
		txtdiachi.setText(table.getValueAt(row, 2).toString());
		txtsdt.setText(table.getValueAt(row, 3).toString());
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
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnthem)) {
			if (!txtmant.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this,"Mã điền chưa hợp lệ !","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;}
			if (!txttenct.getText().matches("[\\p{L}&[ ]]+")) {
				JOptionPane.showMessageDialog(this,"Họ tên điền chưa hợp lệ !","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!txtdiachi.getText().matches("[\\p{L}&[ ]&[./-]&[(]&[)]]+")) {
				JOptionPane.showMessageDialog(this,"Chưa điền Địa chỉ","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;}
			if (!txtsdt.getText().matches("[0-9]{9,12}")) {
				JOptionPane.showMessageDialog(this,"Chưa điền Số điện thoại","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;}	
			if(dsnt.create(txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText())) {
				Object[]rowData= {txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText()};
				tableModel.addRow(rowData);
			}
			JOptionPane.showMessageDialog(this,"Thêm Thành Công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			xoarongtextfiles();
			
		}
		else if(o.equals(btnluu)) {
			if(dsnt.create(txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText())) {
				Object[]rowData= {txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText()};
				tableModel.addRow(rowData);
			}
				
		}
		else if(o.equals(btncapnhat)) {
			
			if (!txtmant.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this,"Mã điền chưa hợp lệ !","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;}
			if (!txttenct.getText().matches("[\\p{L}&[ ]]+")) {
				JOptionPane.showMessageDialog(this,"Họ tên điền chưa hợp lệ !","Báo Lỗi",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(dsnt.update(txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText())) {
				Object[]rowData= {txtmant.getText(),txttenct.getText(),txtdiachi.getText(),txtsdt.getText()};
				tableModel.addRow(rowData);
			}
			JOptionPane.showMessageDialog(this,"Thêm Thành Công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			xoarongtextfiles();
		}
		else if(o.equals(btnxoa)) {
			int row=table.getSelectedRow();
			if(row>=0) {
				String MANT=(String)table.getValueAt(row, 0);
				if(dsnt.delete(MANT)) {
					tableModel.removeRow(row);
					xoarongtextfiles();
					JOptionPane.showMessageDialog(this,"Xoá thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(o.equals(btnthoat)) {
			
			
			System.exit(0);
		}
		else if(o.equals(btntim)) {
			String diachi = txtdiachi.getText();
			NhaTro nt = dsnt.timKiemtheodiachi(diachi);
			if(nt!=null) {
				int index = dsnt.docTuBang().indexOf(nt);
				table.getSelectionModel().setSelectionInterval(index, index);
			}
			else
				JOptionPane.showMessageDialog(this,"Không có địa chỉ này trong bảng!");
		}
		}
		
	//du lieu vao table
	private void updateTableData() {
		QuanLyTro dst=new QuanLyTro();
		ArrayList<NhaTro> list =dst.docTuBang();
		for(NhaTro nts: list) {
			String[] rowData = {nts.getMANT(),nts.getTENCT(),nts.getDIACHI(),nts.getSDT() + ""};
			tableModel.addRow(rowData);
		}
	}
		
		private void xoarongtextfiles() {
			txtmant.setText("");
			txttenct.setText("");
			txtdiachi.setText("");
			txtsdt.setText("");
			
		}

}
