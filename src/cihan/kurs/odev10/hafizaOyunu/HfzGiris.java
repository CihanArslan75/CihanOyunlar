package cihan.kurs.odev10.hafizaOyunu;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class HfzGiris extends JFrame{
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	private Container c =getContentPane();
	
	public HfzGiris() {
		initialize();
	}
	
	private void initialize() {
        
        setTitle("Kullanıcı Giriş Ekranı");
		c.setLayout(null);
		setBounds(150, 250 ,484, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		c.setVisible(true);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(157, 39, 130, 22);
		c.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		txtSifre = new JTextField();
		txtSifre.setBounds(157, 97, 130, 22);
		c.add(txtSifre);
		txtSifre.setColumns(10);
		
		JLabel lblKullAdi = new JLabel("Kullanıcı Adı :");
		lblKullAdi.setBounds(36, 42, 122, 16);
		c.add(lblKullAdi);
		
		JLabel lblSifre = new JLabel("Şifre  :");
		lblSifre.setBounds(36, 100, 56, 16);
		c.add(lblSifre);
		
		JButton btnGiris = new JButton("Giriş");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kullaniciKontrol=kullaniciKontrol();
				if(kullaniciKontrol!=999) {
					HfzOyna hfz = new HfzOyna(txtKullaniciAdi.getText(),kullaniciKontrol);
					hfz.setVisible(true);
					HfzGiris.this.dispose();
				}
				
			}
		});
		btnGiris.setBounds(62, 158, 97, 25);
		c.add(btnGiris);
		
		JButton btnIptal = new JButton("İptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnIptal.setBounds(211, 158, 97, 25);
		
		c.add(btnIptal);
						
	}
	
	public int  kullaniciKontrol() {
		int level =999;
		
		File file = new File(String.valueOf(Runner.path+"//HafizaKullaniciBilgi.txt"));
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(file));
			String bilgi;
			String[] bilgi1;
			boolean sifreHatali=false;
			while((bilgi=br.readLine())!=null) {
				  bilgi1=bilgi.split(";");
				  if(bilgi1[0].equals(txtKullaniciAdi.getText())) {
					  if(bilgi1[1].equals(txtSifre.getText())) {
						  level=Integer.valueOf(bilgi1[2]);
						  break;
					  }
					  else
					  {
						  sifreHatali=true;
						  JOptionPane.showMessageDialog(HfzGiris.this,"Şifre Hatalı");
					  }
					  
				  }			 
			}
			if(level==999 && sifreHatali==false) JOptionPane.showMessageDialog(HfzGiris.this, "Kullanıcı Yok");
			br.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
		return level;
	}
}

