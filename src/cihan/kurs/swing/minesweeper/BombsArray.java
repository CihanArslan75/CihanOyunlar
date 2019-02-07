package cihan.kurs.swing.minesweeper;
 
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class BombsArray { 
	
	private int[][] bombsArray = new int[Runner.SIZE][Runner.SIZE];
	private int[][] BombsControl= new int[Runner.SIZE][Runner.SIZE];
	
	public int[][] getBombsArray() {
		return bombsArray;
	}
	
	public int getBombsArray(int i,int j) {
		return bombsArray[i][j];
	}
	
	public int[][] getBombsControlArray() {
		return BombsControl;
	}
	
	public int getBombsControlArraySum() {
		 int sum=0;	 
		 for(int i=0; i<Runner.SIZE;i++) {
			 for(int j=0; j<Runner.SIZE;j++) {
				 if(BombsControl[i][j]==1) sum++;
			 }
		 }
		return sum;
	}
	
	
	public void setSightBombsArray(String select,int row,int column) {
		NumberFormat formatter = new DecimalFormat("000");
		boolean exit=true;
        String selectFirst=select.substring(0,1).toUpperCase( );
/***************************************************************************************/
        if(bombsArray[row][column]!=Runner.BSIZE ) {//bomba olmayan kutular için set
    	  if(bombsArray[row][column]==0 )  
	      {   
    		  nearBoxOpen(row,column);
	      }
    	  else if(bombsArray[row][column]!=Runner.SIZE*Runner.SIZE ) 
    	  {
    		  MinesWeeperSwing.buttons[row][column].setActionCommand(String.valueOf(bombsArray[row][column]));
    		  BombsControl[row][column]=1;
    		     		
          }	
    }
/***************************************************************************************/ 
    else   //  bomba olan  kutular için  flag  
	{  
    	if(MinesWeeperSwing.buttons[row][column].getActionCommand().equals("B"+select.substring(1,4))) 
		{ 
		   MinesWeeperSwing.buttons[row][column].setActionCommand("S"+select.substring(1,4));
		   BombsControl[row][column]=0;
		}
	    else
	    {
	       MinesWeeperSwing.buttons[row][column].setActionCommand("B"+select.substring(1,4));
		   BombsControl[row][column]=1;
	    }
	  }
      }
	
	public void setBombsArray() {
		 int[]   bombs =  new int[Runner.BOMBCOUNT];
		 int[]   ijBomb = new int[2];  
		 bombs = getMwBomb();
		
 /************ bombaları yerleştir **********************/
         for(int i=0;i<Runner.BOMBCOUNT;i++) {
		  	 ijBomb=Runner.findNumberfromIJ(bombs[i]);
		  	 bombsArray[ijBomb[0]][ijBomb[1]]=Runner.BSIZE;
		}
         
	 
   /************ komşulardaki bombaları say ,toplamları komşulara yerleştir***********************************/
		 
         int bombSum=0;
         int[] injn;
     	 int in;
		 int jn;
		 for(int i=0;i<Runner.SIZE;i++) {
			 for(int j=0;j<Runner.SIZE;j++) {
					
				
				 if(bombsArray[i][j]==Runner.SIZE*Runner.SIZE)
				 {
					continue;
				 }
				 BombsControl[i][j] =0 ;
		         String[] nearB= nearBox(i,j)	;
		           
				   int nearBSum=Integer.parseInt(nearB[9]);
				   for(int ii=0;ii<nearBSum;ii++)
				   {  	
					     injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
					    
					     in=injn[0];
						 jn=injn[1];
						 if(bombsArray[in][jn]==Runner.SIZE*Runner.SIZE ) 
						 {
							 bombSum++;
						 }
					  }
					 bombsArray[i][j]=bombSum;
					 bombSum=0;
		 }
		 }	
		
		this.bombsArray = bombsArray;
	} 
	
	
	public  int[] getMwBomb() {
		int bomb;
		int bombCount=Runner.BOMBCOUNT;
	
		int[]  bombArray = new  int[bombCount];
		for(int i =0 ;i<bombCount ;i++)
		{   
			bomb= Runner.getRandomNumber();
			for(int ii =0 ;ii<bombCount ;ii++)
			{
				while(bomb==bombArray[ii]) {
				bomb= Runner.getRandomNumber();
			}	
			}
			bombArray[i]=bomb;
		}
		
			return Runner.sort(bombArray);
	}

/*********************************************************************/		

	public String[] nearBox(int i,int j){
		
		String[] n=new String[10];
		int iFirst;
	    int jFirst;
	    int iLast;
	    int jLast;
	    int a=0;
	    int summ=0;
	    int s=Runner.SIZE/10;
		if(i==0) iFirst=i; else iFirst=i-1;
		if(j==0) jFirst=j; else jFirst=j-1;
		 
		if(i==Runner.SIZE-1) iLast=i; else iLast=i+1;
		if(j==Runner.SIZE-1) jLast=j; else jLast=j+1;
		for(int ii=iFirst;ii<=iLast;ii++) {
			for(int jj=jFirst;jj<=jLast;jj++) {
				n[a]=Runner.findIJfromNumber(ii,jj);
				if(!n[a].equals(null) )  summ++;
				a++;
								
			}
		 }
		 n[9]=String.valueOf(summ);
		
		return n;
	}

   public  void nearBoxOpen(int row,int column) {
	       String[] nearB= nearBox(row,column)	;
 
		   int nearBSum=Integer.parseInt(nearB[9]);
		   for(int ii=0;ii<nearBSum;ii++)
		   { 
			  int[] injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
			  int in=injn[0];
			  int jn=injn[1];
			  if(BombsControl[in][jn]==1) {continue;}
			  BombsControl[in][jn]=1;
			  if(bombsArray[in][jn]==Runner.SIZE*Runner.SIZE) {}
			  else if(bombsArray[in][jn]!=0) 
			  {
				  MinesWeeperSwing.buttons[in][jn].setText(String.valueOf(bombsArray[in][jn]));
				  MinesWeeperSwing.buttons[in][jn].setEnabled(false);
				  MinesWeeperSwing.buttons[in][jn].getText();
				  MinesWeeperSwing.buttons[in][jn].setBackground(Color.LIGHT_GRAY);
			  }
			  else if(bombsArray[in][jn]==0)  	  
			  {    
				  MinesWeeperSwing.buttons[in][jn].setText(" ");
				  MinesWeeperSwing.buttons[in][jn].setEnabled(false);
				  MinesWeeperSwing.buttons[in][jn].getText();
				  MinesWeeperSwing.buttons[in][jn].setBackground(Color.LIGHT_GRAY);
				  nearBoxOpen(in,jn);
			  }
			}
    }

}

