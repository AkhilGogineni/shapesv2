import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape{
	private int radius;
	
	public Triangle(int x, int y, int dx, int dy, int radius, Color color) {
		super(x, y, dx, dy, color);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor()); 
		int[] xPoints = new int[] {this.getX(), (int)(this.getX()+(Math.sqrt(3) * radius/2)), (int)(this.getX()-((Math.sqrt(3)) * radius/2))};
		int[] yPoints = new int[] {this.getY()-radius, (int)(this.getY()+radius/2), (int)(this.getY()+radius/2)};
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}
	
	public void move(int panelWidth, int panelHeight) {
		this.setX(this.getX() + this.getDx());
		this.setY(this.getY() + this.getDy());
		if(this.getX()-radius < 0 || this.getX()+radius > panelWidth) {
			this.setDy(this.getDx()*-1);
		} 
		if(this.getY()-radius < 0 || this.getY()+radius > panelHeight) {
			this.setDy(this.getDy()*-1);
		}
	}
}
