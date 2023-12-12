package co.edu.unbosque.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.persistence.ConnecToDataBase;

public class EmpleadoDao {

	public void crearEmpleado(String cedula, String tipoced, String nombrecot, String cargo, float salario) {

		try {

			ConnecToDataBase conex = new ConnecToDataBase();
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet re = stmt.executeQuery("select id from cargo_empleado where descripcion = " + "'" + cargo + "'");
			re.next();
			String idcargo = re.getString(1);
			stmt.executeUpdate(
					"INSERT INTO empleado(tpo_documento, documento_cotizante, nombre_cotizante, id_cargo, salario_basico)values ("
							+ "'" + tipoced + "'" + "," + "'" + cedula + "'" + "," + "'" + nombrecot + "'" + ","
							+ idcargo + "," + salario + ");");
			ResultSet ro = stmt.executeQuery("select periodo from salarios_minimos where  valor = " + salario + " ;");
			ro.next();
			String periodo = ro.getString(1);

			ResultSet ra = stmt.executeQuery("select id from empleado where documento_cotizante ='" + cedula
					+ "' and nombre_cotizante = '" + nombrecot + "' and id_cargo=" + idcargo);
			ra.next();

			stmt.executeUpdate(
					"insert into detalle_nomina( id_tpocot_subtpocot, id_empleado, periodo, periodo_salario, id_novedad, num_dias_trabajados, num_dias_incapacidad, num_dias_licencia, num_dias_permisos_remunerados, num_dias_permisos_no_remunerados, num_dias_vacaciones, num_dias_huelga, id_porcentaje_salud, id_porcentaje_pension) VALUES (null"
							+ "," + ra.getString(1) + ",null,'" + periodo + "',null,0,0,0,0,0,0,0,null,null);");

			stmt.close();
			conex.desconectar();
			JOptionPane.showMessageDialog(null, "Ha sido agregado con exito");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datos erroneos, reviselos nuevamente");
		}

	}

	public void actualizarEmpleado(String tipoced, String cedula, String nombrecot, String cargo, String salario) {
	if( buscarEmpleado(cedula).size()>=1) {
		
			try {
				ConnecToDataBase conex = new ConnecToDataBase();
				Statement stmt;
				stmt = conex.getConnection().createStatement();
				if (tipoced.equals("---") == false) {
					stmt.executeUpdate("update empleado\r\n" + "SET tpo_documento = " + "'" + tipoced + "'"
							+ "where documento_cotizante = " + "'" + cedula + "'" + ";");

				}

				if (nombrecot.equals("") == false) {
					stmt.executeUpdate("update empleado SET nombre_cotizante = '" + nombrecot
							+ "' where documento_cotizante = " + "'" + cedula + "'" + ";");
				}

				if (cargo.equals("---") == false) {

					ResultSet re = stmt
							.executeQuery("select id from cargo_empleado where descripcion = " + "'" + cargo + "'");
					re.next();

					stmt.executeUpdate("update empleado\r\n" + "SET id_cargo = " + re.getString(1)
							+ "where documento_cotizante = " + "'" + cedula + "'" + ";");
				}

				if (salario.equals("---") == false) {
					ResultSet re = stmt
							.executeQuery("select id from empleado where documento_cotizante = '" + cedula + "';");
					re.next();
					String id = re.getString(1);
					ResultSet ro = stmt
							.executeQuery("select periodo from salarios_minimos where  valor = " + salario + " ;");
					ro.next();
					String periodo = ro.getString(1);
					stmt.executeUpdate(
							"update detalle_nomina set periodo_salario = " + periodo + " where id_empleado =" + id);
				}

				stmt.close();
				conex.desconectar();
				JOptionPane.showMessageDialog(null, "Actualización realizada correctamente");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la actualización verifique los datos o su cédula");
				e.printStackTrace();
			}
	}else {
		JOptionPane.showMessageDialog(null,"Datos no encontrados, verifiquelos nuevamente");
		
	}
	}

	public void borrarEmpleado(String cedula, String nombre) {
		if (verificarEmpleado(cedula, nombre) == true) {
			try {
				ConnecToDataBase conex = new ConnecToDataBase();
				Statement stmt;
				stmt = conex.getConnection().createStatement();
				ResultSet re = stmt
						.executeQuery("select id from empleado where documento_cotizante = '" + cedula + "';");
				re.next();
				stmt.executeUpdate("DELETE FROM detalle_nomina WHERE id =" + re.getString(1));
				stmt.executeUpdate("DELETE FROM empleado WHERE documento_cotizante ='" + cedula
						+ "'and nombre_cotizante = '" + nombre + "';");
				JOptionPane.showMessageDialog(null, "Datos borrados correctamente");
				stmt.close();
				conex.desconectar();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "No se pudo borrar sus datos");
				e.printStackTrace();
			}
		}

	}

	public ArrayList<EmpleadoDto> buscarEmpleado(String cedula) {
		ArrayList<EmpleadoDto> emp = new ArrayList<EmpleadoDto>();
		try {
			ConnecToDataBase conex = new ConnecToDataBase();
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select detalle_nomina.id,e.tpo_documento,e.documento_cotizante ,e.nombre_cotizante, ce.descripcion, sm.valor\r\n"
							+ "from detalle_nomina\r\n"
							+ "         inner join empleado e on detalle_nomina.id_empleado = e.id\r\n"
							+ "         inner join cargo_empleado ce on ce.id = e.id_cargo\r\n"
							+ "         inner join salarios_minimos sm on sm.periodo = detalle_nomina.periodo_salario where e.documento_cotizante= '"
							+ cedula + "';");

			while (rs.next()) {

				emp.add(new EmpleadoDto(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), Float.parseFloat(rs.getString(6))));

			}

			stmt.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la busqueda, verifique sus datos");
			e.printStackTrace();
		}
		return emp;
	}

	public boolean verificarEmpleado(String cedula, String nombre) {
		ArrayList<EmpleadoDto> emp = new ArrayList<EmpleadoDto>();
		boolean existe = true;
		try {
			ConnecToDataBase conex = new ConnecToDataBase();
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select detalle_nomina.id,e.tpo_documento,e.documento_cotizante ,e.nombre_cotizante, ce.descripcion, sm.valor\r\n"
							+ "from detalle_nomina\r\n"
							+ "         inner join empleado e on detalle_nomina.id_empleado = e.id\r\n"
							+ "         inner join cargo_empleado ce on ce.id = e.id_cargo\r\n"
							+ "         inner join salarios_minimos sm on sm.periodo = detalle_nomina.periodo_salario where e.documento_cotizante= '"
							+ cedula + "'" + " and e.nombre_cotizante= " + "'" + nombre + "'");
			rs.next();
			String a=rs.getString(1);
			stmt.close();
			conex.desconectar();

		} catch (SQLException e) {
			existe = false;
			JOptionPane.showMessageDialog(null, "Sus datos no existen");
		}
		return existe;
	}

}
