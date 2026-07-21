package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JtextFieldGenerico;
import controlador.PersonaController;
import util.FechaUtil;

public class PersonaVista extends JDialogGenerico {

	private static final long serialVersionUID = 1L;
//Atributos para los campos del formulario
	private JFormattedTextField tfFecha;
	private JtextFieldGenerico tfNombre;
	private JtextFieldGenerico tfApellido;
	private JtextFieldGenerico tfDocumento;
	private JFormattedTextField tfFechaNacimiento;
	private JtextFieldGenerico tfTelefono;
	private JtextFieldGenerico tfCorreo;
	private JtextFieldGenerico tfDireccion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaVista dialog = new PersonaVista();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setControlador();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setControlador() {
		new PersonaController(this);
	}

	public PersonaVista() {
		getPanelFormulario().setSize(483, 573);
		getPanelFormulario().setLocation(38, 101);

		// <--- AGREGADOS: Etiquetas con JLabelGenerico
		JLabelGenerico lblgnrcFecha = new JLabelGenerico((String) null);
		lblgnrcFecha.setText("Fecha Registro:");
		lblgnrcFecha.setBounds(10, 11, 105, 44);
		getPanelFormulario().add(lblgnrcFecha);

		JLabelGenerico lblgnrcNombre = new JLabelGenerico((String) null);
		lblgnrcNombre.setText("Nombre:");
		lblgnrcNombre.setBounds(10, 55, 105, 44);
		getPanelFormulario().add(lblgnrcNombre);

		JLabelGenerico lblgnrcApellido = new JLabelGenerico((String) null);
		lblgnrcApellido.setText("Apellido:");
		lblgnrcApellido.setBounds(10, 100, 105, 44);
		getPanelFormulario().add(lblgnrcApellido);

		JLabelGenerico lblgnrcDocumento = new JLabelGenerico((String) null);
		lblgnrcDocumento.setText("Documento:");
		lblgnrcDocumento.setBounds(10, 143, 105, 44);
		getPanelFormulario().add(lblgnrcDocumento);

		JLabelGenerico lblgnrcFechaNacimiento = new JLabelGenerico((String) null);
		lblgnrcFechaNacimiento.setText("Fecha Nacimiento:");
		lblgnrcFechaNacimiento.setBounds(10, 186, 123, 44);
		getPanelFormulario().add(lblgnrcFechaNacimiento);

		JLabelGenerico lblgnrcTelefono = new JLabelGenerico((String) null);
		lblgnrcTelefono.setText("Telefono:");
		lblgnrcTelefono.setBounds(10, 234, 105, 44);
		getPanelFormulario().add(lblgnrcTelefono);

		JLabelGenerico lblgnrcCorreo = new JLabelGenerico((String) null);
		lblgnrcCorreo.setText("Correo:");
		lblgnrcCorreo.setBounds(10, 282, 105, 44);
		getPanelFormulario().add(lblgnrcCorreo);

		JLabelGenerico lblgnrcDireccion = new JLabelGenerico((String) null);
		lblgnrcDireccion.setText("Direccion:");
		lblgnrcDireccion.setBounds(10, 327, 105, 44);
		getPanelFormulario().add(lblgnrcDireccion);

		// <--- AGREGADOS: Campos de texto en el formulario
		tfFecha = new JFormattedTextField(FechaUtil.getFormatoFecha());
		tfFecha.setBounds(184, 24, 111, 24);
		getPanelFormulario().add(tfFecha);

		tfNombre = new JtextFieldGenerico();
		tfNombre.setBounds(184, 65, 293, 24);
		getPanelFormulario().add(tfNombre);

		tfApellido = new JtextFieldGenerico();
		tfApellido.setBounds(184, 110, 293, 24);
		getPanelFormulario().add(tfApellido);

		tfDocumento = new JtextFieldGenerico();
		tfDocumento.setBounds(184, 153, 187, 24);
		getPanelFormulario().add(tfDocumento);

		tfFechaNacimiento = new JFormattedTextField(FechaUtil.getFormatoFecha());
		tfFechaNacimiento.setBounds(184, 196, 111, 24);
		getPanelFormulario().add(tfFechaNacimiento);

		tfTelefono = new JtextFieldGenerico();
		tfTelefono.setBounds(184, 244, 145, 24);
		getPanelFormulario().add(tfTelefono);

		tfCorreo = new JtextFieldGenerico();
		tfCorreo.setBounds(184, 299, 293, 24);
		getPanelFormulario().add(tfCorreo);

		tfDireccion = new JtextFieldGenerico();
		tfDireccion.setBounds(184, 347, 293, 24);
		getPanelFormulario().add(tfDireccion);
	}

// Getters necesarios para el PersonaController
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JFormattedTextField getTfFecha() {
		return tfFecha;
	}

	public JtextFieldGenerico getTfNombre() {
		return tfNombre;
	}

	public JtextFieldGenerico getTfApellido() {
		return tfApellido;
	}

	public JtextFieldGenerico getTfDocumento() {
		return tfDocumento;
	}

	public JFormattedTextField getTfFechaNacimiento() {
		return tfFechaNacimiento;
	}

	public JtextFieldGenerico getTfTelefono() {
		return tfTelefono;
	}

	public JtextFieldGenerico getTfCorreo() {
		return tfCorreo;
	}

	public JtextFieldGenerico getTfDireccion() {
		return tfDireccion;
	}
}
