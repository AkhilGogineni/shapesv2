import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ShapePanel extends JPanel implements MouseListener {
	private static final Color BACKGROUND = new Color(242, 43, 43);
	// fields
	private Shape[] shapes;
	private int arraySize = 10;
	private int nextIndex = 0;
	private int arrayIndex = 0;
	private int shapeSize = 10;
	private Color shapeColor = Color.blue;
	
	Color myColor;
	Timer t;

	public ShapePanel() {
		myColor = BACKGROUND;
		nextIndex = 0;
		shapes = new Shape[arraySize];
		t = new Timer(20, new Listener());
		t.start();
		addMouseListener(this);
	}
	
	  public void paintComponent(Graphics g) {
	      g.setColor(myColor);
	      g.fillRect(0, 0, getWidth(), getHeight());
	   
	      for (int shapeIndex=0; shapeIndex<nextIndex; shapeIndex++) {
	    	  
	    	  shapes[shapeIndex].draw(g);
	    	  for (int lineIndex = 0; lineIndex<nextIndex; lineIndex++) {
	    		  int x1 = shapes[shapeIndex].getX();
	    		  int y1 = shapes[shapeIndex].getY();
	    		  int x2 = shapes[lineIndex].getX();
	    		  int y2 = shapes[lineIndex].getY();
	    		  g.drawLine(x1, y1, x2, y2);
	    	  }
	         //connect all points below the current point to that point
/*	         for (int j=k+1; j<arrayIndex; j++)
	         {
	            Point pt2 = points[j];
	            
	            //todo: get the coordinates of pt2
	            int x2 = (int)pt2.getX();
	            int y2 = (int)pt2.getY();
	         
	            //draw the point
	            g.setColor(Color.blue);
	            g.fillOval(x2-3, y2-3, 6, 6);
	            double distance = computeDistance(x1, y1, x2, y2);
	            int colorVal = (int)(distance * 255 / getWidth());
	            if (colorVal > 255)
	               colorVal = 255;
	                
	            //draw the line between pt1 and pt2
	            Color cc = new Color(colorVal, colorVal, colorVal);
	            g.setColor(cc);
	         
	            g.drawLine(x1, y1, x2, y2);
	         }*/
	      }
	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse clicked; # of clicks: " + e.getClickCount(), e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse Entered; # of clicks: " + e.getClickCount(), e);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse pressed; # of clicks: " + e.getClickCount(), e);
		if(nextIndex <shapes.length )
		{
			shapes[nextIndex] = new Square(e.getX(),e.getY(),shapeSize,shapeColor);
			nextIndex++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse Released; # of clicks: " + e.getClickCount(), e);

	}

	void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription + " detected on " + e.getComponent().getClass().getName() + "." + "\n");
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();

		}
	}

}
