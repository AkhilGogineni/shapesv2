import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ShapePanelStudent extends JPanel {
	private static final Color BACKGROUND = new Color(0, 0, 0);

	//** Create variables for shape size and color
	private int shapeSize = 10;
	private Color shapeColor = Color.blue;
	
	//**Create the reference for the array-challe it "shapes"
	//** the arraySize 
	//**  and the nextIndex
	private Shape[] shapes;
	private int arraySize = 10;
	private int nextIndex; 
	
	Color myColor;
	Timer t;

//************** Constructor  ***********************
	public ShapePanelStudent() {

		myColor = BACKGROUND;
		//***************  Initialize the index and the array
		shapes = initializeArray();
		
		
		//**************************************************
		//timer to repaint every 20 nanoseconds
		//The listener for this is at the bottom
		t = new Timer(20, new Listener());
		t.start();

	}
	
	  public void paintComponent(Graphics g)
	   {
	        
	      //Overwrite what was on the screen before
		  //with a blank background
	      g.setColor(myColor);
	      g.fillRect(0, 0, getWidth(), getHeight());

	      //**********  draw the shapes and the lines
	      for(int i = 0; i < arraySize; i++) {
	    	  shapes[i].move(getWidth(), getHeight());
	    	  shapes[i].draw(g);
	      }	      
	   }

	  //*********** Implement the methods for any interfaces
	  private Shape[] initializeArray() {
		  Shape[] temp = new Shape [arraySize];
		  for (int i = 0; i < temp.length; i++) {
			  int x = (int)(Math.random()*700);
			  int y = (int)(Math.random()*700);
			  Color[] colors = {Color.red, Color.blue, Color.yellow, Color.green, Color.gray, Color.pink, Color.cyan, Color.orange, Color.magenta};
			  int color = (int)(Math.random()*colors.length-1);
			  int size = (int)((Math.random()+5)*20);
			  int size2 = (int)((Math.random()+5)*20);
			  int shape = (int)(Math.random()*2);
			  int dx = (int)((Math.random()+1)*5);
			  int dy = (int)((Math.random()+1)*5);
			  if(shape == 0) {
				  temp[i] = new Circle(x, y, dx, dy, size, colors[color]);
			  } else if(shape == 1) {
				  temp[i] = new Rectangle(x, y, dx, dy, size, (int)(size2/2), colors[color]);
			  }
		  }
		  return temp;
	  }
	  

	  
//**  The method below could be useful to test the mouse interaction
	void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription + " detected on " + e.getComponent().getClass().getName() + "." + "\n");
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();

		}
	}

}