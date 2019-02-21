package cihan.kurs.odev11.Oyun2048;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Oyun2048 extends JFrame{
	
	private Container c= getContentPane();
	
	public Oyun2048() {
		Initialize();
	}

	private void Initialize() {
		Oyun2048Panel  p = new Oyun2048Panel();
		Oyun2048Logic  b = new Oyun2048Logic();
		
		c.setBackground(Color.GRAY);
		c.setLayout(null);
		c.add(p.getbPanel());
		
		for (int i = 0; i <Runner.satirSayisi; i++) {
			for (int j = 0; j < Runner.satirSayisi; j++) {	
				p.getbPanel().add(b.buttons[i][j]);
			}
		}
		b.buttons[0][0].requestFocus();
		
		setTitle("2048");
		setBounds(600, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		JButton btnYeniOyun = new JButton("YENİ OYUN");
		btnYeniOyun.setBounds(378, 507, 192, 33);
		getContentPane().add(btnYeniOyun);
		btnYeniOyun.setFont(new Font("Arial", Font.BOLD, 20));
		btnYeniOyun.setVisible(true);
		btnYeniOyun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.removeAll();
				c.repaint();
				Initialize();
				
			}
		});
		
			
	}
}
