package controlador;

import java.time.LocalDate;
import java.time.LocalTime;

import interfaces.InterfaceABM;
import util.FechaUtil;
import vista.PersonaVista;

public class PersonaController implements InterfaceABM {
	private PersonaVista vista;
	public PersonaController(PersonaVista personaVista) {
		super();
		this.vista = personaVista;
		this.vista.setInterfaceABM(this);
		
		vista.getTfFecha().setText(FechaUtil.fechaAString(LocalDate.now()));
		
		vista.getTfHora().setText(FechaUtil.horaAString(LocalTime.now()));
		
	}

	@Override
	public void nuevo() {
		System.out.println(vista.getTfFecha().getText());
		
	}

	@Override
	public void editar() {
		System.out.println("editar");
		
	}

	@Override
	public void guardar() {
		System.out.println("Guardar");
		
	}

	@Override
	public void eliminar() {
		System.out.println("Eliminar");
	}

	@Override
	public void cancelar() {
		System.out.println("cancelar");
	}

	@Override
	public void buscar() {
		System.out.println("Buscar");
	}

}

