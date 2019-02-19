package cihan.kurs.odev11.Oyun2048;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Oyun2048 extends JFrame{
	public Oyun2048() {
		setBounds(100,100,300,300);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JButton button1 = new JButton("New button");
		button1.setBackground(Color.red);
		button1.setBounds(95, 104, 97, 83);
		getContentPane().add(button1);
		button1.setVisible(true);
		button1.addKeyListener(new KeyAdapter() {
		@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("aaa:"+e.getKeyCode());
			}
		});
		
	}
}
