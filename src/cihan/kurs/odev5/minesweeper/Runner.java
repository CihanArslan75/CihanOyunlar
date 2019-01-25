package cihan.kurs.odev5.minesweeper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Runner {

	public static int SIZE=10;
	public static  int BSIZE=SIZE*SIZE;
	public static  int BOMBCOUNT=2*SIZE;
	
	
	public static void main(String[] args) {
//		NumberFormat formatter = new DecimalFormat("000");
//		int numberMW=0;
//		for(int ii=0;ii<SIZE;ii++) {
//			for(int jj=0;jj<SIZE;jj++) {
//				System.out.print("S"+formatter.format( numberMW)+" ");
//				 numberMW++;				
//			}
//			
//			System.out.println();
//		 }
//		  NumberFormat formatter = new DecimalFormat("000");
//	      String number ="S" + formatter.format( Integer.parseInt((String.valueOf(1) + String.valueOf(8))));
//		System.out.println(number);
//		BombsArray b=new BombsArray();
//		   String[] nearB= b.nearBox(3,9)	;
//           
//           for(int ij=0;ij<10;ij++) {
//        	   System.out.println("a:"+nearB[ij]);
//           }
//		   
	    MinesWeeper mw=new  MinesWeeper() ;
		mw.playMW();
	
	}
	   
	/*********************************************************************/		
	public static int[] findNumberfromIJ(int a) {
        //Statik array için Gelen sayıya 1. ve 2. idisini bulur /
	  int[] ij =new int[2];	
	  ij[0]=a/SIZE;
	  ij[1]=a%SIZE;
	  return ij;
	}
	
	public static String findIJfromNumber(int i,int j) {
        // Gelen i ve j den Snumarasını bulur /
		  NumberFormat formatter = new DecimalFormat("000");
	      String number ="S" + formatter.format( Integer.parseInt((String.valueOf(i) + String.valueOf(j))));	
	   return number;
	}
	
	public static int[] sort(int[] bomb ) {
		int temp;
		int bombArrayNumber=bomb[0];
		
		for(int i=0 ; i<Runner.BOMBCOUNT;i++) {
			for(int j=i;j<Runner.BOMBCOUNT;j++) {
				if(bomb[j]<bombArrayNumber) 
				{
					temp=bombArrayNumber;
					bomb[i]=bomb[j];
					bomb[j]=temp;
				}
				bombArrayNumber=bomb[i];
			 }
		}
		
		return bomb; 
	}
	
	
	public static int getRandomNumber(){
	    int x =(int)(Math.random() *((Runner.SIZE*Runner.SIZE)-1)+1);
	    return x;
	}
	
	
}
