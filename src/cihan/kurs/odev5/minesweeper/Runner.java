package cihan.kurs.odev5.minesweeper;




public class Runner {

	public static final int SIZE=10;
	public static final int BSIZE=SIZE*SIZE;
	public static final int BOMBCOUNT=2*SIZE;
	
	
	public static void main(String[] args) {
		
		MinesWeeper mw=new  MinesWeeper() ;
		mw.playMW();
	}
	   
	/*********************************************************************/		
	public static int[] findNumber(int a) {
        //Statik array için Gelen sayıya 1. ve 2. idisini bulur /
	  int[] ij =new int[2];	
	  ij[0]=a/Runner.SIZE;
	  ij[1]=a%Runner.SIZE;
	  return ij;
	}
	
	
	public static int[] sort(int[] bomb ) {
		int temp;
		int bombArrayNumber=bomb[0];
		
		for(int i=0 ; i<Runner.BOMBCOUNT;i++) {
			for(int j=i;j<Runner.BOMBCOUNT;j++) {
				if(bomb[j]<bombArrayNumber) 
				{
					temp=bombArrayNumber;
					bomb[i]=bomb[j];
					bomb[j]=temp;
				}
				bombArrayNumber=bomb[i];
			 }
			
			//System.out.print(bombArray[i]+" ");
		}
		
		return bomb; 
	}
	
	
	public static int getRandomNumber(){
	    int x =(int)(Math.random() *((Runner.SIZE*Runner.SIZE)-1)+1);
	    return x;
	}
	
	
}
