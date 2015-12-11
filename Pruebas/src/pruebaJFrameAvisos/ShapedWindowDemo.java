package pruebaJFrameAvisos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class ShapedWindowDemo extends JFrame {
	public ShapedWindowDemo() {
		super("ShapedWindow");
		setLayout(new GridBagLayout());

		// It is best practice to set the window's shape in
		// the componentResized method. Then, if the window
		// changes size, the shape will be correctly recalculated.
		addComponentListener(new ComponentAdapter() {
			// Give the window an elliptical shape.
			// If the window is resized, the shape is recalculated here.
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new Ellipse2D.Double(0, 0, 1, 1));
			}
		});
		
		

		setUndecorated(true);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JButton("I am a Button"));
	}

	public static void main(String[] args) {

		// Create the GUI on the event-dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ShapedWindowDemo sw = new ShapedWindowDemo();

				// Set the window to 70% translucency, if supported.
				// Display the window.
				sw.setVisible(true);
			}
		});
	}
}
