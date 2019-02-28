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
		FlowOyunPanel  p = new FlowOyunPanel();
		FlowOyunButon b=new FlowOyunButon();
		
        c.add(p.getbPanel());
		for (int i = 0; i <b.buttons.length; i++) {
			p.getbPanel().add(b.buttons[i]);
		}
		
		setTitle("F L O W");
		setBounds(500, 150, 800, 800);
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
}
