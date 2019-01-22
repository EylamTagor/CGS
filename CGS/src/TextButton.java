
import processing.core.PApplet;

public class TextButton extends Button {
	private float x, y, width, height, textX, textY;
	private int btnR, btnG, btnB, textR, textG, textB;
	private String text;

	public TextButton(float x, float y, float width, float height, float textX, float textY, int btnR, int btnG,
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
		p.color(btnR, btnG, btnB);
		p.rect(x, y, width, height);
		p.color(textR, textG, textB);
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

}
