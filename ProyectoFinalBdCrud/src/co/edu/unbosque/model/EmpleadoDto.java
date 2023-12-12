package co.edu.unbosque.model;

public class EmpleadoDto {

	private int serial;
	private String tipoCedula;
	private String cedula;
	private String nombrecotizante;
	private String cargo;
	private float salario;

	public EmpleadoDto(int serial, String tipoCedula, String cedula, String nombrecotizante, String cargo,
			float salario) {
		super();
		this.serial = serial;
		this.tipoCedula = tipoCedula;
		this.cedula = cedula;
		this.nombrecotizante = nombrecotizante;
		this.cargo = cargo;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "EmpleadoDto [serial=" + serial + ", tipoCedula=" + tipoCedula + ", cedula=" + cedula
				+ ", nombrecotizante=" + nombrecotizante + ", cargo=" + cargo + ", salario=" + salario + "]";
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getTipoCedula() {
		return tipoCedula;
	}

	public void setTipoCedula(String tipoCedula) {
		this.tipoCedula = tipoCedula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombrecotizante() {
		return nombrecotizante;
	}

	public void setNombrecotizante(String nombrecotizante) {
		this.nombrecotizante = nombrecotizante;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
