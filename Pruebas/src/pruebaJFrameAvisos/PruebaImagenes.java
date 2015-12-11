package pruebaJFrameAvisos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PruebaImagenes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaImagenes frame = new PruebaImagenes();
					frame.setVisible(true);
					//Thread.sleep(1000);
					//frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaImagenes() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 450, 300);
		setBackground(new Color(0,0,0,0));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,0,0));
		ImageIcon image = new ImageIcon("web-code2.png");
		JLabel label = new JLabel();
		label.setIcon(image);
		contentPane.add(label);
		setContentPane(contentPane);
		pack();
	}

}
