import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	private int side;
	
	public Square(int x, int y, int dx, int dy, int side, Color color) {
		super(x, y, dx, dy, color);
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}
	
	public void setSide(int side) {
		this.side = side;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(this.getX()-side/2, this.getY()-side/2, side, side);
	}
	
	public void move(int panelWidth, int panelHeight) {
		this.setX(this.getX() + this.getDx());
		this.setY(this.getY() + this.getDy());
		if(this.getX()-side/2 < 0 || this.getX()+side/2 > panelWidth) {
			this.setDx(this.getDx()*-1);
		} 
		if(this.getY()-side/2 < 0 || this.getY()+side/2 > panelHeight) {
			this.setDy(this.getDy()*-1);
		}
	}
}