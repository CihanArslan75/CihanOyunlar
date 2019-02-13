package cihan.kurs.odev10.hafizaOyunu;

import java.awt.Container;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class HfzOyna extends JFrame {
	private Container c =getContentPane();
	private JPanel bPanel=new JPanel();
//	private JButton[] buttons = new JButton[Runner.satirSayisi];
	private int level ;
	private String kullaniciAdi ;
	private String[] hfzArrayOpen = new String[2];	
	int iiold = 999;
	private JLabel lblKullaniciAdi;
	private JLabel lblLevel;
	private int butonBoyut=70;
	private int bPanelBoyut=600;
	private int cBoyut=800;
	private boolean levelBittiKontrol=false;
	
	public HfzOyna(String kullaniciAdi,int  level ) {
		this.kullaniciAdi =kullaniciAdi;
		this.level=level;
		hfzInitialize();
	}
	
	public void hfzInitialize() {
		 cInitialize();
		 buttonsInitialize();
		 bPanelInitialize();
				 
		 
	}
	public void cInitialize() {
		 setTitle("Hafıza Oyunu");
		 c.setLayout(null);
		 setBounds(400, 100 ,cBoyut, cBoyut);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 c.setVisible(true);
		 c.setBackground(Color.LIGHT_GRAY);
		 
		 lblKullaniciAdi = new JLabel();
		 lblKullaniciAdi.setForeground(Color.RED);
		 lblKullaniciAdi.setFont(new Font("Arial", Font.BOLD, 20));
		 lblKullaniciAdi.setBounds(80, 24, 137, 43);
		 getContentPane().add(lblKullaniciAdi);
		 lblKullaniciAdi.setText(kullaniciAdi);
		 
		 lblLevel = new JLabel();
		 lblLevel.setForeground(Color.RED);
		 lblLevel.setFont(new Font("Arial", Font.BOLD, 20));
		 lblLevel.setBounds(254, 24, 116, 43);
		 getContentPane().add(lblLevel);
		 lblLevel.setText(String.valueOf(level));
		 
		 
		 
	}
	
	public void bPanelInitialize() {
		 bPanel.setForeground(Color.LIGHT_GRAY);
		 c.add(bPanel); 
		 int bPanelbas=(cBoyut-bPanelBoyut)/2;
		 bPanel.setBounds(bPanelbas,bPanelbas,bPanelBoyut,bPanelBoyut);
		 bPanel.setLayout(null);
		 bPanel.setVisible(true);
		 		
	}
	
    public void buttonsInitialize() {
    	JButton[] buttons = new JButton[Runner.satirSayisi];
    	int[] hfzArray = new int[Runner.satirSayisi];
		int ii=0;
		int iii=0;
		int butonBasX=(bPanelBoyut- ((Runner.satirSayisi/2)*butonBoyut))/2 -100;
		
		for (int i = 0; i < Runner.satirSayisi; i++) {
			buttons[i] = new JButton("");
			bPanel.add(buttons[i]);
				
			if(i%(Runner.satirSayisi/2)==0 && i!=0) iii++;
			if(i==(Runner.satirSayisi/2) ) 
			{
				ii=0;
			}
			ii++;
								
			buttons[i].setBounds((butonBasX+(70*ii)) , (200+(iii*70)) , butonBoyut, butonBoyut);
			buttons[i].setVisible(true);
			buttons[i].setActionCommand((""+i));
			
			buttons[i].addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					    
					Thread t1 = new Thread(new Runnable() {
							
					@Override
					public void run() {
					 		
						int ii=Integer.parseInt(e.getActionCommand());
						buttons[ii].setIcon((Icon) new ImageIcon(getClass().getResource( "/"+hfzArray[ii]+".png")));
						
						levelBittiKontrol= levelAtla(buttons);
						if(!levelBittiKontrol) {		
						
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}	
							
							if(hfzArrayOpen[0]==null ) {
								hfzArrayOpen[0]=String.valueOf(hfzArray[ii]);
							}
							else  {
								hfzArrayOpen[1]=String.valueOf(hfzArray[ii]);
							}
											
							if(hfzArrayOpen[0]!=null && hfzArrayOpen[1]!=null && !hfzArrayOpen[0].equals(hfzArrayOpen[1])) 
							{
							    buttons[ii].setIcon(null);
								buttons[iiold].setIcon(null);
							}
							
							if(hfzArrayOpen[0]!=null && hfzArrayOpen[1]!=null) {
								hfzArrayOpen[0]=null;
								hfzArrayOpen[1]=null;
							}
	
							iiold=ii;
					 }
				else
				{
					JOptionPane.showMessageDialog(HfzOyna.this,"Level Atladınız");
					bPanel.removeAll();
					level++;
					Runner.satirSayisi=Runner.satirSayisi+2;
					System.out.println(Runner.satirSayisi);
					lblLevel.setText(String.valueOf(level));
					hfzInitialize();
				}
				} 
				
				});
				t1.start();
				}
				});
			
			
			
		}
		
		getFoto(hfzArray) ;
		
	}

	public void getFoto(int[] hfzArray) {
		List<Integer> r1Array = new ArrayList<Integer>();
		List<Integer> r2Array = new ArrayList<Integer>();
		System.out.println("Runner.satirSayisi:"+Runner.satirSayisi);
		for (int i = 1; i <= Runner.satirSayisi/2; i++) 
		{
			int r1;
			int r2;
			
			r1=Runner.getRandomNumber1();
			r2=Runner.getRandomNumber2();
				
					
			while(r1Array.contains(r1)) {
				r1=Runner.getRandomNumber1();
			}
				
			while(r2Array.contains(r2)) {
				r2=Runner.getRandomNumber2();
			}
				
			r1Array.add(r1);
			r2Array.add(r2);
										
			hfzArray[r1]=r1;
			hfzArray[r2]=r1;
		}
		
		for (int i = 0; i < 8; i++) {
			System.out.print(hfzArray[i]+" ");
		}
		System.out.println();
	}
	
	public boolean levelAtla(JButton[] buttons) {
	    for (int i = 0; i < Runner.satirSayisi; i++) 
		{
			if(buttons[i].getIcon()==null) return false; 
			else continue;
		}
		return true;
	}
}
