package cihan.kurs.odev5.minesweeper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BombsArray{
	
	private int[][] bombsArray = new int[Runner.SIZE][Runner.SIZE];
	private String[][] sightBombsArray = new String[Runner.SIZE][Runner.SIZE];
	private int[][] MayinKontrol= new int[Runner.SIZE][Runner.SIZE];
	
	public int[][] getBombsArray() {
		return bombsArray;
	}
	
	public String[][] getSightBombsArray() {
		return sightBombsArray;
	}
	
	public  void setSightBombsArray() {
		   NumberFormat formatter = new DecimalFormat("000");
			int numberMW=0;
			for(int i=0;i<Runner.SIZE;i++) {
				for(int j =0;j<Runner.SIZE;j++) {
					sightBombsArray[i][j]="S"+formatter.format(numberMW);
				     numberMW++;
				}
			}
			this.sightBombsArray = sightBombsArray;
	}
	
	public void setSightBombsArray(String select,int row,int column) {
		NumberFormat formatter = new DecimalFormat("000");
		boolean exit=true;
        String selectFirst=select.substring(0,1).toUpperCase( );
/***************************************************************************************/
      if(bombsArray[row][column]!=Runner.BSIZE  && selectFirst.equals("S")) {//bomba olmayan kutular için set
    	  if(bombsArray[row][column]==0 )  
	      {
    		  nearBoxOpen(row,column);
	      }
    	  else if(bombsArray[row][column]!=100 ) 
    	  {
         	  sightBombsArray[row][column]=String.valueOf(bombsArray[row][column]);
          }	
    }
/***************************************************************************************/ 
    else   //  bomba olan  kutular için  flag  
	{   if(sightBombsArray[row][column].equals("BOMB")) 
		   {
		     sightBombsArray[row][column]="S"+select.substring(1,4);
		   }
	       else
	       {
		    sightBombsArray[row][column]="BOMB";
	       }
	  }
      
        this.sightBombsArray = sightBombsArray;

}
	
	public void setBombsArray() {
		 int[]   bombs =  new int[Runner.BOMBCOUNT];
		 int[]   ijBomb = new int[2];  
		 bombs = getMwBomb();
		 NumberFormat formatter = new DecimalFormat("000");
         

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
				 MayinKontrol[i][j] =0 ;
		           String[] nearB= nearBox(i,j)	;
				   int nearBSum=Integer.parseInt(nearB[9]);
				   for(int ii=0;ii<nearBSum;ii++)
				   {  	
					     injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
					     in=injn[0];
						 jn=injn[1];
						 if(bombsArray[in][jn]==Runner.SIZE*Runner.SIZE) 
						 {
							 bombSum++;
						 }
					  }
					 bombsArray[i][j]=bombSum;
					 bombSum=0;
		 }
		 }	
		
		 for(int i =0 ;i<Runner.SIZE ;i++)
		  { 
			  for(int j=0 ; j<Runner.SIZE ;j++)
			  {	
				  System.out.print(formatter.format(bombsArray[i][j])+" ");
			  }
			  System.out.println();
		  }
	
		this.bombsArray = bombsArray;
	} 
	
	
	public  int[] getMwBomb() {
		int bomb;
		int bombCount=2*Runner.SIZE;
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

   public void nearBoxOpen(int row,int column) {
	       String[] nearB= nearBox(row,column)	;
 
		   int nearBSum=Integer.parseInt(nearB[9]);
		   for(int ii=0;ii<nearBSum;ii++)
		   { 
			  int[] injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
			  int in=injn[0];
			  int jn=injn[1];
			  if(MayinKontrol[in][jn]==1) {continue;}
			  MayinKontrol[in][jn]=1;
			  if(bombsArray[in][jn]==100) {}
			  else if(bombsArray[in][jn]!=0) 
			  {
				  sightBombsArray[in][jn]=String.valueOf(bombsArray[in][jn]);
			  }
			  else if(bombsArray[in][jn]==0)  	  
			  {      
				  sightBombsArray[in][jn]=" ";
				  nearBoxOpen(in,jn);
			  }
			}
    }

}

