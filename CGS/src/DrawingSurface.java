import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private TextButton back, jacket, shirt, slacks, shoes, belt, tie;
	private SohilButton shop, activeButton, backConference;
	private ArrayList<SohilButton> conferences, conference1;
	private Player player;
	
	private int confButtonDiff = 100, buttonWidth = 80;
	
	public DrawingSurface() {
		player = new Player();
		player.earn(575);
		
		back = new TextButton(10, 10, 120, 25, 15, 25, 255, 200, 200, 0, 0, 0, "Back to conference");
		jacket = new TextButton(75, 100, 300, 100, 150, 150, 200, 255, 200, 0, 0, 0, "Jacket: $250");
		shirt = new TextButton(425, 100, 300, 100, 500, 150, 200, 255, 200, 0, 0, 0, "Shirt: $75");
		slacks = new TextButton(75, 250, 300, 100, 150, 300, 200, 255, 200, 0, 0, 0, "Slacks: $100");
		shoes = new TextButton(425, 250, 300, 100, 500, 300, 200, 255, 200, 0, 0, 0, "Shoes: $75");
		belt = new TextButton(75, 400, 300, 100, 150, 450, 200, 255, 200, 0, 0, 0, "Belt: $25");
		tie = new TextButton(425, 400, 300, 100, 500, 450, 200, 255, 200, 0, 0, 0, "Tie: $50");
		
		backConference = new SohilButton("Back", 20, SohilButton.RECTANGLE, Main.width - 105, Main.height - 100, 75, 50);
		activeButton = backConference;
		
		conferences = new ArrayList<SohilButton>();
		conference1 = new ArrayList<SohilButton>();
		
		conference1.add(backConference);
		
		for (int i = 1; i < 6; i++) {
			conferences.add(new SohilButton(((Integer) i).toString(), 40, SohilButton.CIRCLE, (Main.width/2) + (i-3) * confButtonDiff, 200, buttonWidth, buttonWidth));
		}
		shop = new SohilButton("Shop", 40, SohilButton.RECTANGLE, 400, 400, 100);
	}
	
	public void draw() {
		background(38);
		if (activeButton == backConference) 
			drawConferenceScreen();
		
		if (activeButton == conferences.get(0))
			drawConference1();
		if (activeButton == conferences.get(1))
			drawConference2();
	}
	
	public void drawConferenceScreen() {
		headingFormat();
		text("Conferences", Main.width/2, 50);
		
		for (SohilButton b : conferences) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY)) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		
		shop.draw(this);
	}
	
	public void drawConference1() {
		for (SohilButton b : conference1) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY)) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		
		headingFormat();
		text("Conference 1", Main.width/2, 50);
	}
	
	public void drawConference2() {
		headingFormat();
		text("Conference 2", Main.width/2, 50);
		textSize(10);
		backConference.draw(this);
	}
	
	public void headingFormat() {
		fill(255);
		textSize(30);
		textAlign(CENTER, CENTER);
	}
	
	public void drawShop() {
		background(255);

		back.draw(this);

		textSize(30);

		jacket.draw(this);
		shirt.draw(this);
		slacks.draw(this);
		shoes.draw(this);
		belt.draw(this);
		tie.draw(this);
	}

	public void mouseClicked() {
		if (back.isPointInButton(mouseX, mouseY)) {
			// go back to dashboard
		} else if (jacket.isInBounds(mouseX, mouseY) && player.getBalance() >= 250) {
			player.obtainJacket();
		} else if (shirt.isInBounds(mouseX, mouseY) && player.getBalance() >= 75) {
			player.obtainShirt();
		} else if (slacks.isInBounds(mouseX, mouseY) && player.getBalance() >= 100) {
			player.obtainSlacks();
		} else if (shoes.isInBounds(mouseX, mouseY) && player.getBalance() >= 75) {
			player.obtainShoes();
		} else if (belt.isInBounds(mouseX, mouseY) && player.getBalance() >= 25) {
			player.obtainBelt();
		} else if (tie.isInBounds(mouseX, mouseY) && player.getBalance() >= 50) {
			player.obtainTie();
		}
	}

}
