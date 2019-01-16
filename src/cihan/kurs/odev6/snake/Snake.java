package cihan.kurs.odev6.snake;

public class Snake {
	
	protected int snakeSize=5;
	public String[] snakeArray=new String[snakeSize];
	
	public Snake() {
		//System.out.println("Snake Constructor");
	}
	
	public void setSnakeSize() {
		snakeSize++;
	}
	
	public int getSnakeSize() {
		return this.snakeSize;
	}
	
	
	public String[] setSnake(int number) {
		for(int i=0;i<snakeSize;i++)
		{
			if(i==0) 
			{ 
				 if(number == 2)  {snakeArray[i]="▼";}
				 if(number == 4)  {snakeArray[i]="◄";}
				 if(number == 6)  {snakeArray[i]="►";}
				 if(number == 8)  {snakeArray[i]="▲";}
			}
			else
			{snakeArray[i]="■";}
		}
		
    return snakeArray;
	}
	
	
	
	
}
