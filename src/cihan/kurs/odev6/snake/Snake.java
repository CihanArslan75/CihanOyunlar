package cihan.kurs.odev6.snake;

public class Snake {
	
	public String[] snakeArray;
	
	public Snake() {
		
	}
	
	public String setSnake(int x) {
		for(int i=0;i<5;i++)
		{
			if(i==0) 
			{
				snakeArray[i]="<";
			}
			else
			{
				snakeArray[i]="#";
			}
		}
    return snakeArray[x];
	}
}
