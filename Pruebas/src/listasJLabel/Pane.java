package listasJLabel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Pane extends JPanel{
	
	private JButton button;
	private JLabel label;
	
	public Pane(String lbl){
		
		button = new JButton("X");
		label = new JLabel(lbl);
		
		setLayout(new BorderLayout(0, 0));
		add(button, BorderLayout.WEST);
		add(label, BorderLayout.CENTER);
	}
	
}
