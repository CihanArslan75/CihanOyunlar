package cihan.kurs.odev11.Oyun2048;

import javax.swing.JPanel;
import java.awt.Color;

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
	   bPanel.setBackground(new Color(255, 192, 203));
   }

}
