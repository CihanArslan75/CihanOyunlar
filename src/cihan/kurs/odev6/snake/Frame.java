package cihan.kurs.odev6.snake;

public class Frame extends Snake{
	
	private String[][] frameArray= new String[Runner.SIZE][Runner.BSIZE]; 
	//Snake snake=new Snake();
	
	public Frame() {
	
		setFrame();
		drawFrame();
	}

	
	public void setFrame() {
		int x;
		int y;
		x=Runner.getRandomNumber();
		y=Runner.getRandomNumber();
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		for(int i=0;i<Runner.SIZE;i++) {
			for(int j=0;j<Runner.BSIZE;j++) {
				if(j%2 == 0) frameArray[i][j]=".";
				if(j%2 > 0) frameArray[i][j]=" ";
				if(i==0 || i==(Runner.SIZE-1) || j==0 || j==(Runner.BSIZE-1) ) frameArray[i][j]="+";
				/*************yılanı yerleştir *******************/
				if(i==x && j==y) frameArray[i][j]=setSnake(0);
				frameArray[i][j+1]=setSnake(1);
				frameArray[i][j+2]=setSnake(2);
				frameArray[i][j+3]=setSnake(3);
				frameArray[i][j+4]=setSnake(4);
			}
		}
		

		
		
	}
	
	private void drawFrame() {
		for(int i=0;i<Runner.SIZE;i++) {
			for(int j=0;j<Runner.BSIZE;j++) {
				System.out.print(frameArray[i][j]);
			}
			System.out.println();
		}
	}

	

}
