package running;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {

	public static int width = 800, height = 700;

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
		window.setResizable(true);
		window.setIconImage(new ImageIcon("images//fbla.png").getImage());
		window.setVisible(true);
		canvas.requestFocus();
	}

}
