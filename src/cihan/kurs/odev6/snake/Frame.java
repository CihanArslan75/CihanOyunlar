package cihan.kurs.odev6.snake;

public class Frame extends Snake{
	protected int size=25;
	protected int bsize=(size*2)-1;
	private String[][] frameArray= new String[size][bsize]; 
	private int xSnake=getRandomNumber();
	private int ySnake=getRandomNumber();
	private int xFood=getRandomNumber();
	private int yFood=getRandomNumber();
	
	private int xSnakeFirst=xSnake;
	private int ySnakeFirst=ySnake;
	
	public Frame() {
		//System.out.println("Frame Constructor");
		setFrame();
		setFrameInSnake();
		setFrameInFood();
		drawFrame();
	}

	
	public void setFrame() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<bsize;j++) {
				if(j%2 == 0) frameArray[i][j]=".";
				if(j%2 > 0) frameArray[i][j]=" ";
				if(i==0 || i==(size-1) || j==0 || j==(bsize-1) ) frameArray[i][j]="+";		
			}
		}	
	}
	
	public void setFrameInSnake() {
		String[] snakeArray=setSnake(4);
		//System.out.println("a:"+ " xSnake:"+xSnake+ " ySnake :"+ySnake);
		for(int ii=0;ii<snakeSize*2;ii=ii+2)
		{  
			if(ii%2 == 0) {
				frameArray[xSnake][ySnake+ii]=snakeArray[ii/2];
			}
		}		
	}
	
	public void setFrameInSnakeDown() {
		String[] snakeArray=setSnake(2);
		//System.out.println("b:"+ " xSnake:"+xSnake+ " ySnake :"+ySnake);
		//System.out.println("b:"+ " xSnakeFirst:"+xSnakeFirst+ " ySnakeFirst :"+ySnakeFirst);
		for(int ii=0;ii<snakeSize;ii++)
		{  	frameArray[xSnake][ySnake]=".";
		   
		   if(xSnake==xSnakeFirst)	 {
		    	if(ii==0)
				{				
				   	frameArray[xSnake+1][ySnake+2]=snakeArray[ii];
				}
		    	xSnakeFirst=xSnake;
		    	ySnakeFirst=ySnake;
		    } 
		   else 
		   {
		    	if(ii==0)
				{				
				  frameArray[xSnake+1][ySnake+2]=snakeArray[ii];
				}
		    	else 
		    	{ frameArray[xSnake][ySnake+2]=snakeArray[ii];
		          frameArray[xSnakeFirst][ySnakeFirst+8]=".";
		          
		    	}
		    }
		    
		
		}
		 if(xSnake!=xSnakeFirst)
		 { 
			 ySnakeFirst=ySnakeFirst-2;
		 }	
		 xSnake=xSnake+1;
			
	}
	
	public void setFrameInSnakeUp() {
		String[] snakeArray=setSnake(8);
		System.out.println("b:"+ " xSnake:"+xSnake+ " ySnake :"+ySnake);
		System.out.println("b:"+ " xSnakeFirst:"+xSnakeFirst+ " ySnakeFirst :"+ySnakeFirst);
		
		for(int ii=0;ii<snakeSize;ii++)
		{  	frameArray[xSnake][ySnake]=".";
		   
		   if(xSnake==xSnakeFirst)	 {
		    	if(ii==0)
				{				
				   	frameArray[xSnake-1][ySnake+2]=snakeArray[ii];
				}
		    	xSnakeFirst=xSnake;
		    	ySnakeFirst=ySnake;
		    } 
		   else 
		   {
		    	if(ii==0)
				{				
				  frameArray[xSnake-1][ySnake+2]=snakeArray[ii];
				}
		    	else 
		    	{ frameArray[xSnake][ySnake+2]=snakeArray[ii];
		          frameArray[xSnakeFirst][ySnakeFirst+8]=".";
		          
		    	}
		    }
		    
		
		}
		 if(xSnake!=xSnakeFirst)
		 { 
			 ySnakeFirst=ySnakeFirst-2;
		 }	
		 xSnake=xSnake-1;
			
	}
	public void setFrameInSnakeLeft() {
		String[] snakeArray=setSnake(4);
		int k=2;
		for(int ii=0;ii<snakeSize;ii++)
		{  	System.out.println("xSnake:" +xSnake +" ySnake:"+ySnake);
		  	frameArray[xSnake][ySnake+(ii*2)-k]=snakeArray[ii];
			
		}
		frameArray[xSnakeFirst][ySnakeFirst+8]=".";
		ySnakeFirst=ySnakeFirst-2;
		ySnake=ySnake-2;
		
    }
	
	public void setFrameInSnakeRight() {
		String[] snakeArray=setSnake(6);
		int k=2;
		for(int ii=0;ii<snakeSize;ii++)
		{  	System.out.println("xSnake:" +xSnake +" ySnake:"+ySnake);
		  	frameArray[xSnake][ySnake+(ii*2)-k]=snakeArray[ii];
			
		}
		frameArray[xSnakeFirst][ySnakeFirst+8]=".";
		ySnakeFirst=ySnakeFirst-2;
		ySnake=ySnake-2;
		
    }
	
	public void setFrameInFood() {
		boolean go=true;
		if (xFood==xSnake && yFood==ySnake)  go=false;
		
		//do{
			xFood=getRandomNumber();
			yFood=getRandomNumber();
		//}while(go);
		
		frameArray[xFood][yFood]="*";	
	}
  
	
	public void drawFrame() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<bsize;j++) {
				System.out.print(frameArray[i][j]);
			}
			System.out.println();
		}
	}
	
	public  int getRandomNumber(){
		int a=(int)(Math.random() *(size-8)+3);
		 while (!evenNumber(a)) {   //çift seçmeye çalışıyor
	            a = (int)(Math.random() *(size-8)+3);
	        }
	    return a;
	}
	
	 public static boolean evenNumber(int number) {
	        return (number % 2) == 0;
	    }

	

}
