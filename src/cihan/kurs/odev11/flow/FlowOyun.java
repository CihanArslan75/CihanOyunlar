package cihan.kurs.odev11.flow;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class FlowOyun extends JFrame{
	private Container c=getContentPane();
	
	public FlowOyun() {
		
	    Initialize();
	}

	private void Initialize() {
		FlowOyunButon b=new FlowOyunButon();
		
		setBounds(500, 200, 800, 800);
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		c.add(b.getbbPanel());
		b.getbbPanel().setLayout(null);
		b.getbbPanel().setVisible(true);
		c.add(b.getbbPanel());
	}
}
