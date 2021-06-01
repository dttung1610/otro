package javabaitailon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DangNhap extends JFrame implements ActionListener{

	JPanel contentPane;
	JTextField txtTendn;
	JPasswordField pwdTxtpass;
	JButton btnDn;
	JButton btnThoat;
	public DangNhap()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pTieuDe = new JPanel();
		pTieuDe.setBounds(0, 0, 450, 94);
		contentPane.add(pTieuDe);
		pTieuDe.setLayout(null);
		
		JLabel lblTieude = new JLabel("Phần mềm quản lý trọ");
		lblTieude.setForeground(Color.BLUE);
		lblTieude.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTieude.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieude.setBounds(15, 9, 450, 72);
		pTieuDe.add(lblTieude);
		
		
		
		JLabel lblTendn = new JLabel("Tên Đăng Nhập :");
		lblTendn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTendn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendn.setBounds(115, 111, 122, 42);
		contentPane.add(lblTendn);
		
		txtTendn = new JTextField();
		txtTendn.setBounds(255, 122, 200, 28);
		contentPane.add(txtTendn);
		txtTendn.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(40, 180, 91, 64);
		contentPane.add(label);
		
		JLabel lblMk = new JLabel("Mật Khẩu :");
		lblMk.setHorizontalAlignment(SwingConstants.CENTER);
		lblMk.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMk.setBounds(134, 181, 122, 42);
		contentPane.add(lblMk);
		
		pwdTxtpass = new JPasswordField();
		pwdTxtpass.setBounds(255, 188, 200, 28);
		contentPane.add(pwdTxtpass);
		
		btnDn = new JButton(" Đăng Nhập");
		btnDn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDn.setHorizontalAlignment(SwingConstants.LEFT);
	
		btnDn.setBounds(91, 255, 120, 40);
		contentPane.add(btnDn);
		
		btnThoat = new JButton("  Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setBounds(307, 253, 100, 42);
		contentPane.add(btnThoat);
		
		btnDn.addActionListener(this);
		btnThoat.addActionListener(this);
		setVisible(true);
		setSize(550,365);
		setLocationRelativeTo(null);
	    setTitle("dang nhap");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DangNhap dn=new DangNhap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj.equals(btnDn))
		{
			String tdn="admin";
			String mk="passwordadmin";
			if(txtTendn.getText().equals("admin")&&pwdTxtpass.getText().equals("passwordadmin"))
			{
				JOptionPane.showMessageDialog(this,"Đăng Nhập Thành Công");
				GiaoDienChinh gd = new GiaoDienChinh();
				gd.setVisible(true);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "Đăng Nhập Không Thành Công");
			}
		}
		if(obj.equals(btnThoat)) {
			int hoi=JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn thoát","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoi==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		
	}

}
