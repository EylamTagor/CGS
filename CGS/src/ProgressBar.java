
import processing.core.PApplet;

public class ProgressBar {

	private double progress;
	private double x, y, width, height;
	private double healthBarHeight, hBDistanceFromTop, healthBarMargin = 20, marginAdjust = -10, textAdjust = 5;
	public static final int RIGHT_ALIGN = 1, LEFT_ALIGN = 0;
	private String name;
	private int total;
	public ProgressBar(String name, double x, double y, double width, double height, double progress, int total) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.progress = progress;
		healthBarHeight = 1 * height / 7;
		hBDistanceFromTop = 4 * height / 7;
		this.total = total;
	}

	public void draw(PApplet marker) {
		marker.pushStyle();

		// HEALTH BOX DESIGN AND HEALTH BAR DESIGN
		marker.stroke(0);
		marker.strokeWeight(1);
		marker.fill(255);
//		marker.rect((float) x, (float) y, (float) width, (float) height); // ACTUAL HEALTH BOX
		marker.rect((float) (x + healthBarMargin + marginAdjust), (float) (y + hBDistanceFromTop),
				(float) (width - 2 * healthBarMargin), (float) (healthBarHeight), (float) (healthBarHeight / 2)); // HEALTH
																													// BAR

//		if (progress <= 20) {
//			marker.fill(255, 0, 0);
//		} else if (progress < 50) {
//			marker.fill(255, 255, 0);
//		} else {
		marker.fill(0, 255, 0);
//		}
		marker.rect((float) (x + healthBarMargin + marginAdjust), (float) (y + hBDistanceFromTop),
				(float) (progress * (width - 2 * healthBarMargin) / total), (float) (healthBarHeight),
				(float) (healthBarHeight / 2)); // HEALTH BAR WITH CURRENT HEALTH

		// TEXT
		marker.fill(255);
		marker.textAlign(marker.CENTER, marker.BOTTOM);
		marker.textSize(18);
		
		marker.text(name, (float) ((x + width)/2), (float) (y + hBDistanceFromTop - textAdjust));
		marker.textAlign(marker.LEFT, marker.BOTTOM);
		marker.textSize(10);
		marker.text(((Integer) ((int) progress)).toString() + " / " + total,
				(float) (x + marginAdjust + width - healthBarMargin + textAdjust),
				(float) (y + hBDistanceFromTop + healthBarHeight));

		marker.popStyle();
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	public void decreaseProgress(double amount) {
		progress -= amount;
	}

	public void increaseProgress(double amount) {
		if (amount + progress <= total)
			progress += amount;
	}
}