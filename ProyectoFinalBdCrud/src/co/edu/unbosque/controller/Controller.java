package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ClaseY;
import co.edu.unbosque.model.EmpleadoDao;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller implements ActionListener {

	private ClaseY y;
	private VentanaPrincipal vprincipal;

	public Controller() {

		y = new ClaseY();
		vprincipal = new VentanaPrincipal();
		fillData();
		assignListeners();

	}

	public void fillData() {
		y.getOpd().dataExtractionEmpleado();
		for (int i = 0; i < y.getOpd().getEmp().size(); i++) {
			vprincipal.getPprincipal().getModel()
					.addRow(new Object[] { y.getOpd().getEmp().get(i).getSerial(),
							y.getOpd().getEmp().get(i).getTipoCedula(), y.getOpd().getEmp().get(i).getCedula(),
							y.getOpd().getEmp().get(i).getNombrecotizante(), y.getOpd().getEmp().get(i).getCargo(),
							y.getOpd().getEmp().get(i).getSalario() });
		}

		ArrayList<String> cargos = y.getOpd().dataExtractionCargo();

		for (int i = 0; i < cargos.size(); i++) {
			vprincipal.getPprincipal().getJbox_cargo().addItem(cargos.get(i));
		}

		ArrayList<String> salarios = y.getOpd().dataExtractionSalario();

		for (int i = 0; i < salarios.size(); i++) {
			vprincipal.getPprincipal().getJbox_salario().addItem(salarios.get(i));
		}

	}

	public void refreshTable() {
		vprincipal.getPprincipal().getModel().setRowCount(0);
		y.getOpd().dataExtractionEmpleado();
		for (int i = 0; i < y.getOpd().getEmp().size(); i++) {
			vprincipal.getPprincipal().getModel()
					.addRow(new Object[] { y.getOpd().getEmp().get(i).getSerial(),
							y.getOpd().getEmp().get(i).getTipoCedula(), y.getOpd().getEmp().get(i).getCedula(),
							y.getOpd().getEmp().get(i).getNombrecotizante(), y.getOpd().getEmp().get(i).getCargo(),
							y.getOpd().getEmp().get(i).getSalario() });
		}
	}

	public void assignListeners() {
		vprincipal.getPprincipal().getB_crear().addActionListener(this);
		vprincipal.getPprincipal().getB_actualizar().addActionListener(this);
		vprincipal.getPprincipal().getB_borrar().addActionListener(this);
		vprincipal.getPprincipal().getB_buscar().addActionListener(this);
		vprincipal.getPprincipal().getB_restablecer().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("CREAR")) {

			if (vprincipal.getPprincipal().getJf_cedula().getText().isEmpty() == false
					&& vprincipal.getPprincipal().getJbox_tipocedula().getSelectedItem() != "---"
					&& vprincipal.getPprincipal().getJf_nombre().getText().isEmpty() == false
					&& vprincipal.getPprincipal().getJbox_salario().getSelectedItem() != "---"
					&& vprincipal.getPprincipal().getJbox_cargo().getSelectedItem() != "---") {
				try {

					for (int i = 0; i < vprincipal.getPprincipal().getJf_cedula().getText().length(); i++) {

						int a = Integer.parseInt(
								String.valueOf(vprincipal.getPprincipal().getJf_cedula().getText().charAt(i)));

					}

					y.getEmpdao().crearEmpleado(vprincipal.getPprincipal().getJf_cedula().getText(),
							String.valueOf(vprincipal.getPprincipal().getJbox_tipocedula().getSelectedItem()),
							vprincipal.getPprincipal().getJf_nombre().getText(),
							vprincipal.getPprincipal().getJbox_cargo().getSelectedItem().toString(), Float.parseFloat(
									vprincipal.getPprincipal().getJbox_salario().getSelectedItem().toString()));

					refreshTable();

					vprincipal.getPprincipal().getJbox_tipocedula().setSelectedItem("---");
					vprincipal.getPprincipal().getJf_cedula().setText("");
					vprincipal.getPprincipal().getJf_nombre().setText("");
					vprincipal.getPprincipal().getJbox_cargo().setSelectedItem("---");
					vprincipal.getPprincipal().getJbox_salario().setSelectedItem("---");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Número de cédula no valido");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Datos erroneos, reviselos nuevamente");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos \n Cédula,Nombre,Salario,Cargo");
			}

		} else if (arg0.getActionCommand().equals("ACTUALIZAR")) {

			if (vprincipal.getPprincipal().getJf_cedula().getText().equals("") == false) {

				y.getEmpdao().actualizarEmpleado(
						vprincipal.getPprincipal().getJbox_tipocedula().getSelectedItem().toString(),
						vprincipal.getPprincipal().getJf_cedula().getText(),
						vprincipal.getPprincipal().getJf_nombre().getText(),
						vprincipal.getPprincipal().getJbox_cargo().getSelectedItem().toString(),
						vprincipal.getPprincipal().getJbox_salario().getSelectedItem().toString());

				vprincipal.getPprincipal().getJbox_tipocedula().setSelectedItem("---");
				vprincipal.getPprincipal().getJf_cedula().setText("");
				vprincipal.getPprincipal().getJf_nombre().setText("");
				vprincipal.getPprincipal().getJbox_cargo().setSelectedItem("---");
				vprincipal.getPprincipal().getJbox_salario().setSelectedItem("---");
				refreshTable();
			} else {

				JOptionPane.showMessageDialog(null,
						"Para actualizar escriba su número de cédula y llene los campos que desee cambiar");
			}

		} else if (arg0.getActionCommand().equals("BORRAR")) {

			if (vprincipal.getPprincipal().getJf_cedula().getText().equals("") == false
					&& vprincipal.getPprincipal().getJf_nombre().getText().equals("") == false) {

				y.getEmpdao().borrarEmpleado(vprincipal.getPprincipal().getJf_cedula().getText(),
						vprincipal.getPprincipal().getJf_nombre().getText());
				vprincipal.getPprincipal().getJbox_tipocedula().setSelectedItem("---");

				vprincipal.getPprincipal().getJf_cedula().setText("");
				vprincipal.getPprincipal().getJf_nombre().setText("");
				vprincipal.getPprincipal().getJbox_cargo().setSelectedItem("---");
				vprincipal.getPprincipal().getJbox_salario().setSelectedItem("---");
				refreshTable();
			} else {
				JOptionPane.showMessageDialog(null, "Llene los campos de cédula y nombre para borrar los datos");
			}
		} else if (arg0.getActionCommand().equals("BUSCAR")) {

			if (vprincipal.getPprincipal().getJf_buscar().getText().equals("") == false) {
				vprincipal.getPprincipal().getModel().setRowCount(0);
				y.setEmp(y.getEmpdao().buscarEmpleado(vprincipal.getPprincipal().getJf_buscar().getText()));
				for (int i = 0; i < y.getEmp().size(); i++) {
					vprincipal.getPprincipal().getModel()
							.addRow(new Object[] { y.getEmp().get(i).getSerial(), y.getEmp().get(i).getTipoCedula(),
									y.getEmp().get(i).getCedula(), y.getEmp().get(i).getNombrecotizante(),
									y.getEmp().get(i).getCargo(), y.getEmp().get(i).getSalario() });
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe escribir la cédula que quiere buscar");
			}

		} else if (arg0.getActionCommand().equals("RESTABLECER")) {
			refreshTable();
			vprincipal.getPprincipal().getJf_cedula().setText("");
			vprincipal.getPprincipal().getJf_nombre().setText("");
			vprincipal.getPprincipal().getJbox_cargo().setSelectedItem("---");
			vprincipal.getPprincipal().getJbox_salario().setSelectedItem("---");
		}
	}
}