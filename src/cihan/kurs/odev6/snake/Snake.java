package cihan.kurs.odev6.snake;
 

import cihan.kurs.odev8.CihanLinkedList.*;

public class Snake {
	
	public static int snakeSize=5;
	//public String[] snakeArray=new String[snakeSize];
	public CihanLinkedList<Integer> snakeArray= new CihanLinkedList<Integer>();
	public int[] snakeTail=new int[2];
	
	public Snake() {
		//System.out.println("Snake Constructor");
	}
	
	public void setSnakeSizeAdd() {
		snakeSize++;
	}
	
	public int getSnakeSize() {
		return snakeSize;
	}
	
	
	public CihanLinkedList setSnake(int number) {
		
	   if(number == 2)  {snakeArray.setFirst(2);}
	   if(number == 4)  {snakeArray.setFirst(4);}
	   if(number == 8)  {snakeArray.setFirst(8);}
	   if(number == 6)  {snakeArray.setFirst(6);}
		
    return snakeArray;
	}
	
	public CihanLinkedList setSnakeFirst() {
		for(int i=0;i<snakeSize;i++)
		{
			if(i==0) 
			{ 				
				snakeArray.add(4);
				//snakeArray.setFirst(4);			
			}
			else if(i<snakeSize-1) 
			{
				//snakeArray.add("■");
				snakeArray.add(3);
			}
			else if(i==snakeSize-1) 
			{
				//snakeArray[i]="@";
				snakeArray.add(9);
			}
		}	
			
		
    return snakeArray;
	}
	
	
	
	
	
	
	
	
	
	
}
