package cihan.kurs.odev11.Oyun2048;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Container;

public class Oyun2048 extends JFrame{
	
	private Container c= getContentPane();
	
	public Oyun2048() {
		getContentPane().setBackground(Color.PINK);
		Initialize();
	}

	private void Initialize() {
		Oyun2048Button  b = new Oyun2048Button();
		setTitle("2048");
		setBounds(600, 200, 600, 600);
		c.setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		c.add(b.getBbPanel());
		b.getBbPanel().setLayout(null);
		b.getBbPanel().setVisible(true);
		c.add(b.getBbPanel());
			
	}
	
	
	
}
