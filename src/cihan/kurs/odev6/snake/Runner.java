package cihan.kurs.odev6.snake;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Frame frame=new Frame();
		Boolean exit=true;
		do {
			System.out.println("Yılanı Hareket Ettirmek için 2 ↓, 4 ← , 6 → , 8 ↑ Tuşlarını Kullanınız !");
			System.out.println("Oyunu Sonlandırmak için x Tuşunu Kullanınız !");
			String input = sc.nextLine();
			if(input.equals("x") || input.equals("X")) exit=false;
			
			if(input.equals("2")) {
				frame.setFrameInSnakeDown() ;
			    frame.drawFrame();
			}else if(input.equals("4")) {
				frame.setFrameInSnakeLeft() ;
				frame.drawFrame();
			}else if(input.equals("6")) {
				frame.setFrameInSnakeRight() ;
				frame.drawFrame();
			}else if(input.equals("8")) {
				frame.setFrameInSnakeUp() ;
				frame.drawFrame();
			}
		
	}while(exit);

}
}
// ▼
// ►
//◄
// ▲ 
// ■


