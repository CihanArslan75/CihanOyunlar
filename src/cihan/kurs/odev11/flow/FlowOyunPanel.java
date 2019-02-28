package cihan.kurs.odev11.flow;

import java.awt.Color;

import javax.swing.JPanel;

public class FlowOyunPanel extends JPanel{
	
	private JPanel bPanel =new JPanel();
	private int panelBoyut=700;

	public FlowOyunPanel() {
		panelInitialize();
	}

	public JPanel getbPanel() {
		return bPanel;
	}

	public void setbPanel(JPanel bPanel) {
		this.bPanel = bPanel;
	}

	public int getPanelBoyut() {
		return panelBoyut;
	}

	public void setPanelBoyut(int panelBoyut) {
		this.panelBoyut = panelBoyut;
	}
	
	public void panelInitialize() {
		
		   bPanel.setLayout(null);
		   bPanel.setVisible(true);   
		   bPanel.setBounds(40, 30, panelBoyut, panelBoyut);
		   bPanel.setBackground(new Color(224, 255, 255));
		   
		  
	   }
	
}
