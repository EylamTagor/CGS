import processing.core.PApplet;
import processing.core.PImage;

public class ImageButton extends Button {
	private PImage image;

	public ImageButton(PImage image, float x, float y) {
		super(x, y, image.width, image.height);
		this.image = image;
	}

	public void draw(PApplet p) {
		p.image(image, getX(), getY());
	}
}
