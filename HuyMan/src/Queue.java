import java.util.LinkedList;

public class Queue<E> {
		
		private LinkedList<E> queue = new LinkedList<E>();
		   public void enqueue(E item) {
			   queue.addLast(item);
		   }
		   public E dequeue() {
		      return (E) queue.poll();
		   }
		   public boolean isEmpty() {
		      return queue.isEmpty();
		   }
		   public int size() {
		      return queue.size();
		   }
		   public void addItems(Queue<? extends E> q) {
		      while (!q.isEmpty())
		    	  queue.addLast(q.dequeue());
		   }
	}