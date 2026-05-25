package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonAccesoDirecto extends JButton {

	private static final long serialVersionUID = 1L;

	public JButtonAccesoDirecto() {
		super();
		setSize(new Dimension(140, 140));
		setMinimumSize(new Dimension(140, 140));
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setForeground(new Color(44, 62, 80));
		
		// Un color blanco con opacidad (180). Para que se note la transparencia en Swing,
		// a veces conviene dejar setOpaque(false) e indicarle al contenedor que lo dibuje,
		// pero con setOpaque(true) funciona bien en la mayoría de los diseños planos.
		setBackground(new Color(255, 255, 255, 180));
		
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setBorderPainted(false);
		setOpaque(true);
		setFocusable(false);
	}
	
	@Override
	public void setText(String text) {
		cargarIcono(text);
		super.setText(text);
	}

	private void cargarIcono(String icono) {
		try {
			// Añadido "_" antes del 64 -> ejemplo: funcionarios_64.png
			String nombreArchivo = "/iconos/" + icono.toLowerCase().replace(" ", "_") + "_64.png";
			URL url = JButtonAccesoDirecto.class.getResource(nombreArchivo);
			if (url != null) {
				this.setIcon(new ImageIcon(url));
			} else {
				System.err.println("No se encontro el icono: " + nombreArchivo);
			}
		} catch (Exception e) {
			System.err.println("Error al cargar icono para el boton: " + icono);
		}
	}
}
