package cihan.kurs.odev11.flow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FlowOyunButon extends JButton implements ActionListener{
	
	private JButton[] buttons= new JButton[Runner.oyunSeviye*Runner.oyunSeviye];
	private JPanel bbPanel;
		
	public FlowOyunButon() {
		buttonInitialize();
		
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public JPanel getbbPanel() {
		return bbPanel;
	}

	public void setbbPanel(JPanel bbPanel) {
		this.bbPanel = bbPanel;
	}

	private void buttonInitialize() {
		
		FlowOyunPanel p = new FlowOyunPanel();
		bbPanel = p.getbPanel() ;		
		bbPanel.setVisible(true);
		bbPanel.setBounds(0,0,p.getPanelBoyut(),p.getPanelBoyut());
		int butonBas=butonBasHesapla(p.getPanelBoyut());
		int k=0;
		int j=0;
		for (int i = 0; i < buttons.length; i++) {
			
			if((i%Runner.oyunSeviye)==0 && i!=0) {
				k++;
				j=0;
			}
			buttons[i]= new JButton("");
			buttons[i].setBounds((butonBas+(j*70)),(butonBas+(k*70)),70,70);
			buttons[i].setVisible(true);
			bbPanel.add(buttons[i]);
			j++;
			buttons[i].setActionCommand("bbbb");
			buttons[i].addActionListener((ActionListener) this);
		}
		
		
	}
	
	public int butonBasHesapla(int panelBoyut) {
		return ( panelBoyut -  (70*Runner.oyunSeviye)) /2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	
	

}
