package buttons;


import java.awt.Color;

import processing.core.PApplet;

public class AyushTextButton extends Button {
	private float textX, textY;
	private Color tcol, bcol;
	private String text;
	private int size;

	

	public AyushTextButton(float x, float y, float width, float height, float textX, float textY, Color tcol, Color bcol,
			String text, int size) {
		super(x, y, width, height);
		this.textX = textX;
		this.textY = textY;
		this.tcol = tcol;
		this.bcol = bcol;
		this.text = text;
		this.size = size;
	}


	public void draw(PApplet p) {
		p.fill(bcol.getRed(), bcol.getGreen(), bcol.getBlue());
		p.rect(x, y, width, height);
		p.fill(tcol.getRed(), tcol.getGreen(), tcol.getBlue());
		p.textSize(size);
		p.text(text, textX, textY);
	}


	public void setTColor(int btnR, int btnG, int btnB) {
		tcol = new Color(btnR, btnG, btnB);
	}
	
	public void setTColor(Color newc) {
		tcol = newc;
		
	}
	
	public void setBColor(int r, int g, int b) {
		bcol = new Color(r,g,b);
	}
	
	public void setBColor(Color newc) {
		bcol = newc;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	public Color getBColor() {
		return bcol;
	}
	
	public String getText() {
		return text;
	}
}

