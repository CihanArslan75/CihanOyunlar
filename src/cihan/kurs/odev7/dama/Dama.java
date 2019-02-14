package cihan.kurs.odev7.dama;

public class Dama {
	
	private int[][] damaArray=new int[8][8];
	
	public Dama() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i==1 || i==2 ) damaArray[i][j]=1; 
				if(i==5 || i==6 ) damaArray[i][j]=2; 
			}
		}
    }
	 
	public int getDamaArray(int i , int j) {
		return damaArray[i][j];
	}

	public void setDamaArray(int i, int j,int damaArrayDeger) {
		this.damaArray[i][j] = damaArrayDeger;
	
	}

	public void damaCiz() {
		int a=0;
		System.out.println("   A  B  C  D  E  F  G  H ");
		System.out.println("  ------------------------");
		for(int i=0;i<8;i++) {
			System.out.print(++a);
			System.out.print("|");
			for(int j=0;j<8;j++) {
				 if(damaArray[i][j]==1 )  System.out.print(" b ");
				 else if(damaArray[i][j]==2 )  System.out.print(" s ");
				 else if(damaArray[i][j]==11 )  System.out.print(" B ");
				 else if(damaArray[i][j]==22 )  System.out.print(" S ");
				 else System.out.print(" . ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("  ------------------------");
		System.out.println("   A  B  C  D  E  F  G  H ");
	}
	
	public String findStonefromij(int i, int j){
		// Gelen i ve j ile taşı bulur
		String stone = null;
		     if(j==0) stone="A"+(i+1);
		else if(j==1) stone="B"+(i+1);
		else if(j==2) stone="C"+(i+1);
		else if(j==3) stone="D"+(i+1);
		else if(j==4) stone="F"+(i+1);
		else if(j==5) stone="E"+(i+1);
		else if(j==6) stone="G"+(i+1);
		else if(j==7) stone="H"+(i+1);
		else
			try {
				throw new Exception("Hatalı indis");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return stone;
	}
	
	public int[] findIJfromStone(String hamle) {
     // Gelen taşa göre i ve j bulur
	  int[] ij =new int[2];	
	  String a=hamle.substring(0,1).toUpperCase();
	  ij[0]=Integer.parseInt(hamle.substring(1,2))-1;
	       if(a.equals("A")) ij[1]=0;
	  else if(a.equals("B")) ij[1]=1;
	  else if(a.equals("C")) ij[1]=2;
	  else if(a.equals("D")) ij[1]=3;
	  else if(a.equals("E")) ij[1]=4;
	  else if(a.equals("F")) ij[1]=5;
	  else if(a.equals("G")) ij[1]=6;
	  else if(a.equals("H")) ij[1]=7;
	  else {
		  try {
			throw new Exception("Hatalı Taş");
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  return ij;
	}
	
	
	
}
