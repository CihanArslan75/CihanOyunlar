package cihan.kurs.odev7.dama;

public class DamaZorunluHamle extends DamaSecilebilirHamle{
	
	private String[] zorunluHamleArray=new String[16]; 
	
	public String zorunluHamleYap1() {
		
		String[] zorunluHamleBArray=new String[1];
		zorunluHamleBArray[0]=null;
		String a=null;
		for (int i = 0; i < Runner.uzunluk;i++) {
	    	for (int j = 0; j < Runner.uzunluk;j++) {
	    		if(getDamaArray(i,j) == Runner.oyuncu) {
	    			
	    			/*********** zorunlu hamle  hamleler ******************/
	    			zorunluHamleBArray=zorunluHamle(i,j);
	    			if(zorunluHamleBArray[0]!=null) {
	    				System.out.println(Runner.oyuncu +".Oyuncunun Zorunlu hamlesi var."+ zorunluHamleBArray[0] +" Zorunlu Hamle Yapıldı.");
	    				damaCiz();
	    				a= zorunluHamleBArray[0];
	    			} 
	    			
				}
			}
	    }
		return a;
	}
	

	public String zorunluHamleYap2() {
	   	String[] zorunluHamleBArray=new String[1];
		zorunluHamleBArray[0]=null;
		String a = null;
		for (int i =Runner.uzunluk-1 ; i >= 0;i--) {
	    	for (int j = 0; j < Runner.uzunluk;j++) {
	    		//System.out.println("i:"+i+"  j"+j);  
	    		 if(getDamaArray(i,j)==Runner.oyuncu) {
	    			/*********** zorunlu hamle  hamleler ******************/
	    			zorunluHamleBArray=zorunluHamle(i,j);
	    			if(zorunluHamleBArray[0]!=null) {
	    				System.out.println(Runner.oyuncu +".Oyuncunun Zorunlu hamlesi var."+ zorunluHamleBArray[0] +" Zorunlu Hamle Yapıldı.");
	    				 a= zorunluHamleBArray[0];
	    				damaCiz();
	    			} 
	    			
				}
			}
	    }
		
		return a;
	}
	public String[] zorunluHamle(int i, int j ) {
	    int digerOyuncu=digerOyuncu();	  	
	    zorunluHamleArray[0]=null;
		if(Runner.oyuncu==1) {
			if((i+2)<8 ) {
				if( getDamaArray(i,j)==Runner.oyuncu && getDamaArray(i+1,j)==digerOyuncu && getDamaArray(i+2,j)==0) {
					setDamaArray(i,j, 0);
					setDamaArray(i+1,j, 0);
					if((i+2)==7) setDamaArray(i+2,j, oyuncuDama());  else setDamaArray(i+2,j,1); 
					zorunluHamleArray[0]=findStonefromij(i,j);
					
				}
			}
			if((j-2)>=0 ) { 
				if( getDamaArray(i,j)==Runner.oyuncu && getDamaArray(i,j-1)==digerOyuncu && getDamaArray(i,j-2)==0 ) {
					setDamaArray(i,j, 0);
					setDamaArray(i,j-1, 0);
					setDamaArray(i,j-2,Runner.oyuncu);
				    zorunluHamleArray[0]=findStonefromij(i,j);	
				}
			}
			if((j+2)<8 ) { 
				if( getDamaArray(i,j)==Runner.oyuncu && getDamaArray(i,j+1)==digerOyuncu && getDamaArray(i,j+2)==0) {
					setDamaArray(i,j, 0);
					setDamaArray(i,j+1, 0);
					setDamaArray(i,j+2, Runner.oyuncu);
					zorunluHamleArray[0]=findStonefromij(i,j);	
				}
			}
			
			
		 }  
		else if( Runner.oyuncu==2 )
		{	if((i+2)<8 ) { 
			if( getDamaArray(i,j)==Runner.oyuncu &&  getDamaArray(i-1,j)==digerOyuncu && getDamaArray(i-2,j)==0) {
				
				setDamaArray(i,j, 0);
				setDamaArray(i-1,j, 0);
				if((i-2)==0) setDamaArray(i-2,j,oyuncuDama());  else setDamaArray(i-2,j, 2);
				zorunluHamleArray[0]=findStonefromij(i,j);
				
				}
		}
			
			if((j-2)>=0 ) { 
				if( getDamaArray(i,j)==Runner.oyuncu &&  getDamaArray(i,j-1)==digerOyuncu && getDamaArray(i,j-2)==0 && (j-1)>=0 && (j-2)>=0) {
					setDamaArray(i,j, 0);
					setDamaArray(i,j-1, 0);
					setDamaArray(i,j-2, Runner.oyuncu);
				    zorunluHamleArray[0]=findStonefromij(i,j);	
				}
			}
			if((j+2)<8 ) { 
			    if( getDamaArray(i,j)==Runner.oyuncu &&  getDamaArray(i,j+1)==digerOyuncu && getDamaArray(i,j+2)==0) {
			    	setDamaArray(i,j, 0);
			    	setDamaArray(i,j+1, 0);
			    	setDamaArray(i,j+2, Runner.oyuncu);
					zorunluHamleArray[0]=findStonefromij(i,j);	
				}
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

		return zorunluHamleArray;
		
	}
	


}
