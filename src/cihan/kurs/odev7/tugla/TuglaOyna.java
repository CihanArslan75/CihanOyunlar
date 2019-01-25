package cihan.kurs.odev7.tugla;

import java.util.Scanner;

public class TuglaOyna {
	
	private String tuglaArray[][];
	
	public TuglaOyna() throws InterruptedException {
		Tugla t=new Tugla();
		t.setTugla();
	    t.setTuglaBas(0) ;
	    tuglaArray =t.getTugla();
	    t.TuglaAlaniCiz(tuglaArray);
	    System.out.println();
	    int hamleSayisi=0;
	    int seviye=1;
		Scanner sc=new Scanner(System.in);
		boolean cikis=true;
		do { 
			if(hamleSayisi>6) {
				 t.setTuglaBas(1) ;
				 hamleSayisi=0;
			 }
			System.out.println("Ateşi Hareket Ettirmek için  4 ← , 6 → Tuşlarını Kullanınız ! Ateş etmek için 8 tuşunu , Oyundan Çıkmak için 0 Seçiniz");
			System.out.println("1.Seviye Puan:"+t.puan);
			int secim=sc.nextInt();
			
			if(secim==4) {
				t.setTuglaSol();
				tuglaArray =t.getTugla();
				t.TuglaAlaniCiz(tuglaArray);
			}
			else if(secim==6) 
			{
				t.setTuglaSag();
				tuglaArray =t.getTugla();
				t.TuglaAlaniCiz(tuglaArray);
			}
			else if(secim==8) 
			{
				t.setTuglaAtes();
				tuglaArray =t.getTugla();
				t.TuglaAlaniCiz(tuglaArray);
			}
			else if(secim==0)
			{   cikis=false;
				System.out.println("Oyundan Çıktınız !!!!");
			}
			else
			{
				System.out.println("Seçiminiz Yanlış !!!!");
			}
			hamleSayisi++;
		}
		while(cikis);
	    
	}
	
	
	
	
	
	
	

}
