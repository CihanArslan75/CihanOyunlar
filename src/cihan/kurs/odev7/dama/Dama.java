package cihan.kurs.odev7.dama;

public class Dama {
	private int[][] damaArray=new int[8][8];
	
	public void setDamaArrayIlk() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i==0 && (j==1 || j==3 || j==5|| j==7)) damaArray[i][j]=1; 
				if(i==1 && (j==0 || j==2 || j==4|| j==6)) damaArray[i][j]=1;
				if(i==2 && (j==1 || j==3 || j==5|| j==7)) damaArray[i][j]=1; 
				if(i==5 && (j==0 || j==2 || j==4|| j==6)) damaArray[i][j]=3; 
				if(i==6 && (j==1 || j==3 || j==5|| j==7)) damaArray[i][j]=3;
				if(i==7 && (j==0 || j==2 || j==4|| j==6)) damaArray[i][j]=3;
				
			}
		}
		
		 this.damaArray=damaArray;
	}
	
	public void DamaCiz() {
		System.out.println("--------------------------");
		for(int i=0;i<8;i++) {
			System.out.print("|");
			for(int j=0;j<8;j++) {
				 if(damaArray[i][j]==1 )  System.out.print(" # ");
				 else if(damaArray[i][j]==3 )  System.out.print(" & ");
				 else System.out.print(" . ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("--------------------------");
	}

}
