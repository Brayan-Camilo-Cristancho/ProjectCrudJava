package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.persistence.OperationsDataBase;

public class ClaseY {

	private EmpleadoDao empdao;
	private ArrayList<EmpleadoDto> emp;
	private OperationsDataBase opd;

	public ClaseY() {

		this.empdao = new EmpleadoDao();
		this.emp = new ArrayList<>();
		this.opd = new OperationsDataBase();
	}

	public EmpleadoDao getEmpdao() {
		return empdao;
	}

	public void setEmpdao(EmpleadoDao empdao) {
		this.empdao = empdao;
	}

	public ArrayList<EmpleadoDto> getEmp() {
		return emp;
	}

	public void setEmp(ArrayList<EmpleadoDto> emp) {
		this.emp = emp;
	}

	public OperationsDataBase getOpd() {
		return opd;
	}

	public void setOpd(OperationsDataBase opd) {
		this.opd = opd;
	}

}
