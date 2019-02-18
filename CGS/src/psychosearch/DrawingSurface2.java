package psychosearch;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import ayush.shapes.*;
import btns.*;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class DrawingSurface2 extends PApplet {

	//
	private ArrayList<ImageButton> coins;
	private ArrayList<String> answers;
	private int slide;
	private ArrayList<TextButton> locs;
	private float x, y, radius;
	private final int numOfCoins;
	private int money;
	private int secondstimes60;
	private TextButton[] qslidebuttons;
	private String que;
	
	public DrawingSurface2(ArrayList<String> as, String question) {
		slide = 0;
		qslidebuttons = new TextButton[2];
		que = question;
		secondstimes60 = 1200;
		qslidebuttons[0] = new TextButton(50,500, 200,75, 75, 540, Color.BLACK, Color.WHITE, "Instructions", 25);
		qslidebuttons[1] = new TextButton(550,500, 200,75, 575, 540, Color.BLACK, Color.WHITE, "Play!", 25);
		
		money = 0;
		answers = as;
		numOfCoins = 5;
		x = 400;
		y = 350;
		radius = 100;
		locs = new ArrayList<TextButton>();
		for(String e : answers) {
			//Answers must be less than 100 pixels wide
			float topx = (float)( Math.random() * 600);
			float topy = (float)(Math.random() * 625);
			locs.add(new TextButton(topx, topy, 150,50, topx + 10, topy + 20, Color.black, Color.white, e, 15));
		}
		coins = new ArrayList<ImageButton>();
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		for(int i = 0;i<numOfCoins;i++) {
			coins.add(new ImageButton(loadImage("images\\psychosearch\\coinnw.png"), (float)(Math.random()*740), (float)(Math.random()*640), 50,50));
		}
	}
	
	public void drawQuestion() {
		background(255);
		textSize(25);
		fill(0);
		text(que, 50, 50);
		qslidebuttons[0].draw(this);
		qslidebuttons[1].draw(this);
	}
	
	public void instructions() {
		background(255);
		textSize(50);
		fill(0);
		text("instructions", 100,150);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);
		
		
		switch(slide) {
		case 2:
			for(TextButton e:locs) {
				e.draw(this);
			}
			for(ImageButton e: coins) {
				e.draw(this);
			}
			
			
			
			drawFast();
			
			fill(0,0,255);
			textSize(50);
			text("Time: " + secondstimes60/60, 275,60);
			if(secondstimes60<0) {
				slide = 3;
			}else {
				secondstimes60--;

			}
			break;
		case 0:
			drawQuestion();
			break;
		case 1:
			instructions();
			break;
		case 3:
			lose();
			break;
		case 4:
			win();
			break;
		}
		
	}
	
	public void win() {
		textSize(100);
		fill(0);
		text("won", 30,100);
		text(money ,30,200);

	}
	
	public void lose() {
		textSize(100);
		fill(0);
		text("lose",30,100);
		text(money ,30,200);
	}
	
 	public void drawFast() {
		//background(255);
		Rectangle circle = new Rectangle(x-radius,y-radius,radius*2,radius*2);
		Rectangle left = new Rectangle(0,0,x-radius,700);
		Rectangle right = new Rectangle(x+radius,0,800-(x + radius), 700);
		Rectangle up = new Rectangle(0,0,800,y-radius);
		Rectangle down = new Rectangle(0,y+radius, 800, 700 - (y+radius));
		left.draw(this, new Color(0,0,0));
		right.draw(this, new Color(0,0,0));
		up.draw(this, new Color(0,0,0));
		down.draw(this, new Color(0,0,0));
		for(float px = circle.getX();px<circle.getWidth()+circle.getX();px++) {
			for(float py = circle.getY();py<circle.getHeight()+circle.getY();py++) {
				if(!isInCircle(px,py)) {
					fill(0);
					rect(px,py,1,1);
				}
			}
		}


	}
	
	public boolean isInCircle(float xx, float yy) {
		float xmath = Math.abs(xx-x) * Math.abs(xx-x);
		float ymath = Math.abs(yy-y) * Math.abs(yy-y);

		if(Math.sqrt(xmath+ymath)<radius) {
			return true;
		}else {
			return false;
		}
	}
	

	public void mouseClicked() {
		int mx = mouseX;
		int my = mouseY;
		
		
		if(slide == 0) {
			
			if(qslidebuttons[0].isPointInButton(mx, my)) {

				slide = 1;
			}else if(qslidebuttons[1].isPointInButton(mx, my)) {
				slide = 2;
			}
		}else if(slide == 2) {
			
			
			if(locs.get(0).isPointInButton(mx,my)) {
				slide = 4;//win
			}
			
			for(int i = 1;i<locs.size();i++) {
				if(locs.get(i).isPointInButton(mx, my)) {
					slide = 3;//lose
				}
			}

			for(int i = 0;i<coins.size();i++) {
				if(coins.get(i).isPointInButton(mx, my)) {
					coins.remove(i);
					money++;
				}
			}
		}
		
		
		
	}
	
	public void mouseMoved() {
		
		int px = mouseX;
		int py = mouseY;
		Color col1 = new Color(0,255,255);

		if(slide == 2) {
			for(TextButton e : locs) {
				if(e.isPointInButton(px, py)) {
					e.setBColor(new Color(0,255,255));
				}else {
					e.setBColor(Color.WHITE);
				}
			}
		}else if(slide == 0) {
			if(slide == 0) {
				for(TextButton e:qslidebuttons) {
					if(e.isPointInButton(px, py)) {
						e.setBColor(col1);
					}else {
						e.setBColor(Color.white);
					}
					
				}
			}
		}
		
		

		
		
		
		
	}
	
	
	
	
	public void keyPressed() {
		if(keyCode == KeyEvent.VK_UP) {
			y-= 10;
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			x+=10;
		}else if(keyCode == KeyEvent.VK_LEFT) {
			x-=10;
		}else if(keyCode == KeyEvent.VK_DOWN) {
			y+=10;
		}
		//update();
	}
	
	
}










