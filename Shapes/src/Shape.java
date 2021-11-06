import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	private int x;
	private int y;
	private Color color;
	private int dx;
	private int dy;

	public Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		dx = 1;
		dy = 2;
	}
	
	public Shape(int x, int y, int dx, int dy, Color color) {
		this(x, y, color);
		this.dx = dx;
		this.dy = dy;
	}
	

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void move(int panelWidth, int panelHeight);
}
