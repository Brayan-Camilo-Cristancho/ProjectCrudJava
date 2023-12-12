package co.edu.unbosque.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.EmpleadoDto;

public class OperationsDataBase {

	private ArrayList<EmpleadoDto> emp;

	public ArrayList<EmpleadoDto> dataExtractionEmpleado() {
		emp = new ArrayList<>();
		ConnecToDataBase conex = new ConnecToDataBase();

		try {
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select detalle_nomina.id,e.tpo_documento,e.documento_cotizante ,e.nombre_cotizante, ce.descripcion, sm.valor\r\n"
							+ "from detalle_nomina\r\n"
							+ "         inner join empleado e on detalle_nomina.id_empleado = e.id\r\n"
							+ "         inner join cargo_empleado ce on ce.id = e.id_cargo\r\n"
							+ "         inner join salarios_minimos sm on sm.periodo = detalle_nomina.periodo_salario order by id;");

			while (rs.next()) {

				emp.add(new EmpleadoDto(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), Float.parseFloat(rs.getString(6))));

			}

			stmt.close();
			conex.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public ArrayList<String> dataExtractionCargo() {
		ArrayList<String> cargos = new ArrayList<>();

		ConnecToDataBase conex = new ConnecToDataBase();

		try {
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select descripcion from cargo_empleado;");

			while (rs.next()) {

				cargos.add(rs.getString(1));

			}

			stmt.close();
			conex.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cargos;
	}

	public ArrayList<String> dataExtractionSalario() {
		ArrayList<String> salarios = new ArrayList<>();

		ConnecToDataBase conex = new ConnecToDataBase();

		try {
			Statement stmt;
			stmt = conex.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select valor from salarios_minimos;");

			while (rs.next()) {

				salarios.add(rs.getString(1));

			}

			stmt.close();
			conex.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salarios;
	}

	public ArrayList<EmpleadoDto> getEmp() {
		return emp;
	}

	public void setEmp(ArrayList<EmpleadoDto> emp) {
		this.emp = emp;
	}

}
