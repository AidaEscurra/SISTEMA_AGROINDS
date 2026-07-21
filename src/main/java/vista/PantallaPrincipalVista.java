package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import componentes.JButtonAccesoDirecto;
import componentes.JMenuIntemPersonalizado;
import componentes.JPanelPersonalizado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaPrincipalVista extends JFrame {

	private static final long serialVersionUID = 1L;

	// Usamos tu panel personalizado con la imagen de fondo
	private JPanelPersonalizado panelPersonalizado = new JPanelPersonalizado("fondo_pantalla.jpg");

	// Items de Menú adaptados a tu sistema agroindustrial
	private JMenuIntemPersonalizado mPersonas;
	private JMenuIntemPersonalizado mFuncionarios;
	private JMenuIntemPersonalizado mMateriaPrima;
	private JMenuIntemPersonalizado mProductos;
	private JMenuIntemPersonalizado mProduccion;

	// Botones de Acceso Directo adaptados
	private JButtonAccesoDirecto btnFuncionario;
	private JButtonAccesoDirecto btnMateriaPrima;
	private JButtonAccesoDirecto btnProduccion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipalVista frame = new PantallaPrincipalVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaPrincipalVista() {
		// Configuración básica de la ventana (Tamaño extendido)
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema de Gestión Agroindustrial - Panel Principal");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// 1. MENÚ REGISTROS (Para cargar datos base)
		JMenu mnRegistros = new JMenu("Registros");
		menuBar.add(mnRegistros);

		mPersonas = new JMenuIntemPersonalizado();
		mPersonas.setText("Personas");
		mnRegistros.add(mPersonas);

		mFuncionarios = new JMenuIntemPersonalizado();
		mFuncionarios.setText("Funcionarios");
		mnRegistros.add(mFuncionarios);

		mMateriaPrima = new JMenuIntemPersonalizado();
		mMateriaPrima.setText("Materia Prima");
		mnRegistros.add(mMateriaPrima);

		mProductos = new JMenuIntemPersonalizado();
		mProductos.setBackground(new Color(240, 240, 240));
		mProductos.setText("Productos");
		mnRegistros.add(mProductos);

		// 2. MENÚ MOVIMIENTO / PROCESOS
		JMenu mnMovimientos = new JMenu("Movimientos");
		menuBar.add(mnMovimientos);

		mProduccion = new JMenuIntemPersonalizado();
		mProduccion.setText("Registrar Producción");
		mnMovimientos.add(mProduccion);

		// 3. MENÚS DE CONTROL ESTÁNDAR
		JMenu mnListados = new JMenu("Listados");
		menuBar.add(mnListados);

		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);

		JMenu mnUtilidades = new JMenu("Utilidades");
		menuBar.add(mnUtilidades);

		// CONFIGURACIÓN DEL PANEL DE FONDO
		setContentPane(panelPersonalizado);
		panelPersonalizado.setLayout(null);

		// BOTÓN ACCESO DIRECTO: FUNCIONARIOS
		btnFuncionario = new JButtonAccesoDirecto();
		btnFuncionario.setText("Funcionarios");
		btnFuncionario.setBounds(39, 408, 150, 159);
		panelPersonalizado.add(btnFuncionario);

		// BOTÓN ACCESO DIRECTO: MATERIA PRIMA
		btnMateriaPrima = new JButtonAccesoDirecto();
		btnMateriaPrima.setText("Materia Prima");
		btnMateriaPrima.setBounds(39, 221, 150, 159);
		panelPersonalizado.add(btnMateriaPrima);

		// BOTÓN ACCESO DIRECTO: PRODUCCIÓN
		btnProduccion = new JButtonAccesoDirecto();
		btnProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduccion.setText("Producción");
		btnProduccion.setBounds(40, 34, 149, 159);
		panelPersonalizado.add(btnProduccion);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanelPersonalizado getPanelPersonalizado() {
		return panelPersonalizado;
	}

	public JMenuIntemPersonalizado getmPersonas() {
		return mPersonas;
	}

	public JMenuIntemPersonalizado getmFuncionarios() {
		return mFuncionarios;
	}

	public JMenuIntemPersonalizado getmMateriaPrima() {
		return mMateriaPrima;
	}

	public JMenuIntemPersonalizado getmProductos() {
		return mProductos;
	}

	public JMenuIntemPersonalizado getmProduccion() {
		return mProduccion;
	}

	public JButtonAccesoDirecto getBtnFuncionario() {
		return btnFuncionario;
	}

	public JButtonAccesoDirecto getBtnMateriaPrima() {
		return btnMateriaPrima;
	}

	public JButtonAccesoDirecto getBtnProduccion() {
		return btnProduccion;
	}
}