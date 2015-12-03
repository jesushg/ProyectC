package pruebaJFrameAvisos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Aviso extends JFrame {

	private JPanel contentPane;
	private JLabel text1;

	public Aviso() {
		setUndecorated(true); //esto quita los marcos
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //esto cierra el jframe al enviar señal de cerrado
		setBounds(100, 100, 199, 61); // esto pone las medidas, solo la 3º y la 4º.
		
		// inicializa jcomponentes
		text1 = new JLabel();
		contentPane = new JPanel();
		
		// Da formato a la etiqueta
		text1.setText("Alguien se ha conectado");
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Establece el layout (distribución) al panel
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(text1, BorderLayout.CENTER);
		
		// Incluye el panel en el jframe
		setContentPane(contentPane);
		
		// Hace las animaciones
		animacion();
	}

	public void animacion() {
		Thread animacion = new Thread(){
			public void run(){
				try {
					int ancho = Toolkit.getDefaultToolkit().getScreenSize().width; // ancho de la pantalla
					int alto = Toolkit.getDefaultToolkit().getScreenSize().height-100; // alto de la pantalla
					
					setLocation(ancho, alto); // establece la localización de la ventana
					setVisible(true); // establece la visibilidad a true, si es false es transparente.
					
					// Animacion de entrada
					for (int i = 0; i < 199; i++) {
						Thread.sleep(2);
						setLocation(ancho-i, alto);
					}
					
					// Espera en milisegundos
					Thread.sleep(1000);
					
					// Animación de salida
					for (int i = 0; i < 199; i++) {
						Thread.sleep(2);
						setLocation(ancho-199+i, alto);
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
					new Aviso(); // Abre una ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
