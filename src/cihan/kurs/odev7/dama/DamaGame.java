package cihan.kurs.odev7.dama;

public class DamaGame extends Dama {
	
	@Override
	public void damaDraw() {
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
	public String[] hamlePlayableShow() {
		String[] hamleFindArray=new String[20];
		int k=0;
	    for (int i = 0; i < damaArray.length; i++) {
	    	for (int j = 0; j < damaArray.length; j++) {
	    		if(damaArray[i][j]==Runner.player) {
					hamleFindArray =hamleFind(i,j);
					for (int jj = 0; jj < hamleFindArray.length; jj++) {
						if(hamleFindArray[jj]!=null) 
						{ 
						  hamlePlayableArray[k]= findStonefromij(i,j);
						  k++;
						  break;
						}
					}
				}
			}
	    }
		return hamlePlayableArray;
	}
	
	@Override
	public void hamlePlayableDraw() {
		System.out.print(Runner.player +".Oyuncunun Seçebileceğiniz Hamleler :" );
		for (int i = 0; i < hamlePlayableArray.length; i++) {
			if(hamlePlayableArray[i]!=null) System.out.print(hamlePlayableArray[i]+"  ");
		}
	}
	
	
	@Override
	public boolean hamleControl(String hamle) {
		for (int i = 0; i < hamlePlayableArray.length; i++) {
			if(hamle.equals(hamlePlayableArray[i]))
			{ 
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hamleShow(String hamle) {
		String[] hamleShowArray= new String[10];
		int[] damaStone= new int[2];
		damaStone =findIJfromStone(hamle);
		int i=damaStone[0];
		int j=damaStone[1];
	    int damaSHamle=damaArray[i][j];
		int hamleType=0;
		hamleShowArray=hamleFind(i,j);  // hamleType 0 ise normal 1 ise dama
		int sum=0;
		String ktek = null;
		System.out.print("Yapılabilecek Hamleler :");
		for (int k = 0; k < hamleShowArray.length; k++) {
			if(hamleShowArray[k]!=null) {
				System.out.print(hamleShowArray[k] +"  ");
				ktek=hamleShowArray[k];
				sum++;
			}
		}
		System.out.println();
					
		if(sum==1) {
			hamleDo(ktek,hamle);
		}else {
			
		}
		
		return sum;
	}
	
	@Override
	public void hamleDo(String hamleFirst,String hamleLast ) {
		int[] damaStoneFirst= new int[2];
		int[] damaStoneLast= new int[2];
		damaStoneFirst= findIJfromStone(hamleFirst);
		int ii=damaStoneFirst[0];
		int jj=damaStoneFirst[1];
		damaStoneLast= findIJfromStone(hamleLast);
		int i=damaStoneLast[0];
		int j=damaStoneLast[1];
		damaArray[i][j] =  0 ;
		damaArray[ii][jj] =  Runner.player;
	}
	
	@Override
	public String[] hamleFind(int i, int j ) {
		String[] hamleFindArray=new String[10];
	
		if(Runner.player==1) {
			if(j==0 ) 
			{  
				if(damaArray[i][j+1]==0) hamleFindArray[0]=findStonefromij(i,j+1);
				if(damaArray[i+1][j]==0) hamleFindArray[1]=findStonefromij(i+1,j);
			}
			else if(j==7 ) 
			{  
				if(damaArray[i][j-1]==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(damaArray[i+1][j]==0) hamleFindArray[1]=findStonefromij(i+1,j);
			}
			else
			{
				if(damaArray[i][j-1]==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(damaArray[i][j+1]==0) hamleFindArray[1]=findStonefromij(i,j+1);
				if(damaArray[i+1][j]==0) hamleFindArray[2]=findStonefromij(i+1,j);
			}
		}
		else if( Runner.player==2)
		{
			if(j==0 ) 
			{
				if(damaArray[i-1][j]==0) hamleFindArray[0]=findStonefromij(i-1,j);
				if(damaArray[i][j+1]==0) hamleFindArray[1]=findStonefromij(i,j+1);
			}
			else if(j==7 ) 
			{
				if(damaArray[i-1][j]==0) hamleFindArray[0]=findStonefromij(i-1,j);
				if(damaArray[i][j-1]==0) hamleFindArray[1]=findStonefromij(i,j-1);
			}
			else
			{
				if(damaArray[i][j-1]==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(damaArray[i][j+1]==0) hamleFindArray[1]=findStonefromij(i,j+1);
				if(damaArray[i-1][j]==0) hamleFindArray[2]=findStonefromij(i-1,j);
			}
		}
		else
		{
			try {
				throw new Exception("Hatalı Oyuncu");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return hamleFindArray;
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
