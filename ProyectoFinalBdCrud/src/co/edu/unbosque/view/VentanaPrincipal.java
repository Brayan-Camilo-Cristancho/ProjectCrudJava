package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	private PanelPrincipal pprincipal;
	private PanelImagen pImagen;
	private JLayeredPane lPane;

	public VentanaPrincipal() {

		setTitle("PROGRAM");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);

		inicializarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void inicializarComponentes() {
		pprincipal = new PanelPrincipal();
		pprincipal.setBounds(5, 5, 873, 550);
		pprincipal.setOpaque(false);
		getContentPane().add(pprincipal);

		lPane = new JLayeredPane();
		lPane.setBounds(0, 0, 3900, 3500);
		getContentPane().add(lPane);

		pImagen = new PanelImagen();
		pImagen.setBounds(0, 0, 1800, 3198);
		pImagen.setOpaque(true);
		lPane.add(pImagen, new Integer(0), 0);
	}

	public void mostrarMensaje(String mensaje) {

		JOptionPane.showMessageDialog(null, mensaje);
	}

	public PanelPrincipal getPprincipal() {
		return pprincipal;
	}

	public void setPprincipal(PanelPrincipal pprincipal) {
		this.pprincipal = pprincipal;
	}

}
