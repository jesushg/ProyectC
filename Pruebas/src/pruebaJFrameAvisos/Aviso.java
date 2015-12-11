package pruebaJFrameAvisos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * Es necesario poner las imágenes para que se vea...
 * @author JESUSHGW10
 *
 */
public class Aviso extends JFrame {

	private static final int xBackground = 183;
	private static final int yBackground = 76;
	private static final int xCloseButton = 12;
	private static final int yCloseButton = 11;
	private static final int yBorder = 115;
	private JLabel text1, background, lblSolucion;
	private JLayeredPane layeredPane;
	private JButton btnX;
	
	Thread animacion;

	public Aviso(String mensaje) {
		setUndecorated(true); //esto quita los marcos
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //esto cierra el jframe al enviar señal de cerrado
		setAlwaysOnTop(true);
		setBounds(100, 100, xBackground, yBackground); // esto pone las medidas, solo la 3º y la 4º.
		setBackground(new Color(0,0,0,0));
	
		layeredPane = new JLayeredPane();
		text1 = new JLabel();
		text1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnX = new JButton();
		background = new JLabel();
		lblSolucion = new JLabel();
		lblSolucion.setVerticalAlignment(SwingConstants.TOP);

		background.setIcon(new ImageIcon("Fondoaviso2.png"));
		background.setBounds(0,0,xBackground,yBackground);

		btnX.setIcon(new ImageIcon("botonaviso.png"));
		btnX.setBackground(new Color(0,0,0,0));
		btnX.setBorderPainted(false);
		btnX.setBounds(6, 9, xCloseButton, yCloseButton);
		btnX.setRolloverIcon(new ImageIcon("botonavisohover.png"));
		
		btnX.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				animacion.interrupt();	// Detiene la animación automática
				int ancho = Toolkit.getDefaultToolkit().getScreenSize().width; // ancho de la pantalla
				int alto = Toolkit.getDefaultToolkit().getScreenSize().height-yBorder; // alto de la pantalla
				
				//Cierra con la animación de cierre
				try {
					for (int i = 0; i < xBackground; i++) {
						Thread.sleep(2);
						setLocation(ancho-xBackground+i, alto);
					}
				} catch (Exception e) {
				}
				Aviso.this.dispose(); // Cierra la ventana
			}
		});
		
		
		// Da formato a la etiqueta
		text1.setText(mensaje);
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setBounds(0, 0, 183, 40);
		
		lblSolucion.setText("tiene una solución");
		lblSolucion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolucion.setBounds(0, 38, 183, 34);
		layeredPane.add(lblSolucion);
		
		layeredPane.add(background, new Integer(1));
		layeredPane.add(text1, new Integer(2));
		layeredPane.add(lblSolucion, new Integer(3));
		layeredPane.add(btnX, new Integer(4));
		
		// Incluye el panel en el jframe
		setContentPane(layeredPane);
		
		

		// Hace las animaciones
		animacion();
	}

	public void animacion() {
		animacion = new Thread(){
			public void run(){
				try {
					int x = Toolkit.getDefaultToolkit().getScreenSize().width; // ancho de la pantalla
					int y = Toolkit.getDefaultToolkit().getScreenSize().height-yBorder; // alto de la pantalla
					
					setLocation(x, y); // establece la localización de la ventana
					setVisible(true); // establece la visibilidad a true, si es false es transparente.
					// Animacion de entrada
					for (int i = 0; i < xBackground; i++) {
						Thread.sleep(2);
						setLocation(x-i, y);
					}
					
					// Espera en milisegundos
					Thread.sleep(3000);
					
					// Animación de salida
					for (int i = 0; i < xBackground; i++) {
						Thread.sleep(2);
						setLocation(x-xBackground+i, y);
					}
					Aviso.this.dispose(); // Cierra la ventana
					
				} catch (Exception e) {
					
				}
			}
		};
		animacion.start();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Aviso("Jesús Hernández"); // Abre una ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
