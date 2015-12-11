package listasJLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListasJLabel extends JFrame {

	private JPanel contentPane;
	private JLabel lblJuan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListasJLabel frame = new ListasJLabel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListasJLabel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton();

		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setPreferredSize(new Dimension(15,15));
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon("C:\\Users\\JESUSHGW10\\git\\ProyectC\\Pruebas\\desconectado.png"));
		button.setBackground(new Color(0,0,0,0));
		panel.add(button, BorderLayout.WEST);
		
		lblJuan = new JLabel("Juan");
		lblJuan.setOpaque(true);
		panel.add(lblJuan);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblJuan.setBackground(new Color(133,224,133));
			}
		});
	}
}
