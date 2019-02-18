package general.intro;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class CGS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawingSurface2 drawing = new DrawingSurface2();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	

	}

}
