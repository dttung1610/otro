package javabaitailon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;



@SuppressWarnings({ "serial", "unused" })
public class GiaoDienChinh extends JFrame implements ActionListener{
	JLabel lbltitle;
	JButton btnsv,btntro,btnotro;
	public GiaoDienChinh() {
		super("Quản lý trọ cho sinh viên");
	
		JPanel pcen= new JPanel();
		pcen.add(lbltitle= new JLabel("Quản lý thông tin ở trọ của SV"));
		Font fp= new Font("times new roman", Font.BOLD, 35);
		lbltitle.setFont(fp);
		lbltitle.setForeground(Color.BLUE);
		lbltitle.setBounds(130,180, 700, 50);
		//
		pcen.add(btnsv= new JButton(" QUẢN LÝ SINH VIÊN "));
		btnsv.setBounds(50, 280, 150, 30);
		pcen.add(btntro= new JButton(" QUẢN LÝ TRỌ "));
		btntro.setBounds(250, 280, 150, 30);
		pcen.add(btnotro= new JButton(" QUẢN LÝ Ở TRỌ "));
		btnotro.setBounds(450, 280, 150, 30);
		pcen.setLayout(null);
		add(pcen,BorderLayout.CENTER);
		//
		btnsv.addActionListener(this);
		btnotro.addActionListener(this);
		btntro.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienChinh gd = new GiaoDienChinh();
					gd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnsv)) {
			GiaoDien hien= new GiaoDien();
			hien.setVisible(true);
		}else
		if(src.equals(btntro)) {
			GiaoDienTro hien1=new GiaoDienTro();
			hien1.setVisible(true);
		}else if(src.equals(btnotro)) {
			GiaoDienOTro hien2=new GiaoDienOTro();
			hien2.setVisible(true);
		}
	}
}
