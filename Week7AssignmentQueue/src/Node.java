import java.awt.geom.Ellipse2D;


/**
 * Node of Queue that contains a paint component
 * 
 * @author Mason Wickersham
 *
 */
public class Node
{
	Node next;
	PaintComponent p;
	
	/**
	 * @param p	Paint Component passed from Queue
	 */
	public Node(PaintComponent p) {
		this.p = p;	
	}

}

