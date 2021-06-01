package Text;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame {
	JSplitPane split;
	JLabel lbltitle, lblma,lblten, lblngaysinh,lblgioitinh, lblquequan,lbllop,lblcnganh,lblchon;
	JButton btntim,btnthem,btnxoa,btncapnhat,btnthoat,btnxuat,btnlammoi;
	JTextField txtma,txtten,txtns,txtgt,txtqq,txtlop,txtcnganh;
	JRadioButton radnam,radnu;
	JCheckBox chkma,chkten,chkqq,chklop;
	public static DefaultTableModel tableModel;
	private JTable table;
	public GiaoDien() {
		super("quan ly sinh vien");
		setSize(700,600);
		setLocationRelativeTo(null);
		setResizable(false);
		giaodien();
		setVisible(true);
	}

	private void giaodien() {
		split= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//phan dau
		JPanel pnorth= new JPanel();
		pnorth.add(lbltitle= new JLabel("-------------Quản lý sinh viên-----------"));
		Font fp= new Font("times new roman", Font.BOLD, 35);
		lbltitle.setFont(fp);
		lbltitle.setForeground(Color.BLUE);
		add(pnorth,BorderLayout.NORTH);
		//phan ben trai
		JPanel pwest= new JPanel();
		add(pwest,BorderLayout.WEST);
		pwest.setPreferredSize(new Dimension(400, 400));
		pwest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Thông tin sinh viên"));
		pwest.setLayout(null);
		pwest.add(lblma= new JLabel("MSSV: "));
		pwest.add(lblten= new JLabel("Họ và tên: "));
		pwest.add(lblngaysinh= new JLabel("Ngày sinh: "));
		pwest.add(lblgioitinh= new JLabel("Giới tính: "));
		pwest.add(lblquequan= new JLabel("Quê quán: "));
		pwest.add(lblcnganh= new JLabel("Khoa chuyên ngành:"));
		pwest.add(lbllop= new JLabel("Lớp: "));
		
		pwest.add(txtma= new JTextField());
		pwest.add(txtten= new JTextField());
		pwest.add(txtns= new JTextField());
		pwest.add(radnam= new JRadioButton("Nam"));
		pwest.add(radnu= new JRadioButton("Nữ"));
		pwest.add(txtqq= new JTextField());
		pwest.add(txtcnganh= new JTextField());
		pwest.add(txtlop= new JTextField());
		
		int w1 = 200, w2 = 300, h = 20;
		lblma.setBounds(10, 20, w1, h);
		txtma.setBounds(80, 20, w2, h);
		
		lblten.setBounds(10, 50, w1, h);
		txtten.setBounds(80, 50, w2, h);
		
		lblngaysinh.setBounds(10, 80, w1, h);
		txtns.setBounds(80, 80, w2, h);
		
		lblgioitinh.setBounds(10, 110, w1, h);
		radnu.setBounds(80, 110, w1, h);
		radnam.setBounds(150, 110, w1, h);
		
		lblquequan.setBounds(10, 140, w1, h);
		txtqq.setBounds(80, 140, w2, h);
		
		lblcnganh.setBounds(10, 170, w1, h);
		txtcnganh.setBounds(130, 170, 250, h);
		
		lbllop.setBounds(10, 200, w1, h);
		txtlop.setBounds(80, 200, w2, h);

		//phan ben phai
		JPanel peast= new JPanel();
		add(peast,BorderLayout.EAST);
		peast.setPreferredSize(new Dimension(290, 400));
		peast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn tìm kiếm "));
		peast.setLayout(null);
		//peast.setLayout(new BoxLayout(peast, BoxLayout.Y_AXIS));
		peast.add(chkma= new JCheckBox("Tìm theo MSSV"));
		peast.add(chkten= new JCheckBox("Tìm theo tên"));
		peast.add(chkqq= new JCheckBox("Tìm theo quê quán"));
		peast.add(chklop= new JCheckBox("Tìm theo lớp"));
		int w = 200, h1 = 20;
		chkma.setBounds(20, 20, w, h1);
		chkten.setBounds(20, 50, w, h1);
		chkqq.setBounds(20, 80, w, h1);
		chklop.setBounds(20,110, w, h1);
		//btntim.setBounds(240, 130, 65,20);
		peast.add(lblchon= new JLabel("Chọn tác vụ:"));
		lblchon.setBounds(20, 180, w, h1);
		peast.add(btnthem= new JButton("Thêm"));
		peast.add(btntim= new JButton("Tìm"));
		peast.add(btncapnhat= new JButton("Cập nhật"));
		peast.add(btnthoat= new JButton("Thoát"));
		peast.add(btnxuat= new JButton("Xuất"));
		peast.add(btnxoa= new JButton("Xóa"));
		btntim.setBounds(180, 140, 65,20);
		btnthem.setBounds(10, 220, 75, 20);
		btnxoa.setBounds(100, 220, 75, 20);
		btncapnhat.setBounds(190, 220, 85, 20);
		btnxuat.setBounds(55,260, 65,20);
		btnthoat.setBounds(165,260, 75,20);
		//phan giua
	
		//phan bang
		JScrollPane scroll;
		String [] header= "MSSV;Họ và tên;Ngày sinh;Giới tính;Quê Quán;Khoa CNgành;Lớp".split(";");
		tableModel= new DefaultTableModel(header, 0);
		add(scroll= new JScrollPane(table= new JTable(tableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		table.setRowHeight(20);
		//scroll.setBounds(10, 600, 780, 200);
		scroll.setPreferredSize(new Dimension(0, 220));
		//peast.setLayout(null);
	}
	public static void main(String[] args) {
		new GiaoDien();
	}
}

