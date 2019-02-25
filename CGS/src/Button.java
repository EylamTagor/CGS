import processing.core.PApplet;
import ayush.shapes.*;
public abstract class Button {
	protected float x, y, width, height;

	public Button(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void draw(PApplet p);

	public boolean isPointInButton(float px, float py) {
		return px >= x && px <= x + width && py >= y && py <= y + height;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x,y,width,height);
	}
}