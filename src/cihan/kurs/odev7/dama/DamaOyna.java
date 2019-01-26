package cihan.kurs.odev7.dama;

public class DamaOyna extends Dama {

	@Override
	public void DamaCiz() {
		int a=0;
		System.out.println("   A  B  C  D  E  F  G  H ");
		System.out.println("  ------------------------");
		for(int i=0;i<8;i++) {
			System.out.print(++a);
			System.out.print("|");
			for(int j=0;j<8;j++) {
				 if(damaArray[i][j]==1 )  System.out.print(" b ");
				 else if(damaArray[i][j]==2 )  System.out.print(" s ");
				 else System.out.print(" . ");
			}
			System.out.print("|");
			System.out.print(a);
			System.out.println();
		}
		System.out.println("  ------------------------");
		System.out.println("   A  B  C  D  E  F  G  H ");
	}
	
	@Override
	public String[] HamleGoster(String hamle,String type) {
		String[] hamleArray= new String[10];
		int bforfront=4;  // 4 ve büyükler
		int sforfront=5; // 5 ve küçükler
		if(type=="b") 
		{
			
		}
		
		
		return hamleArray;
	}
	
	public int[] findNumberfromIJ(String a) {
     // Gelen sayıya 1. ve 2. idisini bulur /
	  int[] ij =new int[2];	
	  if(a.substring(1,1).toUpperCase()=="A") ij[1]=0;
	  else if(a.substring(1,1).toUpperCase()=="B") ij[1]=0;
	  else if(a.substring(1,1).toUpperCase()=="C") ij[1]=1;
	  else if(a.substring(1,1).toUpperCase()=="D") ij[1]=2;
	  else if(a.substring(1,1).toUpperCase()=="E") ij[1]=3;
	  else if(a.substring(1,1).toUpperCase()=="F") ij[1]=4;
	  else if(a.substring(1,1).toUpperCase()=="G") ij[1]=5;
	  else if(a.substring(1,1).toUpperCase()=="H") ij[1]=6;
	  ij[0]=Integer.parseInt(a.substring(1,1));
	  return ij;
	}
	
 }
