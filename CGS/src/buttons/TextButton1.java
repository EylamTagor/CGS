package buttons;

import processing.core.PApplet;

public class TextButton1 extends Button1 {
	private float textX, textY;
	private int btnR, btnG, btnB, textR, textG, textB;
	private String text;

	public TextButton1(float x, float y, float width, float height, float textX, float textY, int btnR, int btnG,
			int btnB, int textR, int textG, int textB, String text) {
		super(x, y, width, height);
		this.textX = textX;
		this.textY = textY;
		this.btnR = btnR;
		this.btnG = btnG;
		this.btnB = btnB;
		this.textR = textR;
		this.textG = textG;
		this.textB = textB;
		this.text = text;
	}

	public void draw(PApplet p) {
		p.fill(btnR, btnG, btnB);
		p.rect(x, y, width, height);
		p.fill(textR, textG, textB);
		p.text(text, textX, textY);
	}

	public boolean isInBounds(int mouseX, int mouseY) {
		return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
	}

	public void setColor(int btnR, int btnG, int btnB) {
		this.btnR = btnR;
		this.btnG = btnG;
		this.btnB = btnB;
	}

	public void setText(String s) {
		text = s;
	}

	public void setWidth(float w) {
		width = w;
	}

	public void setHeight(float h) {
		height = h;
	}

}
