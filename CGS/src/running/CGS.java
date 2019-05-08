package running;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * Class used to run the main program.
 */
public class CGS {

	/**
	 * Screen dimensions
	 */
	public static int width = 800, height = 700;

	/**
	 * Standard Java way to run a program upon opening the .jar or clicking 'run' in
	 * an IDE.
	 */
	public static void main(String args[]) {
		FBLATriviaTester drawing = new FBLATriviaTester();
		drawing.setSize(800, 700);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(width, height);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setIconImage(new ImageIcon("images//fbla.png").getImage());
		window.setVisible(true);
		canvas.requestFocus();
	}

}
