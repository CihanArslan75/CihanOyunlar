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
	
	public int[][] bombsArray = new int[RunnerM.SIZE][RunnerM.SIZE];
	public int[][] BombsControl= new int[RunnerM.SIZE][RunnerM.SIZE];
	
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
		 for(int i=0; i<RunnerM.SIZE;i++) {
			 for(int j=0; j<RunnerM.SIZE;j++) {
				 if(BombsControl[i][j]==1) sum++;
			 }
		 }
		return sum;
	}
	
	
	
	public void setBombsArray() {
		 int[]   bombs =  new int[RunnerM.BOMBCOUNT];
		 int[]   ijBomb = new int[2];  
		 bombs = getMwBomb();
		
 /************ bombaları yerleştir **********************/
         for(int i=0;i<RunnerM.BOMBCOUNT;i++) {
		  	 ijBomb=RunnerM.findNumberfromIJ(bombs[i]);
		  	 bombsArray[ijBomb[0]][ijBomb[1]]=RunnerM.BSIZE;
		}
         
	 
   /************ komşulardaki bombaları say ,toplamları komşulara yerleştir***********************************/
		 
         int bombSum=0;
         int[] injn;
     	 int in;
		 int jn;
		 for(int i=0;i<RunnerM.SIZE;i++) {
			 for(int j=0;j<RunnerM.SIZE;j++) {
					
				
				 if(bombsArray[i][j]==RunnerM.SIZE*RunnerM.SIZE)
				 {
					continue;
				 }
				 BombsControl[i][j] =0 ;
		         String[] nearB= nearBox(i,j)	;
		           
				   int nearBSum=Integer.parseInt(nearB[9]);
				   for(int ii=0;ii<nearBSum;ii++)
				   {  	
					     injn=RunnerM.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
					    
					     in=injn[0];
						 jn=injn[1];
						 if(bombsArray[in][jn]==RunnerM.SIZE*RunnerM.SIZE ) 
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
		int bombCount=RunnerM.BOMBCOUNT;
	
		int[]  bombArray = new  int[bombCount];
		for(int i =0 ;i<bombCount ;i++)
		{   
			bomb= RunnerM.getRandomNumber();
			for(int ii =0 ;ii<bombCount ;ii++)
			{
				while(bomb==bombArray[ii]) {
				bomb= RunnerM.getRandomNumber();
			}	
			}
			bombArray[i]=bomb;
		}
		
			return RunnerM.sort(bombArray);
	}
	
public String[] nearBox(int i,int j){
		
		String[] n=new String[10];
		int iFirst;
	    int jFirst;
	    int iLast;
	    int jLast;
	    int a=0;
	    int summ=0;
	    int s=RunnerM.SIZE/10;
		if(i==0) iFirst=i; else iFirst=i-1;
		if(j==0) jFirst=j; else jFirst=j-1;
		 
		if(i==RunnerM.SIZE-1) iLast=i; else iLast=i+1;
		if(j==RunnerM.SIZE-1) jLast=j; else jLast=j+1;
		for(int ii=iFirst;ii<=iLast;ii++) {
			for(int jj=jFirst;jj<=jLast;jj++) {
				n[a]=RunnerM.findIJfromNumber(ii,jj);
				if(!n[a].equals(null) )  summ++;
				a++;
								
			}
		 }
		 n[9]=String.valueOf(summ);
		
		return n;
	}

/*********************************************************************/		


}

