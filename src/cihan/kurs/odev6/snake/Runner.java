package cihan.kurs.odev6.snake;

public class Runner {
	public static final  int SIZE=25;
	public static final  int BSIZE=SIZE*2-1;
	
	public static void main(String[] args) {
		new Frame();
		
	}
	
	public static int getRandomNumber(){
	    return (int)(Math.random() *(Runner.SIZE-5)+3);
	   
	}

}
