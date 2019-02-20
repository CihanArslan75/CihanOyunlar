package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Oyun2048Logic extends Oyun2048Button implements KeyListener{
	
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
		 //butonRenkVer(buttons[i][j]);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void butonRenkVer(JButton a) {
		if(a.getText().equals("2")) a.setBackground(Color.blue);
		else if(a.getText().equals("4")) a.setBackground(Color.red);
		else if(a.getText().equals("8")) a.setBackground(Color.pink);
		else if(a.getText().equals("16")) a.setBackground(Color.green);
		else if(a.getText().equals("32")) a.setBackground(Color.yellow);
		else a.setBackground(Color.gray);
		
	}
	
  public void yukariAl38() {
		 for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if(!buttons[i][j].getText().equals("") ) {
				  if((i<3) && buttons[i][j].getText().equals(buttons[(i+1)][j].getText()) && !buttons[i][j].getText().equals("") )
					{ 	
						int sayi= Integer.parseInt(buttons[i+1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
					{ int sayi= Integer.parseInt(buttons[i+2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
					{ int sayi= Integer.parseInt(buttons[i+3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
				if(!buttons[i][j].getText().equals("") ) {
					  if((i>0) && buttons[i][j].getText().equals(buttons[(i-1)][j].getText()) && !buttons[i][j].getText().equals("") )
						{ 	
							int sayi= Integer.parseInt(buttons[i-1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
						{ int sayi= Integer.parseInt(buttons[i-2][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
						{ int sayi= Integer.parseInt(buttons[i-3][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
				if(!buttons[i][j].getText().equals("") ) {
					  if((j>0) && buttons[i][j].getText().equals(buttons[(i)][j-1].getText()) && !buttons[i][j].getText().equals("") )
						{ 	
							int sayi= Integer.parseInt(buttons[i][j-1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
						{ int sayi= Integer.parseInt(buttons[i][j-2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
						{ int sayi= Integer.parseInt(buttons[i][j-3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
				if(!buttons[i][j].getText().equals("") ) {
				  if((j<3) && buttons[i][j].getText().equals(buttons[(i)][j+1].getText()) && !buttons[i][j].getText().equals("") )
					{ 	
						int sayi= Integer.parseInt(buttons[i][j+1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
					{ int sayi= Integer.parseInt(buttons[i][j+2].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
					{ int sayi= Integer.parseInt(buttons[i][j+3].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
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
	  int a[]= Runner.getRandomNumber();
		int yeniSayi = 0;
		
		while(!buttons[a[0]][a[1]].getText().equals("")) {
			a= Runner.getRandomNumber();
		}
		yeniSayi=Runner.getRandom_2_4();
		buttons[a[0]][a[1]].setText(String.valueOf(yeniSayi));
  }

}
