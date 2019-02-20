package cihan.kurs.odev11.Oyun2048;

import java.util.Random;

public class Runner {
	
	public static int satirSayisi=4;

	public static void main(String[] args) {
		Oyun2048 o = new Oyun2048();
		o.setVisible(true);
	
	}
	
	public static int[] getRandomNumber(){
		Random rand = new Random(); 
		int min=0;
		int max=(Runner.satirSayisi)-1;
		int x[] = new int[2];
		
		x[0]= (rand.nextInt((max - min) + 1) +min);
		
		while(x[0]<min || x[0]>max)  {
			x[0] =(rand.nextInt((max - min) + 1)+min);
		}
		
	   x[1]= (rand.nextInt((max - min) + 1) +min);
		
		while(x[1]<min || x[1]>max)  {
			x[1] =(rand.nextInt((max - min) + 1)+min);
		}
		
		return x;
	}
	
	public static int getRandom_2_4(){
		Random rand = new Random(); 
		int min=2;
		int max=4;
		
		int x= (rand.nextInt((max - min) ) +min);
		
		while(x<min || x>max || x==3)  {
			x =(rand.nextInt((max - min) +1)+min);
		}
		
		return x;
	}

}
