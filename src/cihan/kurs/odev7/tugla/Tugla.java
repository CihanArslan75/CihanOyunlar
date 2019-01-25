package cihan.kurs.odev7.tugla;

public class Tugla {
	public static int tuglaSatirBoyut=15;
	public static int tuglaSutunBoyut=15;
	public static int puan=0;
	
	private String[][] tugla=new String[tuglaSatirBoyut][tuglaSutunBoyut];

	public String[][] getTugla() {
		return tugla;
	}
	public void setTugla() {
		for(int i=0;i<tugla.length;i++) {
			for(int j=0;j<tugla[0].length;j++) {
				if(j==0 || j== (tugla[0].length-1) ) tugla[i][j]="|";
				else tugla[i][j]=" . ";
			}
		}
	this.tugla = tugla;
	}
	
	
    public void setTuglaBas(int i) {
    	int x1=getRandomNumber();
    	int x2=getRandomNumber(x1);
    	tugla[i][x1]="###";
    	tugla[i][x2]="###";
    	if(i==0) tugla[tugla.length-1][tugla[0].length-10]="[O]";
    	this.tugla = tugla;
	}
    
    public void setTuglaSol() {
    	for(int j=0 ; j<tuglaSutunBoyut-1;j++)
    	{
    	  if(tugla[tuglaSatirBoyut-1][j].equals("[O]")) 
    	  {   tugla[tuglaSatirBoyut-1][j]=" . ";
    		  tugla[tuglaSatirBoyut-1][j-1]="[O]";
    	  }
    
    	}
		this.tugla = tugla;
	}
    
    public void setTuglaSag() {
    	for(int j=0 ; j<tuglaSutunBoyut-1;j++)
      	{
      	  if(tugla[tuglaSatirBoyut-1][j].equals("[O]")) 
      	  {   tugla[tuglaSatirBoyut-1][j]=" . ";
      		  tugla[tuglaSatirBoyut-1][j+1]="[O]";
      		  break;
      	  }
      	  
      	}
  		this.tugla = tugla;
  	}
    
    
    public void setTuglaAtes() throws InterruptedException {
    	for(int i=0 ; i<tuglaSatirBoyut-1;i++)
      	{
    		for(int j=0 ; j<tuglaSutunBoyut-1;j++)
          	{
	      	  if(tugla[tuglaSatirBoyut-1][j].equals("[O]") && tugla[i][j].equals("###") ) 
	      	  {   tugla[i][j]=" O ";
	      	      tugla[tuglaSatirBoyut-1][j]="[ ]";
	      	      puan++;
	      	      TuglaAlaniCiz(tugla);
	      	      Thread.sleep(1000);
	      	      tugla[i][j]=" . ";
	      	      tugla[tuglaSatirBoyut-1][j]="[O]";
	      		  break;
	      	  }
          	}
      	}
  		this.tugla = tugla;
  	}
    
    public int getRandomNumber(){
    	boolean tamam=true;
    	int x; 
    	do {
       	  x =(int)(Math.random() *((tuglaSutunBoyut)-1)+1);
       	  if(x!=0) tamam=false;
   	    }while(tamam);
    	 
    	return x;
	}
    
    public int getRandomNumber(int x1){
    	boolean tamam=true;
    	int x;
	    do {
    	  x =(int)(Math.random() *((tuglaSutunBoyut)-2)+1);
    	  if(x!=x1)
    	  {
    	     if( x!=tuglaSutunBoyut)
    	    	 {
    	    	    tamam=false;
    	    	 }
    	  }
	    }while(tamam);
	    return x;
	}
    
    public void TuglaAlaniCiz(String[][] tuglaArray) {
    	  System.out.println();
		for(int i=0;i<tuglaArray.length;i++) {
			for(int j=0;j<tuglaArray[0].length;j++) {
				System.out.print(tuglaArray[i][j]);
			}
			System.out.println();
		}
	}	
    
	

    

}
