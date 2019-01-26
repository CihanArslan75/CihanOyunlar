package cihan.kurs.odev7.dama;

public abstract class Dama {
	
	public static int[][] damaArray=new int[8][8];
	
	static {
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(i==1 || i==2 ) damaArray[i][j]=1; 
					if(i==5 || i==6 ) damaArray[i][j]=2; 
				}
			}
		}
	
	public abstract void DamaCiz() ;
	public abstract String[] HamleGoster(String hamle,String type);

}
