package cihan.kurs.odev11.flow;

import javax.swing.JPanel;

public class FlowOyunPanel extends JPanel{
	
	private JPanel bPanel =new JPanel();
	private int panelBoyut=700;

	public FlowOyunPanel() {
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

	
}
