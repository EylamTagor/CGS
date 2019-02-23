package games.driving;

import javax.swing.JFrame;

import general.Player;
import general.Question;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrivingMain {

	public static void main(String args[]) {
		Player p = new Player();

		// change drawing's type to whatever game you want to run (or duplicate for each
		// game if you want)
		Driving drawing = new Driving(new Question("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "right",
				"wrong1", "wrong2", "wrong3"), p, 0, 5);
		drawing.setSize(800, 700);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		drawing.setFrame(window);

		window.setSize(800, 700);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setVisible(true);
		canvas.requestFocus();
	}
}
