package cihan.kurs.odev6.snake;

public class Frame extends Snake{
	protected int size=25;
	protected int bsize=(size*2)-1;
	public String[][] frameArray= new String[size][bsize]; 
	public  int xSnake=getRandomNumber();
	public  int ySnake=getRandomNumber();
	private int xFood;
	private int yFood;
	private int xSnakeTail=xSnake;
	private int ySnakeTail=ySnake+8;
	
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
		String[] snakeArray=setSnakeFisrt();
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
		if(frameArray[xSnake][ySnake].equals("◄") && frameArray[xSnake][ySnake+2].equals("■") )
		{ 
			frameArray[xSnake][ySnake]=".";
			xSnake=xSnake+1;
			ySnake=ySnake;
			frameArray[xSnake-1][ySnake]=snakeArray[1];	
			frameArray[xSnake][ySnake]="▼";	
			
			
		}
		else if(frameArray[xSnake][ySnake].equals("◄"))
		{   
			frameArray[xSnake][ySnake]=".";
			xSnake=xSnake+1;
			ySnake=ySnake+2;
			frameArray[xSnake][ySnake]="▼";	
		}
		else
		{   
			frameArray[xSnake+1][ySnake]=snakeArray[0];
			frameArray[xSnake][ySnake]=snakeArray[1];
			xSnake=xSnake+1;
			ySnake=ySnake;
			
		}
		snakeTailControl(2);
		if(xSnake==xFood && ySnake==yFood)  snakeFeed(2);
	}
	
	public void setFrameInSnakeUp() {
		String[] snakeArray=setSnake(8);
//		if(frameArray[xSnake][ySnake].equals("◄"))
//		{
//			frameArray[xSnake][ySnake]=".";
//			xSnake=xSnake-1;
//			ySnake=ySnake;
//			frameArray[xSnake][ySnake]="▲";
//					
//		}
//		else
//		{   
			frameArray[xSnake-1][ySnake]=snakeArray[0];
			frameArray[xSnake][ySnake]=snakeArray[1];
			xSnake=xSnake-1;
			ySnake=ySnake;
					
//		}
		snakeTailControl(8);
		if(xSnake==xFood && ySnake==yFood)  snakeFeed(8);
			
	}
	public void setFrameInSnakeLeft() {
		String[] snakeArray=setSnake(4);
		frameArray[xSnake][ySnake-2]=snakeArray[0];
		frameArray[xSnake][ySnake]=snakeArray[1];
		ySnake=ySnake-2;
		snakeTailControl(4);
		if(xSnake==xFood && ySnake==yFood)  snakeFeed(4);
	}
	
	public void setFrameInSnakeRight() {
		String[] snakeArray=setSnake(6);
	    frameArray[xSnake][ySnake+2]=snakeArray[0];
	    frameArray[xSnake][ySnake]=snakeArray[1];
	    ySnake=ySnake+2;
		snakeTailControl(6);
		if(xSnake==xFood && ySnake==yFood)  snakeFeed(6);
    }
	
	public void setFrameInFood() {
		xFood=getRandomNumber();
		yFood=getRandomNumber();
		boolean ex=true;
//		do {
//		if (xFood>xSnake || xFood<xSnake)  
//		{}	
//		else
//		{	
		if (xFood==xSnake && ( yFood==ySnake || yFood==ySnake+2 || yFood==ySnake+4 || yFood==ySnake+6 || yFood==ySnake+8) ) 
		{
			xFood=getRandomNumber();
		    yFood=getRandomNumber();
		}
	
//
//		}while(ex);
		
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
	 
	
	 public void snakeTailControl(int number) {
		 int summ=0;
		 boolean ex=false;
		 boolean firstDown=false;
		 
		 for(int i=1;i<size-1;i++) {
			 	for(int j=2;j<bsize-1;j++) {
			 		if( frameArray[i][j]=="■")  
			 			//System.out.println("i: "+i +" j:"+j);
			 			summ++;
			 	}
		 }
			 		
		 for(int i=1;i<size-1;i++) {
			if(ex==true) break;
		 	for(int j=2;j<bsize-1;j++) {
		 		
				 if( number==2 ) {
				  if( frameArray[i][j].equals("@"))  
					 {    
						 if(frameArray[i-1][j].equals("■")  && frameArray[i][j+2].equals("■")) {
							  frameArray[i][j]=".";
							  frameArray[i-1][j]="@";
							  setSnakeTail(i-1,j);
							  ex=true;
							  break;
						 }
						 else if(frameArray[i+1][j]=="■" )
				          {   
				              frameArray[i][j]=".";
							  frameArray[i+1][j]="@";
							  setSnakeTail(i+1,j);
							  ex=true;
							  break;
				          }
						 
						 else if(frameArray[i][j+2].equals("■") )
				          {   
				              frameArray[i][j]=".";
							  frameArray[i][j+2]="@";
							  setSnakeTail(i,j+2);
							  ex=true;
							  break;
				          }
						 else if(frameArray[i-1][j]=="■" )
				          {   
				              frameArray[i][j]=".";
							  frameArray[i-1][j]="@";
							  setSnakeTail(i-1,j);
							  ex=true;
							  break;
				          }
					      else
					      {	
					    	 if((summ+2)>snakeSize) 
					    	  { 				    		
					    		  frameArray[i][j-2]="@"; 
					    		  setSnakeTail(i,j-2);
					    		  frameArray[i][j]="."; 
					    	  }
					    	  else
					    	  {
					    		  frameArray[i][j]="@";
					    		  setSnakeTail(i,j);
					    	  }
					    	 ex=true;
							 break;
					      }
					 }
					
				 }
				 if(number==4) 
				 {
				  if( frameArray[i][j].equals("@"))  
				  {	
					  if(frameArray[i+1][j].equals("■")  && frameArray[i][j+2].equals("■"))
			          {   
				    	  frameArray[i][j]=".";
						  frameArray[i][j+2]="@";
						  setSnakeTail(i,j+2);
						  ex=true;
						  break;	  
			          }
					  if(frameArray[i+1][j].equals("■") )
			          {   
				    	  frameArray[i][j]=".";
						  frameArray[i+1][j]="@";
						  setSnakeTail(i+1,j);
						  ex=true;
						  break;	  
			          }
					 else if(frameArray[i][j+2].equals("■") )
			          {   
				    	  frameArray[i][j]=".";
						  frameArray[i][j+2]="@";
						  setSnakeTail(i,j+2);
						  ex=true;
						  break;	  
			          }
					 else if(frameArray[i-1][j].equals("■")  )
			          {   
				    	  frameArray[i][j]=".";
						  frameArray[i-1][j]="@";
						  setSnakeTail(i-1,j);
						  ex=true;
						  break;	  
			          }
					 else  {
						  frameArray[i][j]=".";
						  frameArray[i][j-2]="@";
						  setSnakeTail(i,j-2);
						  ex=true;
						  break;
					     }
					 }
				 }
				 
				 if(number==6) 
				 {  
					 
				    if( frameArray[i][j].equals("@"))  
					 {	 
						 if(frameArray[i+1][j].equals("■") && frameArray[i][j-2].equals("■") )
			             {   
				             frameArray[i][j]=".";
							 frameArray[i][j-2]="@";
							 setSnakeTail(i,j-2);
							 ex=true;
							 break;
			             } 
						 else if(frameArray[i-1][j].equals("■") && frameArray[i][j-2].equals("■") )
			             {   
				             frameArray[i][j]=".";
							 frameArray[i][j-2]="@";
							 setSnakeTail(i,j-2);
							 ex=true;
							 break;
			             } 
					    else if(frameArray[i-1][j].equals("■") )
			             {   
				             frameArray[i][j]=".";
							 frameArray[i-1][j]="@";
							 setSnakeTail(i-1,j);
							 ex=true;
							 break;
			             } 
						 else  if(frameArray[i][j+2].equals("■") )
				          {   
					    	 frameArray[i][j]=".";
							 frameArray[i][j+2]="@";
							 setSnakeTail(i,j+2);
							 ex=true;
							 break;	  
				          }
						 else  if(frameArray[i+1][j].equals("■") )
				          {   
					    	 frameArray[i][j]=".";
							 frameArray[i+1][j]="@";
							 setSnakeTail(i+1,j);
							 ex=true;
							 break;	  
				          }
						 
						 
					     else
					     {  frameArray[i][j]=".";
							frameArray[i][j-2]="@";
							setSnakeTail(i,j-2);
							ex=true;
							break;
					    }
					 }
				
				 }

				 if( number==8 ) {
												
					 if( frameArray[i][j].equals("@"))  
					 {    
						  if(frameArray[i-1][j].equals("■") && frameArray[i][j-2].equals("■") )
				          {   
							  frameArray[i][j]=".";
							  frameArray[i][j-2]="@";
							  setSnakeTail(i,j-2);
							  ex=true;
							  break;	  
				          }
						 else if(frameArray[i][j+2].equals("■") && frameArray[i+1][j].equals("■") )
				          {   
							  frameArray[i][j]=".";
							  frameArray[i+1][j]="@";
							  setSnakeTail(i+1,j);
							  ex=true;
							  break;	  
				          }
						 else if(frameArray[i-1][j]=="■" )
				          {   //System.out.println("aa");
							 frameArray[i][j]=".";
							  frameArray[i-1][j]="@";
							  setSnakeTail(i-1,j);
							  ex=true;
							  break;	  
				          }
						 else if(frameArray[i][j+2].equals("■") )
				          {   //System.out.println("bb");
							  frameArray[i][j]=".";
							  frameArray[i][j+2]="@";
							  setSnakeTail(i,j+2);
							  ex=true;
							  break;	  
				          }
						 
						  else if(frameArray[i+1][j].equals("■") )
				          {   
							  frameArray[i][j]=".";
							  frameArray[i+1][j]="@";
							  setSnakeTail(i+1,j);
							  ex=true;
							  break;	  
				          }
					      else 
					      {	 if((summ+2)>snakeSize) 
					    	  { 
					    		  frameArray[i][j-2]="@"; 
					    		  setSnakeTail(i,j-2);
					    		  frameArray[i][j]="."; 
					    	  }
					    	  else
					    	  {
					    		  frameArray[i][j]="@";
					    		  setSnakeTail(i,j);
					    	  }
					    	 ex=true;
							 break;
					     }
					 }
				}	 
		 	}
		 	
		 }	
	 }
	 
	 public void snakeFeed(int number)
	 {  //System.out.println("aaaaa:"+ "xSnake:"+xSnake+" xFood:"+xFood +" ySnake: "+ySnake+" "+yFood +" xSnakeTail :"+xSnakeTail+" ySnakeTail:"+ySnakeTail);
		 if(number==2)
		 { 	 if(xSnake==xFood && ySnake==yFood) 
			 {   //System.out.println("a:"+xSnake +" "+ySnake);
				 frameArray[xSnakeTail][ySnakeTail]="■";
				 frameArray[xSnakeTail-1][ySnakeTail]="@";
				 setFrameInFood();
				 setSnakeSize();
			 }
		 }
		 if(number==4)
		 { 	 if(xSnake==xFood && ySnake==yFood) 
			 {   //System.out.println("a:"+xSnake +" "+ySnake);
			     frameArray[xSnakeTail][ySnakeTail]="■";
			     frameArray[xSnakeTail][ySnakeTail+2]="@";
				 setFrameInFood();
				 setSnakeSize();
			 }
		 }
		 if(number==6)
		 { 	 if(xSnake==xFood && ySnake==yFood) 
			 {   //System.out.println("a:"+xSnake +" "+ySnake);
			     frameArray[xSnakeTail][ySnakeTail]="■";
			     frameArray[xSnakeTail][ySnakeTail-2]="@";
				 setFrameInFood();
				 setSnakeSize();
			 }
		 }
		 if(number==8)
		 {
			 if(xSnake==xFood && ySnake==yFood) 
			 { 
				 frameArray[xSnakeTail][ySnakeTail]="■";
				 frameArray[xSnakeTail+1][ySnakeTail]="@";
				 setFrameInFood();
				 setSnakeSize();
			 }
		 }
	 }
	 
	 public void setSnakeTail(int row, int column) {
		  xSnakeTail=row;
		  ySnakeTail=column;
		  //System.out.println("a:"+ " xSnakeTail:"+row+ " ySnakeTail :"+column); 
		}
	

}
