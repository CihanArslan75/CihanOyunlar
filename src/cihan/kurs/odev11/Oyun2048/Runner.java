package cihan.kurs.odev11.Oyun2048;

import java.util.Random;

public class Runner {
	
	public static int satirSayisi=4;

	public static void main(String[] args) {
		Oyun2048 o = new Oyun2048();
		o.setVisible(true);
	}
	
	public static int getRandomNumber(){
		Random rand = new Random(); 
		int min=0;
		int max=(Runner.satirSayisi*Runner.satirSayisi)-1;
		
		int x= (rand.nextInt((max - min) + 1) +min);
		
		while(x<min || x>max)  {
			x =(rand.nextInt((max - min) + 1)+min);
		}
		
		return x;
	}

}
