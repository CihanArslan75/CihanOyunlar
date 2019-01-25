package cihan.kurs.odev6.snake;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Frame frame=new Frame();
		boolean exit=true;
		do {
			System.out.println("Yılanı Hareket Ettirmek için 2 ↓, 4 ← , 6 → , 8 ↑ Tuşlarını Kullanınız !");
			System.out.println("Oyunu Sonlandırmak için x Tuşunu Kullanınız !");
			String input = sc.nextLine();
			if(input.equals("x") || input.equals("X")) exit=false;
			
			if(input.equals("2")) {
				if( frame.frameArray[frame.xSnake][frame.ySnake]=="▲" ) 
				{ 
					System.out.println("Aşağı Gidemezsiniz!");
				}
				else
				{
					frame.setFrameInSnakeDown() ;
				    frame.drawFrame();
				}
			}else if(input.equals("4")) {
				if( frame.frameArray[frame.xSnake][frame.ySnake]=="►" ) 
				{ 
					System.out.println("Sola Gidemezsiniz!");
				}
				else
				{
					frame.setFrameInSnakeLeft() ;
					frame.drawFrame();
				}
				
			}else if(input.equals("6")) {
				if( frame.frameArray[frame.xSnake][frame.ySnake]=="◄" ) 
				{ 
					System.out.println("Sağa Gidemezsiniz!");
				}
				else
				{
					frame.setFrameInSnakeRight() ;
					frame.drawFrame();
				}
			}else if(input.equals("8")) {
				if( frame.frameArray[frame.xSnake][frame.ySnake]=="▼" ) 
				{ 
					System.out.println("Yukarı Gidemezsiniz!");
				}
				else 
				{
					frame.setFrameInSnakeUp() ;
					frame.drawFrame();
				}
			}
		
	}while(exit);

}
}
// ▼
// ►
//◄
// ▲ 
// ■


