package cihan.kurs.odev8.CihanLinkedList;

public class CihanLinkedList<E> {
	private int size;
    private Node<E> first;
    private Node<E> last;
    
    public void add(E e) {
    	Node<E> node= new Node(e,null);
        if(first==null) {
        	first=node;
        	last=node;
        }
        else
        {
        	last.next=node; // sonraki elemanı gösterir
			last=node;
        }
        size++;
    }
      
    public void remove(int index) {
    	indexControl(index);
   
       if(index==0) {
    		first=first.next;
    	}
    	else
    	{ 	Node x=first;
    		for(int i=1;i<size;i++) {
    		  	if(i==index )  { 
    		  		  //System.out.println("bbbb:"+i);
	    			  x.next=x.next.next;  }
	    		  else  
	    		  { x=x.next; 
	    		   //System.out.println("aaaaa:"+i);
	    		  }
	       		
	        } 
    		last=x;
    		//System.out.println("last:"+last.data);
    		
        }
	    
     	size--;
    }
    
    public E get(int index)  {
    	indexControl(index);
    	Node ii=first;
    	for(int i=0;i<index;i++) {
    		ii=ii.next;
    	}
    	return (E) ii.data;
    }
    
     public void indexControl(int index) {
    	if(!isIndexValid(index))  
    	{
    		//throw new NullPointerException(index +" indeksi Geçerli Değil.Size :" + size);
    		throw new IndexOutOfBoundsException(index +" indeksi Geçerli Değil.Size :" + size);
    	}
    }
     public boolean isIndexValid(int index) {
    	 return index >= 0 && index < size;
     }
     
     public Node<E> getFirst()  {
       	return first;
     }
     
     public void setFirst(E number)  {
         first.data=(E) number;
      }
     public Node<E> getLast()  {
        	return last;
      }
     public void setLast(E number)  {
         last.data=(E) number;
      }
    
}
