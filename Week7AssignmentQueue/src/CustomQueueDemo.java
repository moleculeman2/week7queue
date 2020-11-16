import java.awt.Frame;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;


/**
 * Creates a queue using a custom implementation. Draws circles at cursor when user left clicks and adds to queue.
 * Displays queue size and elements when user right clicks.
 * 
 * @author Mason Wickersham
 *
 */
public class CustomQueueDemo
{

	public static void main(String[] args)
	{
		Queue queue = new Queue();
		Frame frame = new Frame();
		Timer timer = new Timer(true);
	
		frame.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
			});
		 
		// Add a component with a custom paint method
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//Creates circle at cursor on mouse left click and adds to queue
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
					int xClick = e.getX();
					int yClick = e.getY();
					queue.enqueue(new PaintComponent(xClick, yClick));
					frame.add(queue.back());
					TimerTask timerTask = new MyTimerTask(queue);
					timer.schedule(timerTask, 4000);
					frame.setVisible(true);
				}
				//prints info to console on right click
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
					queue.printQueue();
				}
			}
			
			
		});
		
		
		 
		int frameWidth = 700;
		int frameHeight = 700;
		 
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		 
	}		 
}

/**
 * Implementation of TimerTask, used to remove queue items after 4 seconds
 * 
 * @author Mason Wickersham
 *
 */
class MyTimerTask extends TimerTask{
	
	Queue q = new Queue();
	
	/**
	 * Constructor of MyTimerTask2
	 * 
	 * @param q	Queue passed from main method
	 */
	public MyTimerTask(Queue q) {
		this.q = q;
	}

	@Override
	public void run()
	{
		q.dequeue();
	}
	
}