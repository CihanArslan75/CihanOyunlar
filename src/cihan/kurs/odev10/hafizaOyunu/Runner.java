package cihan.kurs.odev10.hafizaOyunu;

import java.util.Random;

public class Runner {
	public static int satirSayisi=8;
	public static String path="C:\\Users\\Cihan\\Desktop\\Cihan\\HazifaOyunu";
	
	public static void main(String[] args) {
		HfzGiris hfzGiris = new HfzGiris();
		hfzGiris.setVisible(true);
		//HfzOyna h =new HfzOyna("cihan",1);
		//h.setVisible(true);
	}
	
	
	public static int getRandomNumber1(){
		Random rand = new Random(); 
		int min=0;
		int max=(Runner.satirSayisi/2)-1;
		
		int x= (rand.nextInt((max - min) + 1) +min);
		
		while(x<min || x>max)  {
			x =(rand.nextInt((max - min) + 1)+min);
		}
		
		return x;
	}
	
	public static int getRandomNumber2(){
		Random rand = new Random(); 
		int min=Runner.satirSayisi/2;
		int max=Runner.satirSayisi-1;
		
		int x= rand.nextInt(((max - min) + 1)+min);
		
		while(x<min || x>max)  {
			x =(rand.nextInt((max - min) + 1)+min);
		}
		
		return x;
	}

}
