package cihan.kurs.odev11.flow;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FlowOyunButon extends JButton implements ActionListener{
	
	private JButton[] buttons= new JButton[Runner.oyunSeviye*Runner.oyunSeviye];
	private JPanel bbPanel;
	private String renk;
		
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
			buttons[i].addActionListener((ActionListener) this);
			
		}
		
		renkleriYerlestir();
	}
	
	public int butonBasHesapla(int panelBoyut) {
		return ( panelBoyut -  (70*Runner.oyunSeviye)) /2;
	}

	public void renkleriYerlestir()  {
		File file = new File(String.valueOf(Runner.path+"//flow.txt"));
		String bilgi;
		String bilgi1[] = null;
		try {
			BufferedReader	bf = new BufferedReader(new FileReader(file));
			
			while(bf.readLine()!=null) {
				bilgi=bf.readLine();
				bilgi1=bilgi.split(";");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5;1;r0;r6;b1;b16;g4;g13;p9;p18;y11;y24
		
		for (int i = 2; i < bilgi1.length; i++) {
		
			if(bilgi1[i].substring(0,1).equals("r")) 
			{
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setBackground(Color.RED);	
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setActionCommand("RED");
			}
			else if(bilgi1[i].substring(0,1).equals("b")) 
			{
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setBackground(Color.BLUE);
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setActionCommand("BLUE");
			}
			else if(bilgi1[i].substring(0,1).equals("g")) 
			{
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setBackground(Color.GREEN);
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setActionCommand("GREEN");
			}
			else if(bilgi1[i].substring(0,1).equals("p")) 
			{
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setBackground(Color.PINK);
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setActionCommand("PINK");
			}
			else if(bilgi1[i].substring(0,1).equals("y")) 
			{
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setBackground(Color.YELLOW);	
				buttons[Integer.parseInt(bilgi1[i].substring(1))].setActionCommand("YELLOW");
			}
		}
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		renk=e.getActionCommand();
	}
	
	

	
	

}
