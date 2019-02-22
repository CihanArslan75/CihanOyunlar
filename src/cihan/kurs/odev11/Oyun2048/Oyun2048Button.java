package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Oyun2048Button extends JButton{
	
	protected JButton[][] buttons ; 
		
	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
	public Oyun2048Button() {
		buttonInitialize();
	}

	public void buttonInitialize() {
		int butonBas=40;
		buttons= new JButton[Runner.satirSayisi][Runner.satirSayisi];
		for (int i = 0; i <Runner.satirSayisi; i++) {
			for (int j = 0; j < Runner.satirSayisi; j++) {
				buttons[i][j]= new JButton("");
				buttons[i][j].setBounds((butonBas+(j*90)),(butonBas+(i*90)),90,90);
				buttons[i][j].setBackground(new Color(173, 216, 230));
				buttons[i][j].setForeground(Color.WHITE);
				buttons[i][j].addKeyListener( (KeyListener) this);
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 25));
				buttons[i][j].setVisible(true);				
			}
		}
		int a[]= Runner.getRandomNumber();
		int a1[]= Runner.getRandomNumber();
		
		while(a[0]==a1[0] && a[1]==a1[1]) {
			a1= Runner.getRandomNumber();
		}
		
		buttons[a[0]][a[1]].setText("2");
		buttons[a1[0]][a1[1]].setText("2");
		buttons[a[0]][a[1]].setBackground(Color.BLUE);
		buttons[a1[0]][a1[1]].setBackground(Color.BLUE);
			
	}


}
