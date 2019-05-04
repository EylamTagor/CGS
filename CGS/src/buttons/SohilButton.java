package buttons;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import running.Main;

public class SohilButton {

	public static final int RECTANGLE = 1, CIRCLE = 2, GHOST = 3;
	private String name;
	private int buttonShape, textSize, edgeCurve;
	private double x, y, width, height;
	private boolean isActive;
	private Color color, highlightColor;
	private Rectangle2D.Double rectangleButton;
	private Ellipse2D.Double circleButton;

	public SohilButton(String name, int textSize, int shape, double x, double y, double width, double height) {
		this.name = name;
		this.buttonShape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = new Color(135, 206, 255);
		highlightColor = new Color(38, 38, 38);
		this.textSize = textSize;
		edgeCurve = 25;
	}
	
	public SohilButton(String name, int textSize, int shape, double x, double y, double width, double height, Color col) {
		this.name = name;
		this.buttonShape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = col;
		highlightColor = new Color(38, 38, 38);
		this.textSize = textSize;
		edgeCurve = 25;
		rectangleButton = new Rectangle2D.Double(x, y, width, height);

	}
	
	public SohilButton(String name, int textSize, int shape, double y, double width, double height) {
		this.name = name;
		this.buttonShape = shape;
		this.y = y;
		this.width = width;
		this.height = height;
		x = Main.width/2 - width/2;
		color = new Color(135, 206, 255);
		highlightColor = new Color(38, 38, 38);
		this.textSize = textSize;
		edgeCurve = 25;
		rectangleButton = new Rectangle2D.Double(x, y, width, height);

	}
	
	public void draw(PApplet marker) {

		marker.fill(color.getRed(), color.getGreen(), color.getBlue());

		if (buttonShape == RECTANGLE) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			marker.rect((float) x, (float) y, (float) width, (float) height, edgeCurve);
		}

		if (buttonShape == CIRCLE) {
			circleButton = new Ellipse2D.Double(x - width/2, y - height/2, width, height);
			marker.ellipse((float) x, (float) y, (float) width, (float) height);
		}
		
		if (buttonShape == GHOST) {
			rectangleButton = new Rectangle2D.Double(x, y, width, height);
			int margin = 4;
			marker.fill(highlightColor.getRed(), highlightColor.getGreen(), highlightColor.getBlue());
			marker.rect((float) (x - margin), (float) (y - margin), (float) (width + margin * 2), (float) (height + margin * 2));
			marker.fill(38, 38, 38);
			marker.noStroke();
			marker.rect((float) x, (float) y, (float) width, (float) height);
		}
		
		marker.fill(255);
		marker.textSize(textSize);
		marker.textAlign(marker.CENTER, marker.CENTER);
		if (buttonShape == RECTANGLE) {
			marker.text(name, (float) (x + width / 2), (float) (y + height / 2));
		}
		
		if (buttonShape == CIRCLE) {
			marker.text(name, (float) (x), (float) (y));
		}
	}

	public boolean isPointInside(double x, double y) {
		if (buttonShape == RECTANGLE) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}

		if (buttonShape == CIRCLE) {
			return circleButton.contains(new Point2D.Double(x, y));			
//			double centerX = this.x + width / 2, centerY = this.y + height / 2;
//			if ((Math.pow((x - centerX), 2) / Math.pow((width / 2), 2))
//					+ (Math.pow((y - centerY), 2) / Math.pow((height / 2), 2)) <= 1) {
//				return true;
//			} else{
//				return false;
//			}
		}
		
		if (buttonShape == GHOST) {
			return rectangleButton.contains(new Point2D.Double(x, y));
		}
		
		return false;
	}

	// GETTERS AND SETTERS

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getHighlightColor() {
		return highlightColor;
	}

	public void setHighlightColor(Color highlightColor) {
		this.highlightColor = highlightColor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTextSize() {
		return textSize;
	}
	
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	
	public void setEdgeCurve(int edgeCurve) {
		this.edgeCurve = edgeCurve;
	}
	
}