import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

/**
 * Takes the x and y position of the cursor and uses it to create a circle
 * 
 * @author Mason Wickersham
 *
 */
@SuppressWarnings("serial")
public class PaintComponent extends Component
{
	private int xClick;
	private int yClick;
	
	/**
	 * @param xClick	integer x position of paint component
	 * @param yClick	integer y position of paint component
	 */
	public PaintComponent(int xClick, int yClick) {
		this.xClick = xClick;
		this.yClick = yClick;
	}
	
	
	/**
	 * @return the xClick integer value
	 */
	public int getxClick()
	{
		return xClick;
	}


	/**
	 * @return the yClick integer value
	 */
	public int getyClick()
	{
		return yClick;
	}
	

	/**
	 *		paints a circle at xClick and yClick position
	 */
	public void paint(Graphics g) {

		  Graphics2D g2d = (Graphics2D)g;

		  Ellipse2D.Double circle = new Ellipse2D.Double(xClick - 16, yClick - 40, 15, 15);
		  g2d.fill(circle);
		  
		  g2d.setColor(new Color(0,0,0));
		  g2d.fill(circle);
	}
}
