
/**
 * Custom Queue class created of nodes that hold Paint Components.
 * 
 * @author Mason Wickersham
 *
 */
public class Queue
{
	
	Node head;
	int count = 1;

	/**
	 * Constructor
	 */
	public Queue() {
	}
	
	
	/**
	 * @param p	Paint Component to create new node with
	 */
	public void enqueue(PaintComponent p)
	{
		if (head == null)
		{
			head = new Node(p);
			return;
		}
		Node current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(p);
		count += 1;
	}
	
	/**
	 * 	removes the first item from queue
	 */
	public void dequeue()
	{
		if (head.next != null) {
			count -= 1;
		}
		head.p.setVisible(false);
		head = head.next;
	
	}
	
	/**
	 * @return 	returns the front item of the queue
	 */
	public PaintComponent front() {
		return head.p;
	}
	
	/**
	 * @return	returns the back item of the queue
	 */
	public PaintComponent back() {
		Node current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		return current.p;
	}
	
	/**
	 * @return	returns the size of the queue
	 */
	public int size()
	{
		return count;
	}
	
	/**
	 * @return	returns boolean of whether the queue is empty
	 */
	public boolean isEmpty(){
		if (head == null) return true; else return false;
	}
	
	/**
	 * 		prints each element in the queue
	 */
	public void printQueue()
	{
		Node current = head;
		System.out.println("Queue: ");
		while (current != null)
		{
			System.out.println("circle at coordinates: ( " + current.p.getxClick() + " , " + current.p.getyClick() + " )");
			current = current.next;
		}
		if (this.isEmpty() == true) System.out.println("null"); 
		else System.out.println("Size of: " + this.size());
	}
}
