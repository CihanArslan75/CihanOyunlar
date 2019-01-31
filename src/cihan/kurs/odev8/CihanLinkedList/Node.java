package cihan.kurs.odev8.CihanLinkedList;

public class Node<E> {
	public E data;
	public Node<E> next;
	
	public Node(E data,Node next) {
		this.data=data;
		this.next=next;
	}

}
