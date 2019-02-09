package cihan.kurs.odev7.dama;

public abstract class Dama {
	
	public static int[][] damaArray=new int[8][8];
	public static String[] hamlePlayableArray=new String[16]; 
	
		
	static { 
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(i==1 || i==2 ) damaArray[i][j]=1; 
					if(i==5 || i==6 ) damaArray[i][j]=2; 
				}
			}
		}
	
	public abstract void damaDraw() ;
	public abstract boolean hamleControl(String hamle);
	public abstract int hamleShow(String hamle);
	public abstract String[] hamlePlayableShow();
	public abstract void hamlePlayableDraw();
	public abstract String[] hamleFind(int i,int j);
	public abstract void hamleDo(String hamleFirst,String hamleLast );
	public abstract String[] hamleImperative(int i, int j );
	public abstract boolean hamleImperativeControl(int player);

}
