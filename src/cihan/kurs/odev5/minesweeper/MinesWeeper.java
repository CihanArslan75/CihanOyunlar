package cihan.kurs.odev5.minesweeper;

import java.text.DecimalFormat;

import java.text.NumberFormat;
import java.util.Scanner;

public class MinesWeeper {
	
	public  void  playMW() {
		Scanner sc=new Scanner(System.in);
		int[]   ijBomb = new int[2]; 
		int row;
		int column;
		boolean playEnd=true;
		String selectFirst;
		BombsArray b=new BombsArray();
		b.setBombsArray();
		int[][] bArray =b.getBombsArray();

		b.setSightBombsArray();
		String[][] bSightArray   =b.getSightBombsArray();
		
		int[][] bControlArray =b.getBombsControlArray();
		
		mwDraw(bSightArray);
		
				
		do{  	int sum=0;
			 System.out.println("Seçiminizi S ile Bombaları B ile Giriniz.Çıkmak için X tuşuna Basınız. !!");
			 String select = sc.next();
			 selectFirst=select.substring(0,1).toUpperCase( );
			 
			 if(select.equals("x") || select.equals("X")) 
			 {  
				System.out.println("Oyundan Çıktınız ! ");
				playEnd=false;	
			    break;
				 
			  } 
			 
			 for(int i=0; i<Runner.SIZE;i++) {
				 for(int j=0; j<Runner.SIZE;j++) {
					 if(bControlArray[i][j]==1) sum++;
				 }
			 }
			 
					 
			 if( select.length()>4 ) 
			 {
				 System.out.println("Seçiminiz Yanlış1!");
				 continue;
			 }
		
			 int selectInt=Integer.parseInt((select.substring(1,4)));
			 if(selectInt>=Runner.BSIZE ) 
			 {
				 System.out.println("Seçiminiz Yanlış1!");
				 continue;
			 }
			 
			 if(!selectFirst.equals("S")  && !selectFirst.equals("B")) 	 
			 {
				 System.out.println("Seçiminiz Yanlış1!");
				 continue;
			 }
			 			 
			 ijBomb=Runner.findNumberfromIJ(selectInt);
			 row=ijBomb[0];
			 column=ijBomb[1];
			 			 
		  	 b.setSightBombsArray(select,row,column);	
		  		  
		  	 if(bArray[row][column]==Runner.BSIZE  &&  selectFirst.equals("S") ) 
		  	 {
		   		 System.out.println("Yandınız");
		   		 playEnd=false;
		   		break;
		   	 }
		   	 else
		   	 {   
		   		 mwDraw(bSightArray);
		   	 }
		  	 
		  	 if(sum== (Runner.BSIZE-1))  {
				 System.out.println("Tebrikler Kazandınız !");
				 playEnd=false;
				 break;
			 }
		}while(playEnd);
		sc.close();
     	
		
	}
	
	/******************************************************/	
	public  void mwDraw(String[][] bSightArray) {
	
		for(int i=0;i<Runner.SIZE;i++) {
			for(int j =0;j<Runner.SIZE;j++) {
				System.out.printf("%5s",bSightArray[i][j]+" ");
				//System.out.print(bSightArray[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
