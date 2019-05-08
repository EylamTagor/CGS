package other;

public abstract class Screen {

	public final int DRAWING_WIDTH;
	public final int DRAWING_HEIGHT;
	
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}	
	public abstract void setup();
	
	public abstract void draw();
	
	public abstract void mousePressed();
	
	public abstract void mouseMoved();
	
	public abstract void mouseDragged();
	
	public abstract void mouseClicked();
	
	public abstract void mouseReleased();
	
	public abstract void keyPressed();
	
	public abstract void keyReleased();
	
}
