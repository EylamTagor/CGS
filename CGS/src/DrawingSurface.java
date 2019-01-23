import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	private PImage backBtn;
	private ImageButton back;
	private TextButton blazer, shirt, slacks, socks, belt, shoes;

	public void setup() {
		backBtn = loadImage("backbutton.png");
		back = new ImageButton(backBtn, 0, 0, 100, 100);

		blazer = new TextButton(200, 200, 200, 200, 250, 250, 255, 0, 0, 0, 0, 255, "BLAZER");
	}

	public void draw() {
		background(255);

		back.draw(this);
		blazer.draw(this);
	}

	public void mouseClicked() {
		if (back.isPointInButton(mouseX, mouseY)) {
			// go back to idle menu
		} else if (blazer.isInBounds(mouseX, mouseY)) {
			// if enough $ buy blazer
		}
	}

}
