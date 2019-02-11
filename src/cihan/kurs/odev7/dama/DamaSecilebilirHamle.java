package cihan.kurs.odev7.dama;

public class DamaSecilebilirHamle extends Dama{
	
	private String[] secilebilirHamleArray=new String[16]; 
	
	public String[] secilebilirhamleYap() {
		String[] hamleFindArray=new String[20];
		int k=0;
		for (int i = 0; i < Runner.uzunluk;i++) {
	    	for (int j = 0; j < Runner.uzunluk;j++) {
	    		if(getDamaArray(i,j)==Runner.oyuncu) {
	    			  hamleFindArray =hamleBul(i,j);
						for (int jj = 0; jj < hamleFindArray.length; jj++) {
							if(hamleFindArray[jj]!=null) 
							{ 
							  secilebilirHamleArray[k]= findStonefromij(i,j);
							  k++;
							  break;
							}
						}
						
	             }
	      }
		}
		return secilebilirHamleArray;
	}
	
	
	public void SecilebilirHamleYaz() {
		System.out.print(Runner.oyuncu +".Oyuncunun Seçebileceğiniz Hamleler :" );
		for (int i = 0; i < secilebilirHamleArray.length; i++) {
			if(secilebilirHamleArray[i]!=null) System.out.print(secilebilirHamleArray[i]+"  ");
		}
	}
	
	
	
	public boolean hamleKontrol(String hamle) {
		for (int i = 0; i < secilebilirHamleArray.length; i++) {
			if(hamle.equals(secilebilirHamleArray[i]))
			{ 
				return true;
			}
		}
		
		return false;
	}
	
	
	public int hamleGoster(String hamle) {
		String[] hamleShowArray= new String[10];
		int[] damaStone= new int[2];
		damaStone =findIJfromStone(hamle);
		int i=damaStone[0];
		int j=damaStone[1];
	    int damaSHamle=getDamaArray(i,j);
		int hamleType=0;
		hamleShowArray=hamleBul(i,j);  // hamleType 0 ise normal 1 ise dama
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
			hamleYap(ktek,hamle);
			System.out.println("Hamle Yapıldı !!!!!!");	
		}else {
			
		} 
		
		return sum;
	}
	
	
	public void hamleYap(String hamleFirst,String hamleLast ) {
		int[] damaStoneFirst= new int[2];
		int[] damaStoneLast= new int[2];
		damaStoneFirst= findIJfromStone(hamleFirst);
		int ii=damaStoneFirst[0];
		int jj=damaStoneFirst[1];
		damaStoneLast= findIJfromStone(hamleLast);
		int i=damaStoneLast[0];
		int j=damaStoneLast[1];
		setDamaArray(i,j, 0) ;
		setDamaArray(ii,jj, Runner.oyuncu);
	}
	
	
	public String[] hamleBul(int i, int j ) {
		String[] hamleFindArray=new String[10];
	  	
		if(Runner.oyuncu==1) {
			if(j==0 ) 
			{  
				if(getDamaArray(i,j+1)==0) hamleFindArray[0]=findStonefromij(i,j+1);
				if(getDamaArray(i+1,j)==0) hamleFindArray[1]=findStonefromij(i+1,j);
			}
			else if(j==7 ) 
			{  
				if(getDamaArray(i,j-1)==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(getDamaArray(i+1,j)==0) hamleFindArray[1]=findStonefromij(i+1,j);
			}
			else
			{
				if(getDamaArray(i,j-1)==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(getDamaArray(i,j+1)==0) hamleFindArray[1]=findStonefromij(i,j+1);
				if(getDamaArray(i+1,j)==0) hamleFindArray[2]=findStonefromij(i+1,j);
			}
		}
		else if( Runner.oyuncu==2)
		{
			if(j==0) 
			{
				if(getDamaArray(i-1,j)==0) hamleFindArray[0]=findStonefromij(i-1,j);
				if(getDamaArray(i,j+1)==0) hamleFindArray[1]=findStonefromij(i,j+1);
			}
			else if(j==7  ) 
			{
				if(getDamaArray(i-1,j)==0) hamleFindArray[0]=findStonefromij(i-1,j);
				if(getDamaArray(i,j-1)==0) hamleFindArray[1]=findStonefromij(i,j-1);
			}
			else
			{
				if(getDamaArray(i,j-1)==0) hamleFindArray[0]=findStonefromij(i,j-1);
				if(getDamaArray(i,j+1)==0) hamleFindArray[1]=findStonefromij(i,j+1);
				if(getDamaArray(i-1,j)==0) hamleFindArray[2]=findStonefromij(i-1,j);
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
	
	

	
	
		
 }
