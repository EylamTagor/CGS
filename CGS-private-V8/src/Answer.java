
import processing.core.PApplet;
import ayush.shapes.*;
public class Answer {
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int s) {
		size = s;
	}
	private float x,y;
	private int size;
	public Answer(String text, float x, float y, int size) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void draw(PApplet papp) {
		papp.pushStyle();
		papp.fill(0);
		papp.textSize(size);
		
		papp.text(text, x, y + size);
		papp.popStyle();
	}
	
	public void moveLeft() {
		x-= 5;
	}
	
	public Rectangle getRectangle() {
		double width = 0;
		for(int i = 0;i<text.length();i++) {
			width += size/2.0;
		}
		return new Rectangle(x,y,(int)width, size);
	}
}
