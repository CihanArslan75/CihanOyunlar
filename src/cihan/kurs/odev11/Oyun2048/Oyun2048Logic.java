package cihan.kurs.odev11.Oyun2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Oyun2048Logic extends Oyun2048Button implements KeyListener{
	
	public Oyun2048Logic() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37)      solaAl37();
		else if(e.getKeyCode()==38) yukariAl38();
		else if(e.getKeyCode()==39) sagaAl39();
		else if(e.getKeyCode()==40) asagiAl40();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
  public void yukariAl38() {
		 for (int i = 1; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if(!buttons[i][j].getText().equals("") ) {
					if(buttons[i][j].getText().equals(buttons[(i-1)][j].getText()) && !buttons[i][j].getText().equals("") )
					{ 	int sayi= Integer.parseInt(buttons[i-1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						buttons[i-1][j].setText(String.valueOf(sayi));
						buttons[i][j].setText("");
					}
					else if(buttons[i-1][j].getText().equals(""))
					{
						buttons[i-1][j].setText(buttons[i][j].getText());
						buttons[i][j].setText("");
					}
					else 
					{ 
						buttons[i][j].setText(buttons[i][j].getText());
					}
						
				} 
			}
	
		}
		
	   yeniSayiGetir();
	}
  
  public void asagiAl40() {
		for (int i = buttons.length -2 ; i >=0 ; i--) {
	   		for (int j = 0; j < buttons.length; j++) {
				if(!buttons[i][j].getText().equals("") ) {
					if(buttons[i][j].getText().equals(buttons[(i+1)][j].getText()) && !buttons[i][j].getText().equals("") )
					{ 	int sayi= Integer.parseInt(buttons[i+1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						buttons[i+1][j].setText(String.valueOf(sayi));
						buttons[i][j].setText("");
					}
					else if(buttons[i+1][j].getText().equals(""))
					{
						buttons[i+1][j].setText(buttons[i][j].getText());
						buttons[i][j].setText("");
					}
					else 
					{ 
						buttons[i][j].setText(buttons[i][j].getText());
					}
						
				} 
			}
	
		}
		
	   yeniSayiGetir();
	}

  public void solaAl37() {
		   for (int i = 0; i < buttons.length; i++) {
			for (int j = 1; j < buttons.length; j++) {
				if(!buttons[i][j].getText().equals("") ) {
					if(buttons[i][j].getText().equals(buttons[(i)][j-1].getText()) && !buttons[i][j].getText().equals("") )
					{ 	int sayi= Integer.parseInt(buttons[i][j-1].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						buttons[i][j-1].setText(String.valueOf(sayi));
						buttons[i][j].setText("");
					}
					else if(buttons[i][j-1].getText().equals(""))
					{
						buttons[i][j-1].setText(buttons[i][j].getText());
						buttons[i][j].setText("");
					}
					else 
					{ 
						buttons[i][j].setText(buttons[i][j].getText());
					}
						
				} 
			}
	
		}
		
	   yeniSayiGetir();
	}
  
  public void sagaAl39() {
		for (int i = 0 ; i < buttons.length ; i++) {
	   		for (int j = buttons.length -2; j >=0 ; j--) {
				if(!buttons[i][j].getText().equals("") ) {
					if(buttons[i][j].getText().equals(buttons[(i)][j+1].getText()) && !buttons[i][j].getText().equals("") )
					{ 	int sayi= Integer.parseInt(buttons[i+1][j].getText()) + Integer.parseInt(buttons[i][j].getText()) ;
						buttons[i][j+1].setText(String.valueOf(sayi));
						buttons[i][j].setText("");
					}
					else if(buttons[i][j+1].getText().equals(""))
					{
						buttons[i][j+1].setText(buttons[i][j].getText());
						buttons[i][j].setText("");
					}
					else 
					{ 
						buttons[i][j].setText(buttons[i][j].getText());
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
