package cihan.kurs.odev7.dama;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Runner {
	
	public static int oyuncu=1; //1  ve 2 nolu oyuncu
	public static int uzunluk=8;
	
	public static void main(String[] args) {
	
	DamaZorunluHamle dama=new DamaZorunluHamle();
	
	System.out.println("Çıkış için x Giriniz !" );
	
	dama.damaCiz();
			
	Scanner sc = new Scanner(System.in);
	Boolean ex=true;
	Boolean damaKontrol;
	String input;
	String zorunluHamleKontrol;
	
	do{
		
		int hamleCount=0;
		
		
		if(oyuncu==1) 
		{ 	
			zorunluHamleKontrol=dama.ZorunluhamleYap1();
		} 
		else 
		{ 
			zorunluHamleKontrol=dama.ZorunluhamleYap2();
			
		}
		
		if(zorunluHamleKontrol==null) {
		
		   dama.secilebilirhamleYap();
  	  	   dama.SecilebilirHamleYaz();
		   
		   input=sc.nextLine().toUpperCase();
		   if(input.equals("X"))
			{  
				System.out.println("Çıkış Yaptınız !! ");
				ex=false;
				break;
			}
		  
		    damaKontrol=dama.hamleKontrol(input);
			if(!damaKontrol)  
			{
				System.out.println("Yanlış Hamle Yaptınız ...!!!!   Tekrar Hamle Yapınız ...!!!");
			    input=sc.nextLine().toUpperCase();
			    hamleCount=dama.hamleGoster(input);
			   
			    if( hamleCount==1) {
			    	dama.damaCiz();
			    	//oyuncuDegistir();
			    }
			    else
			    {
			    	System.out.println("Hamle Yapınız ...!!!");
				    String input1=sc.nextLine().toUpperCase();
				    damaKontrol=dama.hamleKontrol(input);
				    dama.hamleYap(input1,input);
				    dama.damaCiz();
			    	//oyuncuDegistir();
				    
			    }
			}
			else 
			{  
				 hamleCount=dama.hamleGoster(input);
				
				 if( hamleCount>1) {
				   	System.out.println("Hamle Yapınız ...!!!");
				    String input2=sc.nextLine().toUpperCase();   
				    damaKontrol=dama.hamleKontrol(input);
				    dama.hamleYap(input2,input);
				    
				 }
				dama.damaCiz(); 
				//oyuncuDegistir();
				
			}
			
		}
		//dama.damaDraw();
		oyuncuDegistir();
	   		
	}while(ex);

	}

	public static void oyuncuDegistir() {
		if(oyuncu==1) oyuncu=2;
		else if(oyuncu==2) oyuncu=1;
	}
	
	public static int digerOyuncu() {
		int p = 0;
			if(oyuncu==1) p=2;
			else if(oyuncu==2) p=1;
		return p;
	}

}
