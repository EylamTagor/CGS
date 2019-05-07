package other;

import processing.core.PApplet;

/**
 * Represents the progress bars in each conference and the main game, which are
 * used to track the player's progress towards qualifying for nationals.
 */
public class ProgressBar {

	private double progress;
	private double x, y, width, height;
	private double healthBarHeight, hBDistanceFromTop, healthBarMargin = 20, marginAdjust = -10, textAdjust = 5;
	public static final int RIGHT_ALIGN = 1, LEFT_ALIGN = 0;
	private String name;
	private int total;

	/**
	 * Creates a new ProgressBar object with the following parameters
	 * 
	 * @param name     the text that is displayed above the progress bar
	 * @param x        the x-coordinate of the progress bar
	 * @param y        the y-coordinate of the progress bar
	 * @param width    the width of the progress bar
	 * @param height   the height of the progress bar
	 * @param progress the initial progress of the player relating to the purpose of
	 *                 this progress bar
	 * @param total    the maximum progress for this progress bar
	 */
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

	/**
	 * Draws this progress bar on a PApplet
	 * 
	 * @param marker the PApplet onto which this progress bar will be drawn
	 */
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

		marker.text(name, (float) ((x + width) / 2), (float) (y + hBDistanceFromTop - textAdjust));
		marker.textAlign(marker.LEFT, marker.BOTTOM);
		marker.textSize(10);
		marker.text(((Integer) ((int) progress)).toString() + " / " + total,
				(float) (x + marginAdjust + width - healthBarMargin + textAdjust),
				(float) (y + hBDistanceFromTop + healthBarHeight));

		marker.popStyle();
	}

	/**
	 * @return the progress of this progress bar out of the maximum
	 */
	public double getProgress() {
		return progress;
	}

	/**
	 * Sets the progress of this progress bar
	 * 
	 * @param progress the new progress value
	 */
	public void setProgress(double progress) {
		this.progress = progress;
	}

	/**
	 * Decreases the progress for this progress bar
	 * 
	 * @param amount the amount to decrease by
	 */
	public void decreaseProgress(double amount) {
		progress -= amount;
	}

	/**
	 * Increases the progress for this progress bar
	 * 
	 * @param amount the amount to increase by
	 */
	public void increaseProgress(double amount) {
		progress += amount;
	}
}