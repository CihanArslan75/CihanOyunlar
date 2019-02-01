package cihan.kurs.odev6.snake;
 
import cihan.kurs.odev8.CihanLinkedList.CihanLinkedList;

public class Frame extends Snake{
	protected int size=15;
	public int[][] frameArray= new int[size][size]; 
    public  int xSnake=getRandomNumber();
	public  int ySnake=getRandomNumber();
	private int xFood;
	private int yFood;
	private int xSnakeTail=xSnake;
	private int ySnakeTail=ySnake+(snakeSize-1);
	
	public Frame() {
		setFrame();
		setFrameInSnake();
		setFrameInFood();
		drawFrame();
	}

	
	public void setFrame() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				frameArray[i][j]=1;
			}
		}	
	}
	
	public void setFrameInSnake() {
		CihanLinkedList snakeArray=setSnakeFirst();
		for(int ii=0;ii<snakeSize;ii++)
		{  
			frameArray[xSnake][ySnake+ii]=(int) snakeArray.get(ii);
		} 
	}

	
	public void setFrameInSnakeDown() {
		if(frameArray[xSnake][ySnake]!=2) 	setSnake(2);
		
		frameArray[xSnake][ySnake]=snakeArray.getFirst().next.data;
		frameArray[xSnake+1][ySnake]=snakeArray.getFirst().data;
		setSnakeHead(xSnake+1,ySnake);
		
		if(xSnake==xFood && ySnake==yFood)  
			snakeFeed(2);
		else 
			snakeTailControl(2);
	}
 	
	public void setFrameInSnakeUp() {
		if(frameArray[xSnake][ySnake]!=8) setSnake(8);
		frameArray[xSnake-1][ySnake]=snakeArray.getFirst().data;
		frameArray[xSnake][ySnake]=snakeArray.getFirst().next.data;
		setSnakeHead(xSnake-1,ySnake);
		
		if(xSnake==xFood && ySnake==yFood)  
			snakeFeed(8);
		else
			snakeTailControl(8);
			
	}
	
	public void setFrameInSnakeLeft() {
		if(frameArray[xSnake][ySnake]!=4) setSnake(4);
		frameArray[xSnake][ySnake-1]=snakeArray.getFirst().data;
		frameArray[xSnake][ySnake]=snakeArray.getFirst().next.data;
		setSnakeHead(xSnake,ySnake-1);
		if(xSnake==xFood && ySnake==yFood)  
			snakeFeed(4);
		else
			snakeTailControl(4);
	}
	
	public void setFrameInSnakeRight() {
		if(frameArray[xSnake][ySnake]!=6) setSnake(6);
	    frameArray[xSnake][ySnake+1]=snakeArray.getFirst().data;
	    frameArray[xSnake][ySnake]=snakeArray.getFirst().next.data;
	    setSnakeHead(xSnake,ySnake+1);
		
		if(xSnake==xFood && ySnake==yFood) 
			snakeFeed(6);
		else 
			snakeTailControl(6);
    }
	
	public void setFrameInFood() {
		boolean ex=true;
    
		  do { 	xFood=getRandomNumber();
				yFood=getRandomNumber();
				if(frameArray[xFood][yFood]==1 ) ex=false;
		  }while(ex);
		
		frameArray[xFood][yFood]=0;	
	}
	
	public void drawFrame() {
			System.out.println("-----------------------------------------------");
			for(int i=0;i<size;i++) {
				System.out.print("|");
				for(int j=0;j<size;j++) {
					      if(frameArray[i][j] == 0 ) System.out.print(" * ");
					 else if(frameArray[i][j] == 1 ) System.out.print(" . ");
					 else if(frameArray[i][j] == 2 ) System.out.print(" ▼ ");
					 else if(frameArray[i][j] == 3 ) System.out.print(" ■ ");
					 else if(frameArray[i][j] == 4 ) System.out.print(" ◄ ");
					 else if(frameArray[i][j] == 6 ) System.out.print(" ► ");
					 else if(frameArray[i][j] == 8 ) System.out.print(" ▲ ");
					 else if(frameArray[i][j] == 9 ) System.out.print(" @ ");
					 
				}
				System.out.print("|");
				System.out.println();
			}
			System.out.println("-----------------------------------------------");
	}
	
	
	 public void snakeTailControl(int number) throws ArrayIndexOutOfBoundsException{
	
		 int summ=0;
		 for(int i=1;i<size-1;i++) {
			 	for(int j=2;j<size-1;j++) {
			 		if( frameArray[i][j]==3)  
			 			summ++;
			 	}
		 }
			 		
		 int i=xSnakeTail;
		 int j=ySnakeTail;
		 if( number==2 ) { 
			 if(frameArray[i-1][j]==3  && frameArray[i][j+1]==3) 
			 {
			   frameArray[i][j]=1;
			   frameArray[i-1][j]=9;
			   setSnakeTail(i-1,j);
			 }
			 else if(frameArray[i-1][j]==3  && frameArray[i][j-1]==2) 
			 {
			   frameArray[i][j]=1;
			   frameArray[i-1][j]=9;
			   setSnakeTail(i-1,j);
		     }
			 else if(frameArray[i-1][j]==3  && frameArray[i][j-1]==3) 
			 {
			   frameArray[i][j]=1;
			   frameArray[i-1][j]=9;
			   setSnakeTail(i-1,j);
		     }
			 else if(frameArray[i+1][j]==3  )
			 {   
				frameArray[i][j]=1;
				frameArray[i+1][j]=9;
				setSnakeTail(i+1,j);
             }
		     else if(frameArray[i][j+1]==3 )
			 {   
				 frameArray[i][j]=1;
				 frameArray[i][j+1]=9;
				 setSnakeTail(i,j+1);
	         }
			 else if(frameArray[i-1][j]==3 )
		     {   
			     frameArray[i][j]=1;
			     frameArray[i-1][j]=9;
				 setSnakeTail(i-1,j);
			 }
			 else
			 {	
			   	 if((summ+2)>snakeSize) 
			   	 { 				    		
				    frameArray[i][j-1]=9; 
				    setSnakeTail(i,j-1);
					frameArray[i][j]=1; 
				 }
				 else
				 {
				    frameArray[i][j]=9;
					setSnakeTail(i,j);
				}
			}
		}
		if(number==4) 
		{
		  if(frameArray[i+1][j]==3  && frameArray[i][j+1]==3)
		  {   
		  	  frameArray[i][j]=1;
			  frameArray[i][j+1]=9;
			  setSnakeTail(i,j+1);
		  }
		  if(frameArray[i+1][j]==3 )
		  {   
		   	  frameArray[i][j]=1;
			  frameArray[i+1][j]=9;
			  setSnakeTail(i+1,j);
		  }
		  else if(frameArray[i][j+1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i][j+1]=9;
			  setSnakeTail(i,j+1);
		  }
		  else if(frameArray[i-1][j]==3  )
		  {   
		  	  frameArray[i][j]=1;
			  frameArray[i-1][j]=9;
			  setSnakeTail(i-1,j);
		  }
		  else  
		  {
			  frameArray[i][j]=1;
			  frameArray[i][j-1]=9;
			  setSnakeTail(i,j-1);
		  }
		}
		if(number==6) 
		{  
		  if(frameArray[i+1][j]==3 && frameArray[i][j-1]==3 )
		  {   
		      frameArray[i][j]=1;
		      frameArray[i][j-1]=9;
			  setSnakeTail(i,j-1);		
		  } 
		  else if(frameArray[i-1][j]==3 && frameArray[i][j-1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i][j-1]=9;
			  setSnakeTail(i,j-1);						 
		  } 
		  else if(frameArray[i-1][j]==3 )
		  {   
		      frameArray[i][j]=1;
		      frameArray[i-1][j]=9;
			  setSnakeTail(i-1,j);					
		  } 
		  else if(frameArray[i][j+1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i][j+1]=9;
			  setSnakeTail(i,j+1); 
		  }
		  else if(frameArray[i+1][j]==3 )
		  {   
		      frameArray[i][j]=1;
			  frameArray[i+1][j]=9;
			  setSnakeTail(i+1,j);	  
		  }
	      else
		  {  
	    	  frameArray[i][j]=1;
			  frameArray[i][j-1]=9;
			  setSnakeTail(i,j-1);
						
		  }
		}

	    if( number==8 ) 
	    {
		  if(frameArray[i-1][j]==3 && frameArray[i][j-1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i][j-1]=9;
			  setSnakeTail(i,j-1);			  
		  }
		  else if(frameArray[i+1][j]==3 && frameArray[i][j+1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i+1][j]=9;
			  setSnakeTail(i+1,j);			  
		  }
		  else if(frameArray[i+1][j]==3 && frameArray[i][j+1]==8 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i+1][j]=9;
			  setSnakeTail(i+1,j);		  
		  }
		  else if(frameArray[i-1][j]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i-1][j]=9;
			  setSnakeTail(i-1,j);						  
		  }
		  else if(frameArray[i][j+1]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i][j+1]=9;
			  setSnakeTail(i,j+1);	  
		  }
	      else if(frameArray[i+1][j]==3 )
		  {   
			  frameArray[i][j]=1;
			  frameArray[i+1][j]=9;
			  setSnakeTail(i+1,j);    
		  }
		  else 
		  {	 
			  if((summ+2)>snakeSize) 
			  { 
				frameArray[i][j-1]=9; 
			    setSnakeTail(i,j-1);
				frameArray[i][j]=1; 
			  }
			  else
			  {
			    frameArray[i][j]=9;
				setSnakeTail(i,j);
			  }  	 
		 }
	
	}
  
}
	 
	 
	 public void snakeFeed(int number)
	 { 	 
		setFrameInFood();
		setSnakeSizeAdd();
			
	 }
	 
	 public void setSnakeTail(int row, int column) {
		  xSnakeTail=row;
		  ySnakeTail=column;
	}
	 
	 public void setSnakeHead(int row, int column) {
		  xSnake=row;
		  ySnake=column;
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
