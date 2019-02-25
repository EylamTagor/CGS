import processing.core.PApplet;
import processing.core.PImage;

public class ImageButton extends Button {
	private PImage image;

	public ImageButton(PImage image, float x, float y, float width, float height) {
		super(x, y, width, height);
		this.image = image;
	}

	public void draw(PApplet p) {
		p.image(image, getX(), getY(), width, height);
	}
}