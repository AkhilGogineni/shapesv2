import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square{
	private int height;
	private int width = getSide();
	
	public Rectangle(int x, int y, int dx, int dy, int width, int height, Color color) {
		super(x, y, dx, dy, width, color);
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(this.getX()-width/2, this.getY()-height/2, width, height);
	}
	
	public void move(int panelWidth, int panelHeight) {
		this.setX(this.getX() + this.getDx());
		this.setY(this.getY() + this.getDy());
		if(this.getX()-width/2 < 0 || this.getX()+width/2 > panelWidth) {
			this.setDx(this.getDx()*-1);
		} 
		if(this.getY()-height/2 < 0 || this.getY()+height/2 > panelHeight) {
			this.setDy(this.getDy()*-1);
		}
	}
}
