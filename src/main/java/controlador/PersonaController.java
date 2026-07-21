package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JOptionPane;

import dao.PersonaDAO;
import interfaces.InterfaceABM;
import modelo.PersonaModelo;
import tablas.ModeloTablaPersona;
import util.FechaUtil;
import vista.PersonaVista;

public class PersonaController implements InterfaceABM {
	private PersonaVista vista;
	private PersonaDAO dao; 
	private PersonaModelo persona;
	private List<PersonaModelo> personas; 
	private ModeloTablaPersona tabla;
	public PersonaController(PersonaVista personaVista) {
		super();
		this.vista = personaVista;
		this.vista.setInterfaceABM(this);
		
		dao = new PersonaDAO();
		tabla = new ModeloTablaPersona();
		this.vista.getTabla().setModel(tabla);
		estadoInicial();
		cargarTabla("");
		setAcciones();
		

	}
	
	private void setAcciones() {
		this.vista.getTabla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					seleccionarRegistro();
			}
		});
	}
	
	private void cargarTabla(String filtro) {
		personas = dao.buscarPorFiltro(filtro);
		tabla.setLista(personas);
		
	}
		
		private void estadoInicial() {
			// Control de Botones
			this.vista.getBtnNuevo().setEnabled(true);
			this.vista.getBtnEditar().setEnabled(false);
			this.vista.getBtnEliminar().setEnabled(false);
			this.vista.getBtnCancelar().setEnabled(true);
			this.vista.getBtnGuardar().setEnabled(false);

			// Desactivar TextFields
			this.vista.getTfFecha().setEnabled(false);
			this.vista.getTfNombre().setEnabled(false);
			this.vista.getTfApellido().setEnabled(false);
			this.vista.getTfDocumento().setEnabled(false);
			this.vista.getTfFechaNacimiento().setEnabled(false);
			this.vista.getTfCorreo().setEnabled(false);
			this.vista.getTfDireccion().setEnabled(false);
			this.vista.getTfTelefono().setEnabled(false);

			// Limpiar Campos
			this.vista.getTfFecha().setValue(null);
			this.vista.getTfFechaNacimiento().setValue(null);
			this.vista.getTfNombre().setText("");
			this.vista.getTfApellido().setText("");
			this.vista.getTfDocumento().setText("");
			this.vista.getTfCorreo().setText("");
			this.vista.getTfDireccion().setText("");
			this.vista.getTfTelefono().setText("");
			
			persona = null;
		}

	@Override
	public void nuevo() {
		//Habilita botones para nuevo registro
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		this.vista.getBtnGuardar().setEnabled(true);
		
		//CAMBIO: Habilita edición de campos
		this.vista.getTfFecha().setEnabled(false); // La fecha actual no se edita a mano
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfApellido().setEnabled(true);
		this.vista.getTfDocumento().setEnabled(true);
		this.vista.getTfFechaNacimiento().setEnabled(true);
		this.vista.getTfCorreo().setEnabled(true);
		this.vista.getTfDireccion().setEnabled(true);
		this.vista.getTfTelefono().setEnabled(true);
		
		// Instancia el objeto y carga la fecha actual
				persona = new PersonaModelo();
				this.vista.getTfFecha().setText(FechaUtil.fechaAString(LocalDate.now()));
	}
	
	//Carga los datos de la fila seleccionada a los TextFields
	private void seleccionarRegistro() {
		int fila = this.vista.getTabla().getSelectedRow();
		if (fila < 0)
			return;
		
		// extraes la persona seleccionada de la lista personas
		persona = personas.get(fila); 

		// Y en los setters de abajo usa 'persona' (en singular):
		this.vista.getTfFecha().setText(FechaUtil.fechaAString(persona.getFechaRegistro()));
		this.vista.getTfNombre().setText(persona.getNombre());
		this.vista.getTfApellido().setText(persona.getApellido());
		this.vista.getTfDocumento().setText(persona.getDocumento());
		this.vista.getTfTelefono().setText(persona.getTelefono());
		this.vista.getTfCorreo().setText(persona.getCorreo());
		this.vista.getTfFechaNacimiento().setText(FechaUtil.fechaAString(persona.getFechaNacimiento()));
		this.vista.getTfDireccion().setText(persona.getDireccion());
		
		// Mantener los campos deshabilitados (solo lectura por seguridad)
	    this.vista.getTfFecha().setEnabled(false);
	    this.vista.getTfNombre().setEnabled(false);
	    this.vista.getTfApellido().setEnabled(false);
	    this.vista.getTfDocumento().setEnabled(false);
	    this.vista.getTfFechaNacimiento().setEnabled(false);
	    this.vista.getTfCorreo().setEnabled(false);
	    this.vista.getTfDireccion().setEnabled(false);
	    this.vista.getTfTelefono().setEnabled(false);
	    
	 // Estado de botones: Se habilitan EDITAR y ELIMINAR a la vez
	    this.vista.getBtnNuevo().setEnabled(false);
	    this.vista.getBtnEditar().setEnabled(true);  
	    this.vista.getBtnEliminar().setEnabled(true); 
	    this.vista.getBtnGuardar().setEnabled(false);
	    this.vista.getBtnCancelar().setEnabled(true);
	}

	@Override
	public void editar() {
		//Habilita campos para modificar datos
		this.vista.getTfFecha().setEnabled(false);
		this.vista.getTfNombre().setEnabled(true);
		this.vista.getTfApellido().setEnabled(true);
		this.vista.getTfDocumento().setEnabled(true);
		this.vista.getTfFechaNacimiento().setEnabled(true);
		this.vista.getTfCorreo().setEnabled(true);
		this.vista.getTfDireccion().setEnabled(true);
		this.vista.getTfTelefono().setEnabled(true);
		
		this.vista.getBtnNuevo().setEnabled(false);
		this.vista.getBtnEditar().setEnabled(false);
		this.vista.getBtnGuardar().setEnabled(true);
		this.vista.getBtnEliminar().setEnabled(false);
		this.vista.getBtnCancelar().setEnabled(true);
		
	}

	@Override
	public void guardar() {
		//Validación de campo obligatorio
		if(this.vista.getTfNombre().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
			return;
		}
		
		//Asignación de datos al objeto persona
		// Usa 'persona' (en singular) para asignarle los datos:
		persona.setFechaRegistro(FechaUtil.stringAFecha(this.vista.getTfFecha().getText()));
		persona.setFechaNacimiento(FechaUtil.stringAFecha(this.vista.getTfFechaNacimiento().getText()));
		persona.setNombre(this.vista.getTfNombre().getText());
		persona.setApellido(this.vista.getTfApellido().getText());
		persona.setDocumento(this.vista.getTfDocumento().getText());
		persona.setTelefono(this.vista.getTfTelefono().getText());
		persona.setCorreo(this.vista.getTfCorreo().getText());
		persona.setDireccion(this.vista.getTfDireccion().getText());

		try {
		    dao.guardar(persona); 
		    cargarTabla("");
		    estadoInicial();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void eliminar() {
		//Lógica completa de eliminación
		if (persona == null)
			return;
			
		int confirmacion = JOptionPane.showConfirmDialog(null, "Anular o eliminar la persona: "
				+ persona.getNombre() + " " + persona.getApellido() + "?", "Atención", JOptionPane.YES_NO_OPTION);
				
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				dao.eliminar(persona);
				estadoInicial();
				cargarTabla("");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancelar() {
		//botón cancelar
		if (persona == null)
			this.vista.dispose();
		else
			estadoInicial();
	}

	@Override
	public void buscar() {
		//buscador
		cargarTabla(vista.getTfBuscador().getText());
	}

}

