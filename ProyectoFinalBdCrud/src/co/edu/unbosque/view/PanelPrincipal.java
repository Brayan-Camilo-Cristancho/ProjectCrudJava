package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PanelPrincipal extends JPanel {

	private JButton b_crear, b_buscar, b_borrar, b_actualizar, b_restablecer;
	private JTextField jf_cedula, jf_nombre, jf_buscar;
	private JComboBox<String> jbox_tipocedula, jbox_cargo, jbox_salario;
	private JScrollPane jsp, jsp1, jsp2;
	private JLabel jl_cedula, jl_tipocedula, jl_nombre, jl_salario, jl_cargo, jl_buscar;
	private JTable tab_datos;
	private DefaultTableModel model;

	public PanelPrincipal() {
		setLayout(null);
		inicializarComponentes();

	}

	public void inicializarComponentes() {

		setBackground(new Color(222, 222, 222));
		setBorder(new LineBorder(new Color(190, 255, 237)));

		setBorder(new LineBorder(Color.black));

		jl_cedula = new JLabel("Escriba su cédula: ");
		jl_cedula.setBounds(30, 20, 200, 30);
		jl_cedula.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_cedula);

		jf_cedula = new JTextField();
		jf_cedula.setBackground(Color.white);
		jf_cedula.setFont(new Font(getName(), 12, 12));
		jf_cedula.setBounds(210, 21, 120, 30);
		jf_cedula.setFont(new Font("times new roman", Font.PLAIN, 20));
		jf_cedula.setEditable(true);
		add(jf_cedula);

		jl_tipocedula = new JLabel("Tipo Cédula: ");
		jl_tipocedula.setBounds(30, 80, 200, 30);
		jl_tipocedula.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_tipocedula);

		jbox_tipocedula = new JComboBox<String>();
		jbox_tipocedula.setBackground(Color.white);
		jbox_tipocedula.setFont(new Font(getName(), 12, 12));
		jbox_tipocedula.setBounds(210, 81, 120, 30);
		jbox_tipocedula.addItem("---");
		jbox_tipocedula.addItem("CC");
		jbox_tipocedula.setFont(new Font("times new roman", Font.PLAIN, 20));
		jbox_tipocedula.setEditable(false);
		add(jbox_tipocedula);

		jl_nombre = new JLabel("Escriba su nombre: ");
		jl_nombre.setBounds(380, 80, 360, 30);
		jl_nombre.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_nombre);

		jf_nombre = new JTextField();
		jf_nombre.setBackground(Color.white);
		jf_nombre.setFont(new Font(getName(), 12, 12));
		jf_nombre.setBounds(550, 81, 120, 30);
		jf_nombre.setFont(new Font("times new roman", Font.PLAIN, 20));
		jf_nombre.setEditable(true);
		add(jf_nombre);

		jl_salario = new JLabel("Salario minimo: ");
		jl_salario.setBounds(380, 20, 200, 30);
		jl_salario.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_salario);

		jbox_salario = new JComboBox<String>();
		jbox_salario.setBackground(Color.white);
		jbox_salario.setFont(new Font(getName(), 12, 12));
		jbox_salario.setBounds(550, 21, 120, 30);
		jbox_salario.addItem("---");
		jbox_salario.setFont(new Font("times new roman", Font.PLAIN, 20));
		jbox_salario.setEditable(false);
		add(jbox_salario);

		jl_cargo = new JLabel("Seleccione su cargo: ");
		jl_cargo.setBounds(30, 145, 200, 30);
		jl_cargo.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_cargo);

		jbox_cargo = new JComboBox<String>();
		jbox_cargo.setBackground(Color.white);
		jbox_cargo.setFont(new Font(getName(), 12, 12));
		jbox_cargo.setBounds(210, 145, 459, 30);
		jbox_cargo.addItem("---");
		jbox_cargo.setFont(new Font("times new roman", Font.PLAIN, 20));
		jbox_cargo.setEditable(false);
		jbox_cargo.scrollRectToVisible(getVisibleRect());
		add(jbox_cargo);

		jl_buscar = new JLabel("Buscar: ");
		jl_buscar.setBounds(520, 190, 200, 30);
		jl_buscar.setFont(new Font("times new roman", Font.PLAIN, 20));
		add(jl_buscar);

		jf_buscar = new JTextField();
		jf_buscar.setBackground(Color.white);
		jf_buscar.setFont(new Font(getName(), 12, 12));
		jf_buscar.setBounds(594, 190, 120, 30);
		jf_buscar.setFont(new Font("times new roman", Font.PLAIN, 20));
		jf_buscar.setEditable(true);
		add(jf_buscar);

		b_crear = new JButton("CREAR");
		b_crear.setBounds(710, 10, 110, 30);
		b_crear.setActionCommand("CREAR");
		b_crear.setBackground(Color.white);
		add(b_crear);

		b_actualizar = new JButton("ACTUALIZAR");
		b_actualizar.setBounds(710, 50, 110, 30);
		b_actualizar.setActionCommand("ACTUALIZAR");
		b_actualizar.setBackground(Color.white);
		add(b_actualizar);

		b_borrar = new JButton("BORRAR");
		b_borrar.setBounds(710, 90, 110, 30);
		b_borrar.setActionCommand("BORRAR");
		b_borrar.setBackground(Color.white);
		add(b_borrar);

		b_buscar = new JButton("BUSCAR");
		b_buscar.setBounds(730, 190, 110, 30);
		b_buscar.setActionCommand("BUSCAR");
		b_buscar.setBackground(Color.white);
		add(b_buscar);

		b_restablecer = new JButton("RESTABLECER");
		b_restablecer.setBounds(30, 190, 130, 30);
		b_restablecer.setActionCommand("RESTABLECER");
		b_restablecer.setBackground(Color.white);
		add(b_restablecer);

		model = new DefaultTableModel();
		tab_datos = new JTable();
		tab_datos.setModel(model);
		model.addColumn("SERIAL");
		model.addColumn("TIPO CÉDULA");
		model.addColumn("CÉDULA");
		model.addColumn("NOMBRE COTIZANTE");
		model.addColumn("CARGO");
		model.addColumn("SALARIO");
		tab_datos.setBounds(30, 230, 810, 300);
		tab_datos.getTableHeader().setBackground(Color.orange);
		tab_datos.getTableHeader().setForeground(Color.black);
		tab_datos.getTableHeader().setFont(new Font("times new roman", Font.PLAIN, 15));
		tab_datos.setDefaultEditor(Object.class, null);

		jsp2 = new JScrollPane(tab_datos);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(30, 230, 810, 300);
		jsp2.setBackground(Color.white);
		add(jsp2);

	}

	public JButton getB_crear() {
		return b_crear;
	}

	public void setB_crear(JButton b_crear) {
		this.b_crear = b_crear;
	}

	public JButton getB_buscar() {
		return b_buscar;
	}

	public void setB_buscar(JButton b_buscar) {
		this.b_buscar = b_buscar;
	}

	public JButton getB_borrar() {
		return b_borrar;
	}

	public void setB_borrar(JButton b_borrar) {
		this.b_borrar = b_borrar;
	}

	public JButton getB_actualizar() {
		return b_actualizar;
	}

	public void setB_actualizar(JButton b_actualizar) {
		this.b_actualizar = b_actualizar;
	}

	public JTextField getJf_cedula() {
		return jf_cedula;
	}

	public void setJf_cedula(JTextField jf_cedula) {
		this.jf_cedula = jf_cedula;
	}

	public JTextField getJf_nombre() {
		return jf_nombre;
	}

	public void setJf_nombre(JTextField jf_nombre) {
		this.jf_nombre = jf_nombre;
	}

	public JTextField getJf_buscar() {
		return jf_buscar;
	}

	public void setJf_buscar(JTextField jf_buscar) {
		this.jf_buscar = jf_buscar;
	}

	public JComboBox<String> getJbox_tipocedula() {
		return jbox_tipocedula;
	}

	public void setJbox_tipocedula(JComboBox<String> jbox_tipocedula) {
		this.jbox_tipocedula = jbox_tipocedula;
	}

	public JComboBox<String> getJbox_cargo() {
		return jbox_cargo;
	}

	public void setJbox_cargo(JComboBox<String> jbox_cargo) {
		this.jbox_cargo = jbox_cargo;
	}

	public JComboBox<String> getJbox_salario() {
		return jbox_salario;
	}

	public void setJbox_salario(JComboBox<String> jbox_salario) {
		this.jbox_salario = jbox_salario;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}

	public JScrollPane getJsp1() {
		return jsp1;
	}

	public void setJsp1(JScrollPane jsp1) {
		this.jsp1 = jsp1;
	}

	public JScrollPane getJsp2() {
		return jsp2;
	}

	public void setJsp2(JScrollPane jsp2) {
		this.jsp2 = jsp2;
	}

	public JLabel getJl_cedula() {
		return jl_cedula;
	}

	public void setJl_cedula(JLabel jl_cedula) {
		this.jl_cedula = jl_cedula;
	}

	public JLabel getJl_tipocedula() {
		return jl_tipocedula;
	}

	public void setJl_tipocedula(JLabel jl_tipocedula) {
		this.jl_tipocedula = jl_tipocedula;
	}

	public JLabel getJl_nombre() {
		return jl_nombre;
	}

	public void setJl_nombre(JLabel jl_nombre) {
		this.jl_nombre = jl_nombre;
	}

	public JLabel getJl_salario() {
		return jl_salario;
	}

	public void setJl_salario(JLabel jl_salario) {
		this.jl_salario = jl_salario;
	}

	public JLabel getJl_cargo() {
		return jl_cargo;
	}

	public void setJl_cargo(JLabel jl_cargo) {
		this.jl_cargo = jl_cargo;
	}

	public JLabel getJl_buscar() {
		return jl_buscar;
	}

	public void setJl_buscar(JLabel jl_buscar) {
		this.jl_buscar = jl_buscar;
	}

	public JTable getTab_datos() {
		return tab_datos;
	}

	public void setTab_datos(JTable tab_datos) {
		this.tab_datos = tab_datos;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JButton getB_restablecer() {
		return b_restablecer;
	}

	public void setB_restablecer(JButton b_restablecer) {
		this.b_restablecer = b_restablecer;
	}

}