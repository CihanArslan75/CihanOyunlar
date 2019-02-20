package cihan.kurs.odev11.Oyun2048;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

public class Oyun2048 extends JFrame{
	
	private Container c= getContentPane();
	
	public Oyun2048() {
		c.setBackground(new Color(210, 180, 140));
		Initialize();
	}

	private void Initialize() {
		Oyun2048Logic  b = new Oyun2048Logic();
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
