package cihan.kurs.odev7.dama;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DamaSecilebilirHamle extends Dama{
	
	private String[] secilebilirHamleArray=new String[16]; 
	
	public String[] secilebilirHamleYap() {
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
	    			//------burası düzelecek
	    			secilebilirHamleArray[k]=findStonefromij(i,j);
	    			k++;
	    		}
	      }
		}
		return secilebilirHamleArray;
	}
	
	
	public void secilebilirHamleYaz() {
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
	
	
	public void hamleYap(String hamleSon,String hamleIlk ) {
		
		int[] damaStoneSon= new int[2];
		int[] damaStoneIlk= new int[2];
		damaStoneSon= findIJfromStone(hamleSon);
		int ii=damaStoneSon[0];
		int jj=damaStoneSon[1];
		damaStoneIlk= findIJfromStone(hamleIlk);
		int i=damaStoneIlk[0];
		int j=damaStoneIlk[1];
		if(Runner.oyuncu==1 && ii==7 ) setDamaArray(ii,jj, oyuncuDama()); else setDamaArray(ii,jj, getDamaArray(i, j));
		if(Runner.oyuncu==2 && ii==0 ) setDamaArray(ii,jj, oyuncuDama()); else setDamaArray(ii,jj, getDamaArray(i, j));
		setDamaArray(i,j, 0) ;
		if(getDamaArray(ii, jj)==11 || getDamaArray(ii, jj)==22 ) { damaHamleYap(hamleSon,hamleIlk); }
		
	}
	
	
	public String[] hamleBul(int i, int j ) {
		String[] hamleFindArray=new String[10];
	  	
		if(Runner.oyuncu==1 && getDamaArray(i, j)==Runner.oyuncu) {
			//System.out.println("hamleBulq");
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
			{   //System.out.println("hamleBul2:"+" i:"+i +" j:"+j);
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

		Set<String> damaHamleFindArray = new HashSet<String>();
		
	  	if(getDamaArray(i, j)==11 || getDamaArray(i, j)==22)  {
	  		
	  		for (int ii = i; ii >=0; ii--) {
				if((ii-1)<0) {
					break;
				}
				else
				{   if(getDamaArray(ii-1, j)==0) {
						damaHamleFindArray.add(findStonefromij(ii-1,j)) ;
						
				    }
				}
				if((ii-2)<0) {
					break;
				}
				else if(getDamaArray(ii-1, j)==0 && getDamaArray(ii-2, j)!=0) 
				{
					damaHamleFindArray.add( findStonefromij(ii-1,j)) ;
				
				}
				}
			
			}
	  		for (int ii = i; ii < Runner.uzunluk; ii++) {
				
	  			if((ii+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{  
				if(getDamaArray(ii+1, j)==0 ) {
					damaHamleFindArray.add(findStonefromij(ii+1,j)) ;
				 
				}
	  			if((ii+2)>Runner.uzunluk-1) {
					break;
				}
				else
				{  
					if(getDamaArray(ii+1, j)==0 && getDamaArray(ii+2, j)!=0) {
						damaHamleFindArray.add( findStonefromij(ii+1,j)) ;
				   
				    }
					
				}
	  			
		    }
	  		for (int jj = j; jj >=0; jj--) {
	  			if((jj-1)<0) {
					break;
				}
				else
				{   if(getDamaArray(i, jj-1)==0)
			    	{
					damaHamleFindArray.add( findStonefromij(i,jj-1)) ;
				}
				}
	  			if((jj-2)<0) {
					break;
				}
				else
				{   if(getDamaArray(i, jj-1)==0 && getDamaArray(i, jj-2)!=0)
			    	{
					damaHamleFindArray.add( findStonefromij(i,jj-1)) ;
					}
				}
		    }
	  		for (int jj = j; jj < Runner.uzunluk; jj++) {
	  			if((jj+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{   if(getDamaArray(i, jj+1)==0 ) 
			    	{damaHamleFindArray.add( findStonefromij(i,jj+1)) ;
					}
				}
	  			if((jj+2)>Runner.uzunluk-1) {
					break;
				}
				else
				{   if(getDamaArray(i, jj+1)==0 && getDamaArray(i, jj+2)!=0) 
			    	{damaHamleFindArray.add(findStonefromij(i,jj+1)) ;
					}
				}
		    }
	  		
		
		}
//	  	System.out.println("dama");
//		for (int k2 = 0; k2 < damaHamleFindArray.length; k2++) {
//			System.out.print(damaHamleFindArray[k2]+" ");
//		}
//	  	System.out.println("");
	  	String[] damaHamleFindArray1 =new String[50];
	  	int k=0;
	  	 for(String damaHamleFindArrayX : damaHamleFindArray) {
	           damaHamleFindArray1[k]=damaHamleFindArrayX ;
	           k++;
		}
	  		
		return damaHamleFindArray1;
	}
	
	public void damaHamleYap(String damaLast,String damaFisrt) {
		int[] damaStoneFirst= new int[2];
		int[] damaStoneLast= new int[2];
		damaStoneFirst= findIJfromStone(damaFisrt);
		int iF=damaStoneFirst[0];
		int jF=damaStoneFirst[1];
		damaStoneLast= findIJfromStone(damaLast);
		int iL=damaStoneLast[0];
		int jL=damaStoneLast[1];
	   
	  	if(getDamaArray(iL, jL)==11 || getDamaArray(iL, jL)==22)  {
	  		
	  		for (int ii = iF; ii >iL; ii--) {
				if((ii-1)<0) {
					break;
				}
				else
				{
					if(getDamaArray(ii, jL)==oyuncuDama() || getDamaArray(ii, jL)==digerOyuncu())  {
						
						setDamaArray(ii, jF, 0);
						setDamaArray(iL, jL, oyuncuDama());
					}
				}
			
			}
	  		for (int ii = iF; ii < iL; ii++) { 
				if((ii+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{  
					if(getDamaArray(ii, jL)==oyuncuDama() || getDamaArray(ii, jL)==digerOyuncu())  {
					   setDamaArray(ii, jF, 0);
					   setDamaArray(iL, jL, oyuncuDama());
					}
				}
	  			
		    }
	  		for (int jj = jF; jj >=iL; jj--) { 
	  			if((jj-1)<0) {
					break;
				}
				else
				{
					if(getDamaArray(iL, jj)==oyuncuDama() || getDamaArray(iL, jj)==digerOyuncu())  {
					   setDamaArray(iF, jj, 0);
					   setDamaArray(iL, jL, oyuncuDama());
					}
				}
		    }
	  		for (int jj = jF; jj < jL; jj++) {
	  			if((jj+1)>Runner.uzunluk-1) {
					break;
				}
				else
				{
					if(getDamaArray(iL, jj)==oyuncuDama() || getDamaArray(iL, jj)==digerOyuncu())  {
					   setDamaArray(iF, jj, 0);
					   setDamaArray(iL, jL, oyuncuDama());
					}
				}
		    }
	  		
		
		}

	}
	
	public  int digerOyuncu() {
		int p = 0;
			if(Runner.oyuncu==1) p=2;
			else if(Runner.oyuncu==2) p=1;
		return p;
	}
	
	public  int digerOyuncuDama() {
		int p = 0;
			if(Runner.oyuncu==1) p=22;
			else if(Runner.oyuncu==2) p=11;
		return p;
	}
	
	public int oyuncuDama() {
		if(Runner.oyuncu==1) return 11;
		else  return 22;
	}
		
 }
