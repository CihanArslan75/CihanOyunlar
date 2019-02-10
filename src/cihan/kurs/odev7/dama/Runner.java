package cihan.kurs.odev7.dama;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Runner {
	
	public static int player=1; //1  ve 2 nolu oyuncu

	public static void main(String[] args) {
	DamaGame dama=new DamaGame();
	System.out.println("Çıkış için x Giriniz !" );
	dama.damaDraw();
		
	Scanner sc = new Scanner(System.in);
	Boolean ex=true;
	Boolean damaControl;
	Boolean damaImperativeControl;
	String input;
	String hamleArray[]= new String[10];
	String hamleimpCon;
	
	do{
		
		int hamleCount=0;
		
		if(player==1) 
		{
			hamleimpCon=dama.hamleImpFind1();
		} 
		else 
		{
			hamleimpCon=dama.hamleImpFind2();
			
		}
		
		//damaImperativeControl =dama.hamleImperativeControl(player);
		
		if(hamleimpCon==null) {
		
		   dama.hamlePlayableShow();
  	  	   dama.hamlePlayableDraw();
		   
		   input=sc.nextLine().toUpperCase();
		   if(input.equals("X"))
			{  
				System.out.println("Çıkış Yaptınız !! ");
				ex=false;
				break;
			}
		  
		    damaControl=dama.hamleControl(input);
			if(!damaControl)  
			{
				System.out.println("Yanlış Hamle Yaptınız ...!!!!   Tekrar Hamle Yapınız ...!!!");
			    input=sc.nextLine().toUpperCase();
			    hamleCount=dama.hamleShow(input);
			   
			    if( hamleCount==1) {
			    	dama.damaDraw();
			    	//playerChange();
			    }
			    else
			    {
			    	System.out.println("Hamle Yapınız ...!!!");
				    String input1=sc.nextLine().toUpperCase();
				    damaControl=dama.hamleControl(input);
				    dama.hamleDo(input1,input);
				    dama.damaDraw();
			    	//playerChange();
				    
			    }
			}
			else 
			{  
				 hamleCount=dama.hamleShow(input);
				
				 if( hamleCount>1) {
				   	System.out.println("Hamle Yapınız ...!!!");
				    String input2=sc.nextLine().toUpperCase();   
				    damaControl=dama.hamleControl(input);
				    dama.hamleDo(input2,input);
				    
				 }
				dama.damaDraw(); 
				//playerChange();
				
			}
			
		}
		//dama.damaDraw();
		
		playerChange();
	   		
	}while(ex);

	}

	private static void playerChange() {
		if(player==1) player=2;
		else if(player==2) player=1;
	}

}
