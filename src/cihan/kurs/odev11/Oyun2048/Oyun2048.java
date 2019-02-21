package cihan.kurs.odev11.Oyun2048;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Oyun2048 extends JFrame{
	
	//private Container c= getContentPane();
	
	public Oyun2048() {
		Initialize();
	}

	private void Initialize() {
		Container c =getContentPane();
		Oyun2048Logic  b = new Oyun2048Logic();
		setTitle("2048");
		setBounds(600, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		c.setBackground(Color.GRAY);
		c.setLayout(null);
		c.add(b.getBbPanel());
		
		
		JButton btnYeniOyun = new JButton("YENİ OYUN");
		btnYeniOyun.setFont(new Font("Arial", Font.BOLD, 20));
		btnYeniOyun.setBounds(421, 508, 149, 32);
		c.add(btnYeniOyun);
		btnYeniOyun.setVisible(true);
		btnYeniOyun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.getBbPanel().removeAll();
				b.getBbPanel().updateUI();
				Initialize();
			}
		});
		
			
	}
}
