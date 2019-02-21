package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Oyun2048Button extends JButton{
	
	protected JButton[][] buttons= new JButton[Runner.satirSayisi][Runner.satirSayisi];
	private JPanel bbPanel;
		
	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}

	public JPanel getBbPanel() {
		return bbPanel;
	}

	public void setBbPanel(JPanel bbPanel) {
		this.bbPanel = bbPanel;
	}

	public Oyun2048Button() {
		
		Oyun2048Panel p = new Oyun2048Panel();
		bbPanel=p.getbPanel();
		buttonInitialize();
	}
	
	@SuppressWarnings("deprecation")
	public void buttonInitialize() {
				
		int butonBas=40;
		for (int i = 0; i <Runner.satirSayisi; i++) {
			for (int j = 0; j < Runner.satirSayisi; j++) {	
				buttons[i][j]= new JButton("");
				buttons[i][j].setBounds((butonBas+(j*90)),(butonBas+(i*90)),90,90);
				buttons[i][j].setBackground(new Color(211, 211, 211));
				buttons[i][j].setForeground(Color.WHITE);
				buttons[i][j].addKeyListener( (KeyListener) this);
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 30));
				buttons[i][j].setVisible(true);
				bbPanel.add(buttons[i][j]);
				//buttons[0][0].getComponentZOrder(buttons[0][0]);
				
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
