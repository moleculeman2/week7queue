import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Creates a queue using the java implementation. Draws circles at cursor when user left clicks and adds to queue.
 * Displays queue size and elements when user right clicks.
 * 
 * @author Mason Wickersham
 *
 */
public class JavaQueueDemo
{

	public static void main(String[] args)
	{
		Queue<PaintComponent> queue = new LinkedList<>();
		Frame frame = new Frame();
		Timer timer = new Timer(true);
	
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
			});
		 
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//Creates circle at cursor on mouse left click and adds to queue
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
					int xClick = e.getX();
					int yClick = e.getY();
					PaintComponent p = new PaintComponent(xClick, yClick);
					queue.add(p);
					frame.add(p);
					TimerTask timerTask = new MyTimerTask2(queue);
					timer.schedule(timerTask, 4000);
					frame.setVisible(true);
				}
				//prints info to console on right click
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
					System.out.println("Size of queue: " + queue.size());
					System.out.println("Elements in queue: " + queue);
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
class MyTimerTask2 extends TimerTask{
	
	Queue<PaintComponent> q = new LinkedList<>();
	
	/**
	 * Constructor of MyTimerTask2
	 * 
	 * @param q	Queue passed from main method
	 */
	public MyTimerTask2(Queue q) {
		this.q = q;
	}
	
	@Override
	public void run()
	{
		q.peek().setVisible(false);
		q.remove();
	}
	
}