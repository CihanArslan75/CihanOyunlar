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
	    		else if(getDamaArray(i,j)==oyuncuDama()) {
	    			secilebilirHamleArray[k]=findStonefromij(i,j);
	    			k++;
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
		System.out.print("Yapılabilecek Hamleler :");
		int sum=0;
		if(getDamaArray(i, j)==Runner.oyuncu) {
			String ktek = null;
			hamleShowArray=hamleBul(i,j);  // hamleType 0 ise normal 1 ise dama
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
		}
		else if(getDamaArray(i, j)==oyuncuDama())
		{
			hamleShowArray=damaHamleBul(i,j);  // hamleType 0 ise normal 1 ise dama
			for (int k = 0; k < hamleShowArray.length; k++) {
				if(hamleShowArray[k]!=null) {
					System.out.print(hamleShowArray[k] +"  ");
					sum++;
				}
			}
			System.out.println();
						
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
		setDamaArray(ii,jj, getDamaArray(i, j));
		setDamaArray(i,j, 0) ;
		
	}
	
	
	public String[] hamleBul(int i, int j ) {
		String[] hamleFindArray=new String[10];
	  	
		if(Runner.oyuncu==1 && getDamaArray(i, j)==Runner.oyuncu) {
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
		else if( Runner.oyuncu==2 && getDamaArray(i, j)==Runner.oyuncu)
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
		else if(getDamaArray(i, j)== 11 || getDamaArray(i, j)==22)
		{
			
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
	
	public String[] damaHamleBul(int i,int j) {
		String[] damaHamleFindArray=new String[20];
		int k=0;
	  	if(getDamaArray(i, j)==11 || getDamaArray(i, j)==22)  {
	  		
	  		for (int ii = i; ii >=0; ii--) {
				if((ii-1)<0) {
					break;
				}
				else
				{
					if(getDamaArray(ii-1, j)==0) damaHamleFindArray[k]=findStonefromij(ii-1,j);
					k++;
				}
			
			}
	  		for (int ii = i; ii < Runner.uzunluk; ii++) {
				if((ii+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{  
					if(getDamaArray(ii+1, j)==0) damaHamleFindArray[k]=findStonefromij(ii+1,j);
					k++;
				}
	  			
		    }
	  		for (int jj = j; jj >=0; jj--) {
	  			if((jj-1)<0) {
					break;
				}
				else
				{
					if(getDamaArray(i, jj-1)==0) damaHamleFindArray[k]=findStonefromij(i,jj-1);
					k++;
				}
		    }
	  		for (int jj = j; jj < Runner.uzunluk; jj++) {
	  			if((jj+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{
					if(getDamaArray(i, jj+1)==0) damaHamleFindArray[k]=findStonefromij(i,jj+1);
					k++;
				}
		    }
	  		
		
		}
//	  	System.out.println("dama");
//		for (int k2 = 0; k2 < damaHamleFindArray.length; k2++) {
//			System.out.print(damaHamleFindArray[k2]+" ");
//		}
//	  	System.out.println("");
		return damaHamleFindArray;
	}
	
	public int oyuncuDama() {
		if(Runner.oyuncu==1) return 11;
		else  return 22;
	}
		
 }
