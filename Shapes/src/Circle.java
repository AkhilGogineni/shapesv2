import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	private int diameter;
	private int radius;
	
	public Circle(int x, int y, int diameter, Color color) {
		super(x, y, color);
		this.diameter = diameter;
		this.radius = diameter/2;
	}
	
	public Circle(int x, int y, int dx, int dy, int diameter, Color color) {
		super(x, y, dx, dy, color);
		this.diameter = diameter;
		this.radius = diameter/2;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
		this.radius = diameter/2;
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		this.diameter = radius*2;
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(this.getX()-radius, this.getY()-radius, diameter, diameter);
	}
	
	public void move(int panelWidth, int panelHeight) {
		this.setX(this.getX() + this.getDx());
		this.setY(this.getY() + this.getDy());
		if(this.getX()-radius < 0 || this.getX()+radius > panelWidth) {
			this.setDx(this.getDx()*-1);
		} 
		if(this.getY()-radius < 0 || this.getY()+radius > panelHeight) {
			this.setDy(this.getDy()*-1);
		}
	}
	
}
