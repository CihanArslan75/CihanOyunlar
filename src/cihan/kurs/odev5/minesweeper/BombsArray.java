package cihan.kurs.odev5.minesweeper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BombsArray {
	
	private int[][] bombsArray = new int[Runner.SIZE][Runner.SIZE];
	private String[][] sightBombsArray = new String[Runner.SIZE][Runner.SIZE];

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
		int iFirst;
        int jFirst;
        int iLast;
        int jLast;
        String selectFirst=select.substring(0,1).toUpperCase( );
/***************************************************************************************/
       // System.out.println("aaaa1:"+sightBombsArray[row][column].substring(0,1));
	  if(bombsArray[row][column]!=Runner.BSIZE  && selectFirst.equals("S")) {   //bomba olmayan kutular için set
        if(bombsArray[row][column]==0 ) 
	    {
	    	sightBombsArray[row][column]=" ";	
	    	/*****************Komşularından olanları bul *****/    	
		  			 if(row==0) iFirst=row; else iFirst=row-1;
					 if(column==0) jFirst=column; else jFirst=column-1;
					 
					 if(row==Runner.SIZE-1) iLast=row; else iLast=row+1;
					 if(column==Runner.SIZE-1) jLast=column; else jLast=column+1;
					  for(int ii=iFirst;ii<=iLast;ii++) {
						 for(int jj=jFirst;jj<=jLast;jj++) {
							 if(ii==row && jj==column) {}
							 else { 
								 if(bombsArray[ii][jj]==0)  
								 {	 		
									 sightBombsArray[ii][jj]=" ";		
								 }
					 						 
						  }
					 }
				}
/***************************************************************************************/
	    }
	    else
	    {
	    	sightBombsArray[row][column]=String.valueOf(bombsArray[row][column]);
	    }
	  } 
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
		  	 ijBomb=Runner.findNumber(bombs[i]);
		   	 bombsArray[ijBomb[0]][ijBomb[1]]=Runner.BSIZE;
		}
         
	 
   /************ komşulardaki bombaları say ,toplamları komşulara yerleştir***********************************/
		 
         int bombSum=0;
         int iFirst;
         int jFirst;
         int iLast;
         int jLast;
		 for(int i=0;i<Runner.SIZE;i++) {
			 for(int j=0;j<Runner.SIZE;j++) {
				
				 if(bombsArray[i][j]==Runner.SIZE*Runner.SIZE)
				 {
					continue;
				 }
				 if(i==0) iFirst=i; else iFirst=i-1;
				 if(j==0) jFirst=j; else jFirst=j-1;
				 
				 if(i==Runner.SIZE-1) iLast=i; else iLast=i+1;
				 if(j==Runner.SIZE-1) jLast=j; else jLast=j+1;
				 
				 for(int ii=iFirst;ii<=iLast;ii++) {
					 for(int jj=jFirst;jj<=jLast;jj++) {
						 
						 if(bombsArray[ii][jj]==Runner.SIZE*Runner.SIZE) 
						 {
							 bombSum++;
						 }
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
				//System.out.print(bombArray[i]+" ");
			}
			//System.out.println();
			return Runner.sort(bombArray);
		}

/*********************************************************************/		

	

}
