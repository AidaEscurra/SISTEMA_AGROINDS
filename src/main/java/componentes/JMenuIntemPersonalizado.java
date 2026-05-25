package componentes;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class JMenuIntemPersonalizado extends JMenuItem {

	private static final long serialVersionUID = 1L;
	
	public JMenuIntemPersonalizado() {
		super();
		setOpaque(false);
	}
	
	@Override
	public void setText(String text) {
		cargarIcono(text);
		super.setText(text);
	}

	private void cargarIcono(String icono) {
		try {
			// Añadido "_" antes del 24 -> ejemplo: materia_prima_24.png
			String nombreArchivo = "/iconos/" + icono.toLowerCase().replace(" ", "_") + "_24.png";
			URL url = JMenuIntemPersonalizado.class.getResource(nombreArchivo);
			if (url != null) {
				this.setIcon(new ImageIcon(url));
			} else {
				System.err.println("No se encontro el icono: " + nombreArchivo);
			}
		} catch (Exception e) {
			System.err.println("Error al cargar icono para: " + icono);
		}
	}
}