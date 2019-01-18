package cihan.kurs.odev6.snake;

public class Snake {
	
	protected int snakeSize=5;
	public String[] snakeArray=new String[snakeSize];
	public int[] snakeTail=new int[2];
	
	
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
			 if(number == 2)  {snakeArray[0]="▼";}
			 if(number == 4)  {snakeArray[0]="◄";}
			 if(number == 8)  {snakeArray[0]="▲";}
			 if(number == 6)  {snakeArray[0]="►";}
			// if(number == 6)  {snakeArray[snakeSize-1]="►";snakeArray[0]="■";}
		
    return snakeArray;
	}
	
	public String[] setSnakeFisrt() {
		for(int i=0;i<snakeSize;i++)
		{
			if(i==0) 
			{ 				
				snakeArray[i]="◄";
			}
			else if(i<snakeSize-1) 
			{
				snakeArray[i]="■";
			}
			else if(i==snakeSize-1) 
			{
				snakeArray[i]="@";
			}
		}	
			
		
    return snakeArray;
	}
	
	
	
	
	
	
	
	
	
	
}
