package cihan.kurs.odev10.hafizaOyunu;

import java.awt.Container;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JTextArea;

public class HfzOyna extends JFrame {
	private Container c =getContentPane();
	private JPanel bPanel=new JPanel();
	private JPanel uPanel = new JPanel();
	JTextArea txtFileBilgi = new JTextArea();
	private int level ;
	private String kullaniciAdi ;
	int iiold = 999;
	private JLabel lblKullaniciAdi;
	private JLabel lblLevel;
	private int butonBoyut=70;
	private int bPanelBoyut=800;
	private int cBoyut=900;
	private boolean levelBittiKontrol=false;
	private int can=0;
	private JLabel lblCan = new JLabel("");
	
	public HfzOyna(String kullaniciAdi,int  level ) {
		this.kullaniciAdi =kullaniciAdi;
		this.level=level;
		ilkOyunBaslat();
		hfzInitialize();
	}
	
	public void hfzInitialize() {
		 cInitialize();
		 buttonsInitialize();
		 bPanelInitialize();
		 uPanelInitialize() ;
				 
		 
	}
	public void cInitialize() {
		 setTitle("Hafıza Oyunu");
		 c.setLayout(null);
		 setBounds(400, 100 ,cBoyut, cBoyut);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 c.setVisible(true);
		 c.setBackground(Color.LIGHT_GRAY);
		 			 
	}
	
	public void bPanelInitialize() {
		 bPanel.setForeground(Color.LIGHT_GRAY);
		 c.add(bPanel); 
		 int bPanelbas=(cBoyut-bPanelBoyut)/2-100;
		 bPanel.setBounds(45,100,bPanelBoyut,bPanelBoyut);
		 bPanel.setLayout(null);
		 
		 JTextArea txtFileBilgi = new JTextArea();
		 txtFileBilgi.setBounds(415, 13, 86, 4);
		 //bPanel.add(txtFileBilgi);
		 //txtFileBilgi.setVisible(true);
		 bPanel.setVisible(true);
	}
	
	public void uPanelInitialize() {
		 JPanel uPanel = new JPanel();
		 uPanel.setBackground(Color.GRAY);
		 uPanel.setBounds(45, 13, bPanelBoyut, 74);
		 c.add(uPanel);
		 uPanel.setLayout(null);
		 uPanel.setVisible(true);
		 
		 JLabel label = new JLabel("");
		 label.setBounds(231, 22, 0, 0);
		 uPanel.add(label);
		 
		 lblKullaniciAdi = new JLabel();
		 lblKullaniciAdi.setBounds(12, 22, 132, 24);
		 lblKullaniciAdi.setVerticalAlignment(SwingConstants.TOP);
		 uPanel.add(lblKullaniciAdi);
		 lblKullaniciAdi.setForeground(Color.BLACK);
		 lblKullaniciAdi.setFont(new Font("Arial", Font.BOLD, 20));
		 lblKullaniciAdi.setText(kullaniciAdi);
		 
		 lblLevel = new JLabel();
		 lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblLevel.setBounds(231, 22, 35, 35);
		 uPanel.add(lblLevel);
		 lblLevel.setForeground(Color.BLACK);
		 lblLevel.setFont(new Font("Arial", Font.PLAIN, 30));
		 lblLevel.setText(String.valueOf(level));
		 
		 JLabel lblKalp = new JLabel("New label");
		 lblKalp.setBounds(502, 13, 67, 44);
		 uPanel.add(lblKalp);
		 lblKalp.setIcon((Icon) new ImageIcon(getClass().getResource( "/kalp.png")));
		 
		 lblCan = new JLabel("");
		 lblCan.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCan.setFont(new Font("Arial", Font.BOLD, 20));
		 lblCan.setBounds(581, 17, 56, 39);
		 uPanel.add(lblCan);
		 can=(10*level)+10;
		 lblCan.setText(String.valueOf(can));
		 
		 		
	}
	
    public void buttonsInitialize() {
    	JButton[] buttons = new JButton[Runner.satirSayisi];
    	int[] hfzArray = new int[Runner.satirSayisi];
    	String[] hfzArrayOpen = new String[2];	
		int ii=0;
		int iii=0;
		int butonBasX=(bPanelBoyut- ((Runner.satirSayisi/2)*butonBoyut))/2 -100 ;
		
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
					 	
						can--;	
						lblCan.setText(String.valueOf(can));
					 	
					 	if(can<0) {
					 		lblCan.setText("0");
					 		JOptionPane.showMessageDialog(HfzOyna.this,"Canlarınız Bitti. Bu seviyeyi tekrar Oynayınız  !!");
					 		yeniOyunBaslat(0);
					 	}
					 	else
					 	{	
					 		int ii=Integer.parseInt(e.getActionCommand());
							buttons[ii].setIcon((Icon) new ImageIcon(getClass().getResource( "/"+hfzArray[ii]+".png")));
							
							levelBittiKontrol= levelAtla(buttons);
							if(!levelBittiKontrol) {		
							
								try {
									Thread.sleep(500);
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
								if(hfzArrayOpen[0]!=null && hfzArrayOpen[1]!=null && hfzArrayOpen[0].equals(hfzArrayOpen[1])) 
								{
									buttons[ii].setEnabled(false);
									buttons[iiold].setEnabled(false);
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
						yeniOyunBaslat(1);
						levelGuncelle();				
					}
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
		
//		for (int i = 0; i < 8; i++) {
//			System.out.print(hfzArray[i]+" ");
//		}
//		System.out.println();
	}
	
	public boolean levelAtla(JButton[] buttons) {
	    for (int i = 0; i < Runner.satirSayisi; i++) 
		{
			if(buttons[i].getIcon()==null) return false; 
			else continue;
		}
		return true;
	}
	
	public void ilkOyunBaslat() {
		if(level==1) Runner.satirSayisi=8;
		else 
		for (int i = 1; i < level; i++) {
			Runner.satirSayisi=Runner.satirSayisi+2;
		}
				
	}
	
	public void yeniOyunBaslat(int a) {
		bPanel.removeAll();
		//uPanel.removeAll();
		if(a==1) {
			level++;
			Runner.satirSayisi=Runner.satirSayisi+2;
			lblKullaniciAdi.setText(kullaniciAdi);
			lblLevel.setText(String.valueOf(level));
		}
		hfzInitialize();
	}
	
	public void levelGuncelle() {
	    File file = new File(String.valueOf(Runner.path+"//HafizaKullaniciBilgi.txt"));
		try {
			BufferedReader br= new BufferedReader(new FileReader(file));
			String bilgi;
			String[] bilgi1;
			 String yeniBilgi = "";
			  while((bilgi=br.readLine())!=null) {
				  bilgi1=bilgi.split(";");
				  if(bilgi1[0].equals(lblKullaniciAdi.getText())) {
					 yeniBilgi=yeniBilgi+bilgi1[0]+";"+bilgi1[1]+";"+level+"\n";				 
				  }	else
				  {
					  yeniBilgi=yeniBilgi+bilgi1[0]+";"+bilgi1[1]+";"+bilgi1[2]+"\n";	
				  }
			}
			txtFileBilgi.setText(yeniBilgi);	
			FileWriter w= new FileWriter(file);
			w.append(txtFileBilgi.getText());
			w.close();
			br.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
}
}
