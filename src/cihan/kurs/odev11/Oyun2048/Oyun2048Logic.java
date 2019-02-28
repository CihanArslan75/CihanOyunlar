package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Oyun2048Logic extends Oyun2048Button implements KeyListener{
	private int sayiBosYer=0;
	private int sayiKontrol=0;
	public Oyun2048Logic() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37) solaAl37();
		if(e.getKeyCode()==38) yukariAl38();
		if(e.getKeyCode()==39) sagaAl39();
		if(e.getKeyCode()==40) asagiAl40();
		oyunSonKontrol();
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void oyunSonKontrol() {
		sayiBosYer=0;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				butonRenkVer(buttons[i][j]);
				if(buttons[i][j].getBackground().equals(new Color(173, 216, 230))) sayiBosYer++;
				if(buttons[i][j].getText().equals("2048")) 
				{
					oyunSonlandir();
					JOptionPane.showMessageDialog(Oyun2048Logic.this, "OYUNU KAZANDINIZ  !!!!!");
				}
					
			}
		 }
		hamleVarmiKontrol();
		if(sayiBosYer==0  && sayiKontrol==0 ) {
				oyunSonlandir();
				JOptionPane.showMessageDialog(Oyun2048Logic.this,"HAMLE BİTTİ. OYUN BİTTİ !");	
			}
		 
		 
	}
	
	private void oyunSonlandir()
	{
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
    }
	
	private void butonRenkVer(JButton button) {
		if(button.getText().equals("2")) button.setBackground(Color.BLUE);
		else if(button.getText().equals("4")) button.setBackground(Color.RED);
		else if(button.getText().equals("8")) button.setBackground(Color.PINK);
		else if(button.getText().equals("16")) button.setBackground(Color.GREEN);
		else if(button.getText().equals("32")) button.setBackground(Color.YELLOW);
		else if(button.getText().equals("64")) button.setBackground(Color.MAGENTA);
		else if(button.getText().equals("128")) button.setBackground(Color.CYAN);
		else if(button.getText().equals("256")) button.setBackground(Color.ORANGE);
		else if(button.getText().equals("512")) button.setBackground(new Color(46, 139, 87));
		else if(button.getText().equals("1024")) button.setBackground(new Color(128, 0, 128));
		else if(button.getText().equals("2048")) button.setBackground(new Color(154, 205, 50));
		else if(button.getText().equals("")) button.setBackground(new Color(173, 216, 230));
		
	}
	
  public void yukariAl38() {
	   
	     for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
			    int sayi=0;
				if(!buttons[i][j].getText().equals("") ) {
				  if((i<3) && buttons[i][j].getText().equals(buttons[(i+1)][j].getText()) && !buttons[i][j].getText().equals("") )
					{ 	
						sayi= Integer.parseInt(buttons[i+1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i+1][j].setText("");
					   
					   if(buttons[0][j].getText().equals(""))
						{
							buttons[0][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[1][j].getText().equals(""))
						{  
							buttons[1][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[2][j].getText().equals(""))
						{
							buttons[2][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						
					
					}
					else if((i<2)  && buttons[i][j].getText().equals(buttons[(i+2)][j].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i+1)][j].getText().equals(""))
					{  sayi= Integer.parseInt(buttons[i+2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i+2][j].setText("");
						if(buttons[0][j].getText().equals(""))
						{
							buttons[0][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[1][j].getText().equals(""))
						{
							buttons[1][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
											
					}
					else if((i<1)  && buttons[i][j].getText().equals(buttons[(i+3)][j].getText()) && !buttons[i][j].getText().equals("") && buttons[(i+1)][j].getText().equals("")  && buttons[(i+2)][j].getText().equals(""))
					{  sayi= Integer.parseInt(buttons[i+3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i+3][j].setText("");
					    if(buttons[0][j].getText().equals(""))
						{
							buttons[0][j].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
					
					}
				
				  else if(!buttons[i][j].getText().equals(""))
				  { 
						if(buttons[0][j].getText().equals("") && i>0)
						{
							buttons[0][j].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}
						else if(buttons[1][j].getText().equals("") && i>1)
						{
							buttons[1][j].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}
						else if(buttons[2][j].getText().equals("") && i>2)
						{
							buttons[2][j].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}	
				  }		  
			}	
			
		  }
		
		}
		
	   yeniSayiGetir();
	}
  
  public void asagiAl40() {
	   for (int i = buttons.length-1; i >=0; i--) {
			for (int j = 0; j < buttons.length; j++) {
				int sayi=0;
				if(!buttons[i][j].getText().equals("") ) {
					  if((i>0) && buttons[i][j].getText().equals(buttons[(i-1)][j].getText()) && !buttons[i][j].getText().equals("") )
						{ 	
							sayi= Integer.parseInt(buttons[i-1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
							buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i-1][j].setText("");
						   
						   if(buttons[3][j].getText().equals(""))
							{
								buttons[3][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[2][j].getText().equals(""))
							{  
								buttons[2][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[1][j].getText().equals(""))
							{
								buttons[1][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							
						
						}
						else if((i>1)  && buttons[i][j].getText().equals(buttons[(i-2)][j].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i-1)][j].getText().equals(""))
						{  sayi= Integer.parseInt(buttons[i-2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						    buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i-2][j].setText("");
							if(buttons[3][j].getText().equals(""))
							{
								buttons[3][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[2][j].getText().equals(""))
							{
								buttons[2][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
												
						}
						else if((i>=3)  && buttons[i][j].getText().equals(buttons[(i-3)][j].getText()) && !buttons[i][j].getText().equals("") && buttons[(i-1)][j].getText().equals("")  && buttons[(i-2)][j].getText().equals(""))
						{   sayi= Integer.parseInt(buttons[i-3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						    buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i-3][j].setText("");
						    if(buttons[3][j].getText().equals(""))
							{
								buttons[3][j].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							
						}
					
					  else if(!buttons[i][j].getText().equals(""))
					  { 
							if(buttons[3][j].getText().equals("") && i<3)
							{
								buttons[3][j].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							else if(buttons[2][j].getText().equals("") && i<2)
							{
								buttons[2][j].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							else if(buttons[1][j].getText().equals("") && i<1)
							{
								buttons[1][j].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							
					  }
				}
				
	       }
	
		}
		
	   yeniSayiGetir();
	}

  public void sagaAl39() {
	  for (int i = 0; i < buttons.length; i++) {
			for (int j = buttons.length-1; j >=0; j--) {
				 int sayi=0;
				if(!buttons[i][j].getText().equals("") ) {
					  if((j>0) && buttons[i][j].getText().equals(buttons[(i)][j-1].getText()) && !buttons[i][j].getText().equals("") )
						{ 	
						    sayi= Integer.parseInt(buttons[i][j-1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						    buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i][j-1].setText("");
						   
						   if(buttons[i][3].getText().equals(""))
							{
								buttons[i][3].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[i][2].getText().equals(""))
							{  
								buttons[i][2].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[i][1].getText().equals(""))
							{
								buttons[i][1].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							
						
						}
						else if((j>1)  && buttons[i][j].getText().equals(buttons[(i)][j-2].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i)][j-1].getText().equals(""))
						{   sayi= Integer.parseInt(buttons[i][j-2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						    buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i][j-2].setText("");
							if(buttons[i][3].getText().equals(""))
							{
								buttons[i][3].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							else if(buttons[i][2].getText().equals(""))
							{
								buttons[i][2].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
												
						}
						else if((j>=3)  && buttons[i][j].getText().equals(buttons[(i)][j-3].getText()) && !buttons[i][j].getText().equals("") && buttons[(i)][j-1].getText().equals("")  && buttons[(i)][j-2].getText().equals(""))
						{   sayi= Integer.parseInt(buttons[i][j-3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						    buttons[i][j].setText(String.valueOf(sayi));	
						    buttons[i][j-3].setText("");
						    if(buttons[i][3].getText().equals(""))
							{
								buttons[i][3].setText(String.valueOf(sayi));
								buttons[i][j].setText("");
							}
							
						}
					
					  else if(!buttons[i][j].getText().equals(""))
					  { 
							if(buttons[i][3].getText().equals("") && j<3)
							{
								buttons[i][3].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							else if(buttons[i][2].getText().equals("") && j<2)
							{
								buttons[i][2].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							else if(buttons[i][1].getText().equals("") && j<1)
							{
								buttons[i][1].setText(buttons[i][j].getText());
								buttons[i][j].setText("");
							}
							
					  }
				}
				
	       }
	
		}
		
	   yeniSayiGetir();
	}
  
  public void solaAl37() {
	  for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				int sayi=0;
				if(!buttons[i][j].getText().equals("") ) {
				  if((j<3) && buttons[i][j].getText().equals(buttons[(i)][j+1].getText()) && !buttons[i][j].getText().equals("") )
					{ 	
						sayi= Integer.parseInt(buttons[i][j+1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i][j+1].setText("");
					   
					   if(buttons[i][0].getText().equals(""))
						{
							buttons[i][0].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[i][1].getText().equals(""))
						{  
							buttons[i][1].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[i][2].getText().equals(""))
						{
							buttons[i][2].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						
					
					}
					else if((j<2)  && buttons[i][j].getText().equals(buttons[(i)][j+2].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i)][j+1].getText().equals(""))
					{   sayi= Integer.parseInt(buttons[i][j+2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i][j+2].setText("");
						if(buttons[i][0].getText().equals(""))
						{
							buttons[i][0].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
						else if(buttons[i][1].getText().equals(""))
						{
							buttons[i][1].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
											
					}
					else if((j<1)  && buttons[i][j].getText().equals(buttons[(i)][j+3].getText()) && !buttons[i][j].getText().equals("") && buttons[(i)][j+1].getText().equals("")  && buttons[(i)][j+2].getText().equals(""))
					{   sayi= Integer.parseInt(buttons[i][j+3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    buttons[i][j].setText(String.valueOf(sayi));	
					    buttons[i][j+3].setText("");
					    if(buttons[i][0].getText().equals(""))
						{
							buttons[i][0].setText(String.valueOf(sayi));
							buttons[i][j].setText("");
						}
					
					}
				
				  else if(!buttons[i][j].getText().equals(""))
				  { 
						if(buttons[i][0].getText().equals("") && j>0)
						{
							buttons[i][0].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}
						else if(buttons[i][1].getText().equals("") && j>1)
						{
							buttons[i][1].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}
						else if(buttons[i][2].getText().equals("") && j>2)
						{
							buttons[i][2].setText(buttons[i][j].getText());
							buttons[i][j].setText("");
						}
						
				  }
			}
						
	    }
	}
		
	   yeniSayiGetir();
	}
  
  public void yeniSayiGetir() {
	  int a[]= Runner2048.getRandomNumber();
	  int yeniSayi = 0;
	  
	   while(!buttons[a[0]][a[1]].getText().equals("") && sayiBosYer>0) {
			a= Runner2048.getRandomNumber();
	   }
	   if(sayiBosYer>0) {
		   yeniSayi=Runner2048.getRandom_2_4();
		   buttons[a[0]][a[1]].setText(String.valueOf(yeniSayi));
	   }
	   
  }
  
  public void hamleVarmiKontrol() {
	     sayiKontrol=0;
	     int sayi;
	     for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
			    sayi=0;
				if(!buttons[i][j].getText().equals("") ) {
				  if((i<3) && buttons[i][j].getText().equals(buttons[(i+1)][j].getText()) && !buttons[i][j].getText().equals("") )
					{ 	
						sayi= Integer.parseInt(buttons[i+1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    if(sayi>0) sayiKontrol++;
					}
					else if((i<2)  && buttons[i][j].getText().equals(buttons[(i+2)][j].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i+1)][j].getText().equals(""))
					{  sayi= Integer.parseInt(buttons[i+2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					    if(sayi>0) sayiKontrol++;										
					}
					else if((i<1)  && buttons[i][j].getText().equals(buttons[(i+3)][j].getText()) && !buttons[i][j].getText().equals("") && buttons[(i+1)][j].getText().equals("")  && buttons[(i+2)][j].getText().equals(""))
					{  sayi= Integer.parseInt(buttons[i+3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					   if(sayi>0) sayiKontrol++;
					}
			 	  
				  if((j<3) && buttons[i][j].getText().equals(buttons[(i)][j+1].getText()) && !buttons[i][j].getText().equals("") )
				  { 	
					  sayi= Integer.parseInt(buttons[i][j+1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					  if(sayi>0) sayiKontrol++;
				  }
				  else if((j<2)  && buttons[i][j].getText().equals(buttons[(i)][j+2].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i)][j+1].getText().equals(""))
				  {   
					  sayi= Integer.parseInt(buttons[i][j+2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					  if(sayi>0) sayiKontrol++;    
				  }
				  else if((j<1)  && buttons[i][j].getText().equals(buttons[(i)][j+3].getText()) && !buttons[i][j].getText().equals("") && buttons[(i)][j+1].getText().equals("")  && buttons[(i)][j+2].getText().equals(""))
				  {   
					  sayi= Integer.parseInt(buttons[i][j+3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					  if(sayi>0) sayiKontrol++;
				  }
			  }
		  }
		}
	     
	     for (int i = buttons.length-1; i >=0; i--) {
			for (int j = 0; j < buttons.length; j++) {
			  sayi=0;
			  if(!buttons[i][j].getText().equals("") ) {
			     if((i>0) && buttons[i][j].getText().equals(buttons[(i-1)][j].getText()) && !buttons[i][j].getText().equals("") )
				 { 	
					 sayi= Integer.parseInt(buttons[i-1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					 if(sayi>0) sayiKontrol++;
				 }
				 else if((i>1)  && buttons[i][j].getText().equals(buttons[(i-2)][j].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i-1)][j].getText().equals(""))
				 {  
					 sayi= Integer.parseInt(buttons[i-2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					if(sayi>0) sayiKontrol++;
				 }
				 else if((i>=3)  && buttons[i][j].getText().equals(buttons[(i-3)][j].getText()) && !buttons[i][j].getText().equals("") && buttons[(i-1)][j].getText().equals("")  && buttons[(i-2)][j].getText().equals(""))
				 {
					 sayi= Integer.parseInt(buttons[i-3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
					 if(sayi>0) sayiKontrol++;
				 }
			
		       }
			}   
	  }
	     
	     for (int i = 0; i < buttons.length; i++) {
				for (int j = buttons.length-1; j >=0; j--) {
				sayi=0;
					if(!buttons[i][j].getText().equals("") ) {
						  if((j>0) && buttons[i][j].getText().equals(buttons[(i)][j-1].getText()) && !buttons[i][j].getText().equals("") )
							{ 	
							    sayi= Integer.parseInt(buttons[i][j-1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
								if(sayi>0) sayiKontrol++;						
							}
							else if((j>1)  && buttons[i][j].getText().equals(buttons[(i)][j-2].getText()) && !buttons[i][j].getText().equals("")  && buttons[(i)][j-1].getText().equals(""))
							{   sayi= Integer.parseInt(buttons[i][j-2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
							    if(sayi>0) sayiKontrol++;    												
							}
							else if((j>=3)  && buttons[i][j].getText().equals(buttons[(i)][j-3].getText()) && !buttons[i][j].getText().equals("") && buttons[(i)][j-1].getText().equals("")  && buttons[(i)][j-2].getText().equals(""))
							{   sayi= Integer.parseInt(buttons[i][j-3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
							    if(sayi>0) sayiKontrol++;   
							}
					}
				}
					
		       }
		

  }
}
