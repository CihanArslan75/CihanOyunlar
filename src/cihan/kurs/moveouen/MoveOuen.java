package cihan.kurs.moveouen;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.javafx.scene.traversal.Direction;

public class MoveOuen {
	static int queenAttack(int n,Point queen ,Set<Point> obstacles) {
		return Arrays.stream(Direction.values()).mapToInt(d->queenAttack(n, queen, obstacles,d)).sum();
	}
	static int queenAttack(int n,Point queen ,Set<Point> obstacles,Direction direction) {
		int result = 0;
		Point point =direction.move(queen);
		while (isInside(n,point) && !obstacles.contains(point) ) {
			result++;
			point = direction.move(point);
			System.out.println("direction:"+direction);
			System.out.println("point:"+point);
		}
		return result;
	}
	
	static boolean isInside(int n,Point p) {
		return 0 < p.getX() && p.getX()<=n && 0< p.getY() && p.getY()<=n;
	}

	enum Direction{
		N(0,1) ,
		NE(1,1),
		E(1,0),
		SE(1,-1),
		S(0,-1),
		SW(-1,-1),
		W(-1,0),
		NW(-1,1);
		private int dx;
		private int dy;
		
		private Direction(int dx,int dy) {
			this.dx=dx;
			this.dy=dy;
		}
	
		private Point move(Point input) {
			Point result=(Point) input.clone();
			result.translate(dx, dy);
			return result;
		
		}	
	}	
	public static void main(String[] args) {
		int n= 5;
		int k=3;
		Point queen = new Point(4, 3);
		Set<Point> obstacles= new HashSet<>();
		obstacles.add(new Point(5, 5));
		obstacles.add(new Point(4, 2));
		obstacles.add(new Point(2, 3));
		int result = queenAttack(n, queen, obstacles);
		
		System.out.println(result);
	}
	
}	
	
	
	
