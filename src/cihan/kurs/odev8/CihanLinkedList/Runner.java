package cihan.kurs.odev8.CihanLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Runner {
	public static void main(String[] args) {
		CihanLinkedList cl=new CihanLinkedList();
		LinkedList l=new LinkedList();
	
		cl.add(0);
		cl.add(1);
		cl.add(2);
		cl.add(3);
		cl.add(4);
		cl.add(5);
		cl.add(6);
		cl.add(7);
		cl.add(8);
		cl.remove(8);
		cl.add(9);
		cl.remove(8);
		cl.remove(2);
		cl.remove(1);
		cl.add("aslan");
		cl.add("cihan");
	
		
		System.out.println(cl.get(0));
		System.out.println(cl.get(1));
		System.out.println(cl.get(2));
		System.out.println(cl.get(3));
		System.out.println(cl.get(4));
		System.out.println(cl.get(5));
		System.out.println(cl.get(6));
		System.out.println(cl.get(7));
	//	System.out.println(cl.get(8));
	//	System.out.println(cl.get(9));
	//	System.out.println(cl.get(10));
	//	System.out.println(cl.get(11));
		System.out.println("************************************");
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.remove(8);
		l.add(9);
		l.remove(8);
		l.remove(2);
		l.remove(1);
		l.add("aslan");
		l.add("cihan");
	
		
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		System.out.println(l.get(3));
		System.out.println(l.get(4));
		System.out.println(l.get(5));
		System.out.println(l.get(6));
		System.out.println(l.get(7));
	}
	

}
