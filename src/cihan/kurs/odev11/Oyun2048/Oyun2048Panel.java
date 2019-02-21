package cihan.kurs.odev11.Oyun2048;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oyun2048Panel extends JPanel {
	
	private JPanel bPanel = new JPanel();
	private int panelBoyut=450;
	
	public Oyun2048Panel() {
		
		panelInitialize();
		
	}

	public JPanel getbPanel() {
		return bPanel;
	}
	
	public int getPanelBoyut() {
		return panelBoyut;
	}

	public void setPanelBoyut(int panelBoyut) {
		this.panelBoyut = panelBoyut;
	}

	public void setbPanel(JPanel bPanel) {
		this.bPanel = bPanel;
	}
	
	public void panelInitialize() {
		
	   bPanel.setLayout(null);
	   bPanel.setVisible(true);   
	   bPanel.setBounds(70, 50, panelBoyut, panelBoyut);
	   bPanel.setBackground(Color.LIGHT_GRAY);
	   bPanel.setBackground(new Color(192, 192, 192));
	   
	  
   }

}
