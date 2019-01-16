package cihan.kurs.odev5.minesweeper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BombsArray {
	
	private int[][] bombsArray = new int[Runner.SIZE][Runner.SIZE];
	private String[][] sightBombsArray = new String[Runner.SIZE][Runner.SIZE];
	
	public BombsArray() {
		

	}

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
		int[] injn;
		int in;
		int jn;
		boolean exit=true;
        String selectFirst=select.substring(0,1).toUpperCase( );
/***************************************************************************************/
      if(bombsArray[row][column]!=Runner.BSIZE  && selectFirst.equals("S")) {//bomba olmayan kutular için set
       	 if(bombsArray[row][column]==0 )  
	     {
	    	/*****************Boşlukların Komşularından olanları bul *****/  
	    	   String[] nearB= nearBox(row,column)	;
			   int nearBSum=Integer.parseInt(nearB[9]);
			   for(int ii=0;ii<nearBSum;ii++)
			   {  	
				  injn=Runner.findNumberfromIJ(Integer.parseInt(nearB[ii].substring(1,4)));
				  in=injn[0];
				  jn=injn[1];
				  if(bombsArray[in][jn]!=100) {
					  if(bombsArray[in][jn]==0) 
					  {
						 sightBombsArray[in][jn]=" ";
						 
						 String[] nearB1= nearBox(in,jn)	;
						 int nearBSum1=Integer.parseInt(nearB1[9]);
						 int[] injn1;
						 int in1;
						 int jn1;
						 for(int i=0;i<nearBSum1;i++)
						 {  	
							  injn1=Runner.findNumberfromIJ(Integer.parseInt(nearB1[i].substring(1,4)));
							  in1=injn1[0];
							  jn1=injn1[1];
							  if(bombsArray[in1][jn1]!=100) {
							  	  if(bombsArray[in1][jn1]==0) 
								  {
							  		  sightBombsArray[in1][jn1]=" "; 
							  	/********************************************************/
//							  		  System.out.println("in1:" + in1 +" jn1:"+jn1);
//							  		 String[] nearB11= nearBox(in1,jn1)	;
//									 int nearBSum11=Integer.parseInt(nearB11[9]);
//									 int[] injn11;
//									 int in11;
//									 int jn11;
//									 for(int i11=0;i11<nearBSum11;i11++)
//									 {  	
//										  injn11=Runner.findNumberfromIJ(Integer.parseInt(nearB11[i].substring(1,4)));
//										  in11=injn11[0];
//										  jn11=injn11[1];
//										  if(bombsArray[in11][jn11]!=100) {
//										  	  if(bombsArray[in11][jn11]==0) 
//											  {
//										  		  sightBombsArray[in11][jn11]=" "; 
//											  }
//										  	  else
//										  	  {sightBombsArray[in11][jn11]=String.valueOf(bombsArray[in11][jn11]);}	 
//										  }
//									 }
								 
							  /********************************************************/
								  }
							  	  else
							  	  {sightBombsArray[in1][jn1]=String.valueOf(bombsArray[in1][jn1]);}	 
							     
							  }
							 
						 }
						 	 
					  }
					  else
					  {
						  sightBombsArray[in][jn]=String.valueOf(bombsArray[in][jn]);
					  
					  }
				  }
			 }
		/************************************************************/	   
	      }
       	 else if(bombsArray[row][column]!=100 ) {
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
//				if(ii==i && jj==j) {}
//				else
//				{
				//System.out.println("a :"+a );
					n[a]=Runner.findIJfromNumber(ii,jj);
					if(!n[a].equals(null))  summ++;
					a++;
					
				//}
			}
		 }
		 n[9]=String.valueOf(summ);
		
		return n;
	}

}
