package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Oyun2048Button extends JButton implements KeyListener{
	
	private JButton[] buttons= new JButton[16];
	private JPanel bbPanel;
	
	
	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public JPanel getBbPanel() {
		return bbPanel;
	}

	public void setBbPanel(JPanel bbPanel) {
		this.bbPanel = bbPanel;
	}

	public Oyun2048Button() {
		buttonInitialize();
	}
	
	public void buttonInitialize() {
		
		Oyun2048Panel  p = new Oyun2048Panel();
		
		bbPanel=p.getbPanel();
	
		int butonBas=40;
		int k=0;
		int j=0;
		for (int i = 0; i < buttons.length; i++) {
			
			if((i%Runner.satirSayisi)==0 && i!=0) {
				k++;
				j=0;
			}
			buttons[i]= new JButton("");
			buttons[i].setBounds((butonBas+(j*90)),(butonBas+(k*90)),90,90);
			buttons[i].setVisible(true);
			bbPanel.add(buttons[i]);
			buttons[i].setBackground(new Color(233, 150, 122));
			buttons[i].setForeground(new Color(128, 0, 0));
			j++;
			//buttons[i].setActionCommand("bbbb");
			buttons[i].addKeyListener( (KeyListener) this);
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
