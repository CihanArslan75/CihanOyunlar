package cihan.kurs.swing.minesweeper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JFrame;

public class RunnerM  {
 
	public static int SIZE=10;
	public static  int BSIZE=SIZE*SIZE;
	public static  int BOMBCOUNT= 9 ; //2*SIZE;

	public static void main(String[] args) {
		MinesWeeperSwing mws = new MinesWeeperSwing();	
		mws.MinesWeeperSwingStart();
	}
	
	
	/***************************************************** nb****************/		
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
		
		for(int i=0 ; i<RunnerM.BOMBCOUNT;i++) {
			for(int j=i;j<RunnerM.BOMBCOUNT;j++) {
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
	    int x =(int)(Math.random() *((RunnerM.SIZE*RunnerM.SIZE)-1)+1);
	    return x;
	}
	
	
}
