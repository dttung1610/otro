package Text;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GiaoDienChinh extends JFrame {
	JMenuBar mb=new JMenuBar(); 
	JMenu menutro,menusv,menuotro;
	public GiaoDienChinh() {
		super("Quản lý tro cho sinh vien");
		add(mb,BorderLayout.NORTH);
		mb.add(menusv= new JMenu("quan ly sinh vien"));
		mb.add(menutro= new JMenu("quan ly tro"));
		mb.add(menuotro= new JMenu("quan ly o tro"));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GiaoDienChinh();
	}
}
